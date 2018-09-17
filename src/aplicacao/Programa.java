package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.ContratoHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		ContratoHora cHora;
		
		System.out.print("Digite o departamento:");
		String dp = sc.nextLine();
		System.out.println("Entre com os dados do colaborador:");
		System.out.print("Nome:");		
		String nome = sc.nextLine();
		System.out.print("Nível (Junior / Pleno / Senior):");		
		String nivel = sc.nextLine().toUpperCase();
		System.out.print("Salário base:");		
		double salBase = sc.nextDouble();
		
		Trabalhador tb = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salBase, new Departamento(dp));
				
		System.out.print("Quantos contratos tem este colaborador?:");		
		int qtdContratos = sc.nextInt();
		int nVisual = 1;
		while(qtdContratos > 0) {
			
			
			System.out.println(nVisual+"º contrato, informe os dados:");		
			System.out.print("Data (DD/MM/YYYY):");	
			String dataTexto = sc.next();
			//sdf para formatar a data
			Date data = sdf.parse(dataTexto);
			System.out.print("Valor da hora:");		
			double valorHora = sc.nextDouble();
			System.out.print("Quantidade de horas em números inteiros:");
			int duracaoHoras = sc.nextInt();
			
			
			cHora = new ContratoHora(data, valorHora, duracaoHoras);
			tb.addContrato(cHora);
			
			nVisual++;
			qtdContratos--;
		}
		
		System.out.println();
		System.out.print("Informe mês e ano para calcular a renda (MM/YYYY):");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Nome: "+ tb.getNome());
		System.out.println("Nome: "+ tb.getDepartamento().getNome());
		System.out.print("Renda de "+ mesEAno +": R$" + String.format("%.2f", tb.renda(ano, mes)));
		
		
		
		
		
		sc.close();
		
	}

}
