package modelo.repositorio;

import java.sql.*;
import java.util.*;

public class FabricaConexao { //Objetivo de conectar os objetos ao banco de dados. Ser� herdada pelos objetos DAO (classe de reposit�rio).
	protected Connection conn; //Segue a interface driver sql connection definido pelo Java

	public FabricaConexao() { //Realiza abertura da conex�o
		try {
			String url = "jdbc:postgresql://localhost/projetodao";//Endere�o de conex�o (principais atributos)
			
			Properties props = new Properties(); //Classe que permite dar propriedades de conex�o com o Banco de dados
			props.setProperty("user", "postgres"); //Define usu�rio
			props.setProperty("password", "admin"); //Passa senha
			props.setProperty("ssl", "false"); //verifica se segue camada de seguran�a
			
			conn = DriverManager.getConnection(url, props); //DriveManager do pacote java.sql encapsula o JDBC do banco importado
			
			System.out.println("Conex�o aberta !");
			
		} catch (Exception e) {
			System.out.println("Erro ao abrir coex�o !" + e.getMessage());
		}
	}

	public void fecharConexao() {//Realiza o fechamento da conex�o
		try {
			this.conn.close();
			System.out.println("Conex�o fechada !");
		} catch (Exception e) {
			System.out.println("Erro ao fechar coex�o !" + e.getMessage());
		}
	}
}
