package modelo;

public class PessoaJuridica extends Pessoa{
	private long cnpj;
	private String nomeFantasia;
	
	public PessoaJuridica(String nomePessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa,
			double rendaPessoa, long cnpj, String nomeFantasia) {
		super(nomePessoa, enderecoPessoa, cepPessoa, telefonePessoa, rendaPessoa);
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}

	
	public long getCnpj() {
		return cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
}
