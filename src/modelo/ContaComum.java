package modelo;

import java.util.Date;
import java.util.Random;

public class ContaComum {
	protected long numero;
	protected Date abertura;
	protected String fechamento;
	protected byte situacao;
	protected int senha;
	protected double saldo;
	private Random ranNum;
	
	public ContaComum(String fechamento, int senha) {
		this.numero = ranNum.nextLong();
		this.abertura = new Date();
		this.fechamento = fechamento;
		this.situacao = 1;
		this.senha = senha;
		this.saldo = 0;
	}
	
	public ContaComum(String fechamento, int senha, double saldo) {
		this.numero = ranNum.nextLong();
		this.abertura = new Date();
		this.fechamento = fechamento;
		this.situacao = 1;
		this.senha = senha;
		this.saldo = saldo;
	}

	public long getNumero() {
		return numero;
	}

	public Date getAbertura() {
		return abertura;
	}

	public String getFechamento() {
		return fechamento;
	}

	public void setFechamento(String fechamento) {
		this.fechamento = fechamento;
	}

	public byte getSituacao() {
		return situacao;
	}

	public void setSituacao(byte situacao) {
		this.situacao = situacao;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	//Criar uma conta poupança ou especial
	public ContaComum abrirConta() {
		return abrirConta();
	}
}
