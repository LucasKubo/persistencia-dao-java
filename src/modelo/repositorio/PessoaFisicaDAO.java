package modelo.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.PessoaFisica;

public class PessoaFisicaDAO extends FabricaConexao {
	public int criarPessoaFisica(PessoaFisica p) {
		try {
			PreparedStatement st = conn.prepareStatement(
					"INSERT INTO pessoaFisica (nome, endereco, cep, telefone, renda, situacao, cpf, nascto)"
							+ "VALUES (?,?,?,?,?,?,?,?)");
			
			st.setString(1, p.getNomePessoa());
			st.setString(2, p.getEnderecoPessoa());
			st.setLong(3, p.getCepPessoa());
			st.setString(4,p.getTelefonePessoa());
			st.setDouble(5, p.getRendaPessoa());
			st.setByte(6, p.getSituacaoPessoa());
			st.setLong(7,p.getCpf());
			st.setDate(8, p.getNascto());
			
			ResultSet rs;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 1;
	}
}
