package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Controle.util.Alerts;
import application.ConexaoMySQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaLoginController {

	@FXML
	private Button btEntrar;

	@FXML
	private Label ld;

	@FXML
	private TextField txtSenha;

	@FXML
	private TextField txtUsuario;

	@FXML
	private PasswordField PsSenha;

	@FXML
	private CheckBox CheckboxSenha;

	@FXML
	void obbtEntrarAction(ActionEvent event) {
		String usuario = txtUsuario.getText();
		String senha = txtSenha.getText();

		try (Connection conn = ConexaoMySQL.getConnection()) {
			String sql = "SELECT * FROM  usuarios WHERE usuario = ? AND senha = ?";
			PreparedStatement stms = conn.prepareStatement(sql);
			stms.setString(1, usuario);
			stms.setString(2, senha);

			ResultSet rs = stms.executeQuery();

			if (rs.next()) {
				// Alerts.showAlerts(null, "login bem sucedido!", null, AlertType.CONFIRMATION);

				btEntrar.getScene().getWindow().hide();
				Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(root);

				stage.setScene(scene);
				stage.setTitle("Tela menu |Sistema");
				stage.centerOnScreen();
				stage.setMaximized(true);
				stage.show();

			} else {
				Alerts.showAlerts(null, "Usuario ou Senha incorretos!", null, AlertType.ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Alerts.showAlerts(null, "Erro na conexão com banco! ", null, AlertType.ERROR);
		}

	}

	@FXML
	private void onCheckboxSenhaAction() {
		if (CheckboxSenha.isSelected()) {
			txtSenha.setText(PsSenha.getText());
			txtSenha.setVisible(true);
			PsSenha.setVisible(false);
		} else {
			PsSenha.setText(txtSenha.getText());
			PsSenha.setVisible(true);
			txtSenha.setVisible(false);

		}
	}

}
