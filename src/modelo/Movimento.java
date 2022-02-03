package modelo;

import java.util.Date;

public class Movimento {
	private int id;
	private Date dataHora;
	private double valor;
	public Movimento(int id, Date dataHora, double valor) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
