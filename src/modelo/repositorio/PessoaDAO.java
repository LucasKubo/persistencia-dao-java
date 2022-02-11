package modelo.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Pessoa;
import modelo.PessoaFisica;

//Estende para poder abrir e fechar conex�o no programa principal
public abstract class PessoaDAO extends FabricaConexao {
	//Encapsulamento do m�todo para que n�o seja utilizado de maneira indevida
	protected int criarPessoa(Pessoa pessoa) {
		int id = 0;

		try {
			// Encapsulando Query
			PreparedStatement ps = super.conn
					.prepareStatement("INSERT INTO pessoas (nome,endereco,cep,telefone,renda,situacao)"
							+ "VALUES (?,?,?,?,?,?) RETURNING id");

			// Parametrizando Query
			ps.setString(1, pessoa.getNomePessoa());
			ps.setString(2, pessoa.getEnderecoPessoa());
			ps.setLong(3, pessoa.getCepPessoa());
			ps.setString(4, pessoa.getTelefonePessoa());
			ps.setDouble(5, pessoa.getRendaPessoa());
			ps.setByte(6, pessoa.getSituacaoPessoa());

			// Declarando objeto result
			ResultSet rs = ps.executeQuery();

			// Pegando valor do Id da pessoa criada
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return id;
	}

	public Pessoa recuperarPessoaPorId(int id) {

		Pessoa pessoa = new Pessoa();

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM pessoas WHERE id = ?"); // Encapsulando a
																								// cl�usula

			ps.setInt(1, id);// Passando valores da cl�usula

			ResultSet rs = ps.executeQuery();// Armazena o valor da consulta / ps -> Tamb�m executa a query

			if (rs.next()) { // rs.next() -> retorna True se tiver algum resultado e False se n�o tiver
				// Atribuindo valores encontrados pela query �s propriedades do objeto
				pessoa.setIdPessoa(rs.getInt(1));
				pessoa.setNomePessoa(rs.getString(2));
				pessoa.setEnderecoPessoa(rs.getString(3));
				pessoa.setCepPessoa(rs.getInt(4));
				pessoa.setTelefonePessoa(rs.getString(5));
				pessoa.setRendaPessoa(rs.getDouble(6));
				pessoa.setSituacaoPessoa(rs.getByte(7));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return pessoa;

	}

	public ArrayList<Pessoa> recuperarPessoas() {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM pessoas");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setIdPessoa(rs.getInt(1));
				pessoa.setNomePessoa(rs.getString(2));
				pessoa.setEnderecoPessoa(rs.getString(3));
				pessoa.setCepPessoa(rs.getLong(4));
				pessoa.setTelefonePessoa(rs.getString(5));
				pessoa.setRendaPessoa(rs.getDouble(6));
				pessoa.setSituacaoPessoa(rs.getByte(7));

				pessoas.add(pessoa);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return pessoas;
	}

	public int editarPessoa(Pessoa pessoa) {
		int id = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE pessoas SET nome = ?, endereco = ?, cep = ?, telefone = ?, renda = ?, situacao = ? WHERE id = ?");

			ps.setString(1, pessoa.getNomePessoa());
			ps.setString(2, pessoa.getEnderecoPessoa());
			ps.setLong(3, pessoa.getCepPessoa());
			ps.setString(4, pessoa.getTelefonePessoa());
			ps.setDouble(5, pessoa.getRendaPessoa());
			ps.setByte(6, pessoa.getSituacaoPessoa());
			ps.setInt(7, pessoa.getIdPessoa());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
	}

	public int removerPessoa(Pessoa pessoa) {
		int id = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM pessoas WHERE id = ?");
			ps.setInt(1, pessoa.getIdPessoa());
			id = pessoa.getIdPessoa();
			ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return id;
	}
}
