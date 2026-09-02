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

		tela.encerrarOperacao(leitor);
		
		leitor.close();
	}
	
}
