package com.indielens;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		Telas tela = new Telas();
		
		Boolean isRunning = true;
		
		while (isRunning) {
			isRunning = tela.telaPrincipal();
		}

		System.out.println("------------------------");
		System.out.println("Deseja Imprimir os Logs? (S/N)");
		System.out.println("------------------------");
		String letra = leitor.next();
		
		tela.encerrarOperação(letra);
		
		leitor.close();
	}
	
}
