package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMySQL {

	private static final String URL = "jdbc:mysql://localhost:3306/Login_bd";
	private static final String USUARIO = "root";
	private static final String SENHA = "jailson14";

	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(URL, USUARIO, SENHA);
	}
}
