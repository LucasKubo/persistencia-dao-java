package application;

import modelo.Pessoa;
import modelo.PessoaFisica;
import modelo.repositorio.PessoaDAO;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa p2 = new Pessoa("Davi","Japan",1023941,"1191582593",10000);
		PessoaDAO pDao = new PessoaDAO();
		
		pDao.criarPessoa(p2);
		p2.setIdPessoa(pDao.recuperarPessoaPorId(2).getIdPessoa());
		//pDao.editarPessoa(p2);
		//pDao.removerPessoa(p2);
		System.out.println(pDao.recuperarPessoas());
		
		pDao.fecharConexao();
	}

}
