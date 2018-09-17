package entidades;

import java.util.Date;

//HourContract
public class ContratoHora {
	
	private Date date;
	private double valorHora;
	private Integer horas;
	
	public ContratoHora(Date date, double valorHora, Integer horas) {
		this.date = date;
		this.valorHora = valorHora;
		this.horas = horas;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public double valorTotal() {
		return this.valorHora * this.horas;
	}
	
	

}
