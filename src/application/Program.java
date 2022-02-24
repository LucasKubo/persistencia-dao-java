package application;

import java.sql.Date;
import modelo.PessoaFisica;
import modelo.repositorio.PessoaFisicaDAO;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PessoaFisica pf = new PessoaFisica("Lucas", "Brazil", 2938195, "1192839849", 10000, 18237849,
					new Date(2002 - 1900, 01, 30));
			PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
			pf.setIdPessoa(pfDAO.criarPessoaFisica(pf));
			System.out.println(pfDAO.recuperarPessoaFisicaPorId(pf.getIdPessoa()));
			pfDAO.fecharConexao();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
