package application;

import modelo.Pessoa;
import modelo.repositorio.PessoaDAO;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa p1 = new Pessoa("Lucas","Av Rio Branco",283429,"11930492",1900.00);
		PessoaDAO pDao = new PessoaDAO();
		
		//p1.setIdPessoa(pDao.criarPessoa(p1));
		System.out.println(p1.getIdPessoa());
		System.out.println(p1.getCepPessoa());
		System.out.println(pDao.recuperarPessoaPorId(10));
		pDao.fecharConexao();
	}

}
