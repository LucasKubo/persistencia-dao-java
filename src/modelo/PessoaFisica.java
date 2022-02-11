package modelo;

import java.sql.Date;

public class PessoaFisica extends Pessoa{
	private long cpf;
	private Date nascto;
	
	public PessoaFisica() {}

	public PessoaFisica(String nomePessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa,
			double rendaPessoa, long cpf, Date nascto) {
		super(nomePessoa, enderecoPessoa, cepPessoa, telefonePessoa, rendaPessoa);
		this.cpf = cpf;
		this.nascto = nascto;
	}

	public long getCpf() {
		return cpf;
	}
	
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	public Date getNascto() {
		return nascto;
	}

	public void setNascto(Date nascto) {
		this.nascto = nascto;
	}
}
