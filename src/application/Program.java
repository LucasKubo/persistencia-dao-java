package application;

import java.sql.Date;
import java.sql.SQLException;

import modelo.PessoaFisica;
import modelo.repositorio.PessoaFisicaDAO;

public class Program {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
			PessoaFisica pf1 = new PessoaFisica("Lucas", "Brasil", 00001112, "112233445", 5000, 192304, new Date(2002-1900, 01, 30));
			PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
			pf1.setIdPessoa(pfDao.criarPessoaFisica(pf1));
			System.out.println(pfDao.recuperarPessoaFisicaPorId(pf1.getIdPessoa()));
			pfDao.fecharConexao();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
