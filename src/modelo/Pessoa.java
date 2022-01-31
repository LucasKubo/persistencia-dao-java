package modelo;

abstract public class Pessoa {
	
	protected int idPessoa;
	protected String nomePessoa;
	protected String enderecoPessoa;
	protected long cepPessoa;
	protected String telefonePessoa;
	protected double rendaPessoa;
	protected byte situacaoPessoa;
	
	public Pessoa() {
		this.situacaoPessoa = 0;
	}
	
	public Pessoa(String nomePessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa,
			double rendaPessoa) {
	
		this.nomePessoa = nomePessoa;
		this.enderecoPessoa = enderecoPessoa;
		this.cepPessoa = cepPessoa;
		this.telefonePessoa = telefonePessoa;
		this.rendaPessoa = rendaPessoa;
		this.situacaoPessoa = 0;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getEnderecoPessoa() {
		return enderecoPessoa;
	}

	public void setEnderecoPessoa(String enderecoPessoa) {
		this.enderecoPessoa = enderecoPessoa;
	}

	public long getCepPessoa() {
		return cepPessoa;
	}

	public void setCepPessoa(long cepPessoa) {
		this.cepPessoa = cepPessoa;
	}

	public String getTelefonePessoa() {
		return telefonePessoa;
	}

	public void setTelefonePessoa(String telefonePessoa) {
		this.telefonePessoa = telefonePessoa;
	}

	public double getRendaPessoa() {
		return rendaPessoa;
	}

	public void setRendaPessoa(double rendaPessoa) {
		this.rendaPessoa = rendaPessoa;
	}

	public byte getSituacaoPessoa() {
		return situacaoPessoa;
	}

	public void setSituacaoPessoa(byte situacaoPessoa) {
		this.situacaoPessoa = situacaoPessoa;
	}

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nomePessoa=" + nomePessoa + ", enderecoPessoa=" + enderecoPessoa
				+ ", cepPessoa=" + cepPessoa + ", telefonePessoa=" + telefonePessoa + ", rendaPessoa=" + rendaPessoa
				+ ", situacaoPessoa=" + situacaoPessoa + "]";
	}
}
