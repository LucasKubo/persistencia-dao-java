package modelo;

public class ContaEspecial extends ContaComum{
	private double limite;

	public ContaEspecial(String fechamento, int senha, double limite) {
		super(fechamento, senha);
		this.limite = limite;
	}
	
	public ContaEspecial(String fechamento, int senha, double saldo, double limite) {
		super(fechamento, senha, saldo);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
}
