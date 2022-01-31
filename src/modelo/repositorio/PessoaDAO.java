package modelo.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Pessoa;

//Estende para poder abrir e fechar conexão no programa principal
public class PessoaDAO extends FabricaConexao{ 
	
	public int criarPessoa (Pessoa pessoa) {
		int id = 0;
		
		try {
			//Encapsulando Query
			PreparedStatement st = conn.prepareStatement("INSERT INTO pessoas (nome,endereco,cep,telefone,renda,situacao)" 
			+ "VALUES (?,?,?,?,?,?) RETURNING id");
			
			//Parametrizando Query
			st.setString(1, pessoa.getNomePessoa());
			st.setString(2, pessoa.getEnderecoPessoa());
			st.setLong(3, pessoa.getCepPessoa());
			st.setString(4, pessoa.getTelefonePessoa());
			st.setDouble(5, pessoa.getRendaPessoa());
			st.setByte(6, pessoa.getSituacaoPessoa());
			
			//Declarando objeto result
			ResultSet rs = st.executeQuery();
			
			//Pegando valor do Id da pessoa criada
			if(rs.next()) {
				id = rs.getInt(1);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return id;
	}
	
	public Pessoa recuperarPessoaPorId (int id){
		
		Pessoa pessoa = new Pessoa();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM pessoas WHERE id = ?"); //Encapsulando a cláusula
			
			ps.setInt(1,id);//Passando valores da cláusula
			
			ResultSet rs = ps.executeQuery();//Armazena o valor da consulta / ps -> Também executa a query
			
			if(rs.next()) { //rs.next() -> retorna True se tiver algum resultado e False se não tiver
				//Atribuindo valores encontrados pela query às propriedades do objeto
				pessoa.setIdPessoa(rs.getInt(1)); 
				pessoa.setNomePessoa(rs.getString(2));
				pessoa.setEnderecoPessoa(rs.getString(3));
				pessoa.setCepPessoa(rs.getInt(4));
				pessoa.setTelefonePessoa(rs.getString(5));
				pessoa.setRendaPessoa(rs.getDouble(6));
				pessoa.setSituacaoPessoa(rs.getByte(7));
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return pessoa;
		
	}
}
