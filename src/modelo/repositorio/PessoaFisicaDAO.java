package modelo.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Pessoa;
import modelo.PessoaFisica;

public class PessoaFisicaDAO extends PessoaDAO {
	public int criarPessoaFisica(PessoaFisica p) throws SQLException{
		int id = 0;
		try {
			//Baseando-se no conceito de Transa��o (erro de incompatibilidade de dados podem ocorre), 
			super.conn.setAutoCommit(false); //Evita que ao executar a query (excuteQuery(), execute()) ocorra o commit automaticamente, dessa forma o commit dever� ser feito manualmente
			//Registra uma pessoa no BDD e retorna o Id
			id = super.criarPessoa(p);
			//Valida se a pessoa foi registrada
			if(id != 0) {
				p.setIdPessoa(id);
				//Prepara��o para registrar na tabela pessoafisica
				PreparedStatement ps = super.conn.prepareStatement("INSERT INTO pessoasfisicas (id,cpf,nascto)" + "VALUES(?,?,?)");
				
				ps.setInt(1, p.getIdPessoa());
				ps.setLong(2,p.getCpf());
				ps.setDate(3, p.getNascto());
				
				//Apenas executando, pois n�o ser� utilizado nenhum dado inv�lido
				ps.execute();
				
				//Realizando commit 
				super.conn.commit();
			}
		} catch (Exception e) {
			System.out.println("N�o foi poss�vel registrar uma pessoa f�sica devido ao erro: " + e.getMessage());
			//Caso haja uma exce��o, ser� necess�rio desfazer (rollback) o registro na tabela pessoas
			super.conn.rollback();
			id = 0;
		}
		return id;
	}
	public PessoaFisica recuperarPessoaFisicaPorId(int id) {
		PessoaFisica pf = null;
		try {
			Pessoa p = new PessoaFisica();
			super.recuperarPessoaPorId(id,p);
			
			pf = new PessoaFisica(p.getNomePessoa(), p.getEnderecoPessoa(), p.getCepPessoa(), p.getTelefonePessoa(), p.getRendaPessoa(), 0l, null);
			int idPessoaFisica = p.getIdPessoa();
			
			PreparedStatement ps = super.conn.prepareStatement("SELECT * FROM pessoasfisicas WHERE (id = ?)");
			ps.setInt(1,idPessoaFisica);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				pf.setIdPessoa(rs.getInt(1));
				pf.setCpf(rs.getLong(2));
				pf.setNascto(rs.getDate(3));
			}
		} catch (Exception e) {
			System.out.println("Erro ao recuperar pessoa por Id, causa: " + e.getMessage());
			e.printStackTrace();
		}
		return pf;
	}
	@Override
	public ArrayList<Pessoa> recuperarPessoas() {
		// TODO Auto-generated method stub
		return null;
	}
}
