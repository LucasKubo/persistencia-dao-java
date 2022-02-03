package modelo;

import java.util.Date;

public class ContaPoupanca extends ContaComum{
	private Date aniversario;

	public ContaPoupanca(String fechamento, int senha, Date aniversario) {
		super(fechamento, senha);
		this.aniversario = aniversario;
	}

	public ContaPoupanca(String fechamento, int senha, double saldo, Date aniversario) {
		super(fechamento, senha, saldo);
		this.aniversario = aniversario;
	}

	public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}
}
