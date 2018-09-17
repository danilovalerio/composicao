package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelTrabalhador;

public class Trabalhador {
	
	private String nome;
	private NivelTrabalhador nivel;
	private double salarioBase;
	private Departamento departamento;
	
	//Nenhum tipo de lista não é incluso no construtor
	private List<ContratoHora> contratos = new ArrayList<>();
	
	public Trabalhador(String nome, NivelTrabalhador nivel, double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	@Override
	public String toString() {
		return "Trabalhador [nome=" + nome + ", nivel=" + nivel + ", salarioBase=" + salarioBase + "]";
	}
	
	public void addContrato(ContratoHora contrato) {
		contratos.add(contrato);
	}
	
	public void removeContrato(ContratoHora contrato) {
		contratos.remove(contrato);
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	//income in english
	public double renda(int ano, int mes) {
		
		double soma = salarioBase;
		//instancia que irá trabalhar com a data do contrato c
		Calendar cal = Calendar.getInstance();
		
		for(ContratoHora c : contratos) {
			//cal recebe a data do contrato c
			cal.setTime(c.getDate());

			int c_ano = cal.get(Calendar.YEAR);
			//acrescentamos mais 1, pois o mes de Calendar inicia em 0 (zero)
			int c_mes = 1 + cal.get(Calendar.MONTH);
			
			if(c_ano == ano && c_mes == mes) {
				soma += c.valorTotal();
			}
		}
		
		return soma;
	}
	
	
	
	
	
	

}
