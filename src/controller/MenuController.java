package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController {

	@FXML
	private AnchorPane conteudoPane;

	@FXML
	private MenuBar menuBar;

	public void close() {
		System.exit(0);

	}

	private void carregarTela(String fxmlFile, String tituloFuncionalidade) {
		try {
			Parent fxml = FXMLLoader.load(getClass().getResource(fxmlFile));
			conteudoPane.getChildren().clear();
			conteudoPane.getChildren().add(fxml);

			AnchorPane.setTopAnchor(fxml, 0.0);
			AnchorPane.setBottomAnchor(fxml, 0.0);
			AnchorPane.setLeftAnchor(fxml, 0.0);
			AnchorPane.setRightAnchor(fxml, 0.0);

			Scene cena = conteudoPane.getScene();

			if (cena != null) {
				Stage stage = (Stage) cena.getWindow();
				stage.setTitle("Tela menu |Sistema" + tituloFuncionalidade);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loggout() {
		/*
		 * try {
		 * 
		 * 
		 * }catch{
		 * 
		 * }
		 */
	}

}
