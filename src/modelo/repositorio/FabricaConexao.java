package modelo.repositorio;

import java.sql.*;
import java.util.*;

public class FabricaConexao { //Objetivo de conectar os objetos ao banco de dados. Serï¿½ herdada pelos objetos DAO (classe de repositï¿½rio).
	protected Connection conn; //Segue a interface driver sql connection definido pelo Java

	public FabricaConexao() { //Realiza abertura da conexï¿½o
		try {
			String url = "jdbc:postgresql://localhost/projetodao";//Endereï¿½o de conexï¿½o (principais atributos)
			
			Properties props = new Properties(); //Classe que permite dar propriedades de conexï¿½o com o Banco de dados
			props.setProperty("user", "postgres"); //Define usuário
			props.setProperty("password", "admin"); //Passa senha
			props.setProperty("ssl", "false"); //verifica se segue camada de seguranï¿½a
			
			conn = DriverManager.getConnection(url, props); //DriveManager do pacote java.sql encapsula o JDBC do banco importado
			
			System.out.println("Conexão aberta !");
			
		} catch (Exception e) {
			System.out.println("Erro ao abrir conexão !" + e.getMessage());
		}
	}

	public void fecharConexao() {//Realiza o fechamento da conexão
		try {
			this.conn.close();
			System.out.println("Conexão fechada !");
		} catch (Exception e) {
			System.out.println("Erro ao fechar coexão !" + e.getMessage());
		}
	}
}
