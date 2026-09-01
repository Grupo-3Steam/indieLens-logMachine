package com.indielens;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Telas {
	
	List<String> logs = new ArrayList<String>();
	Boolean estaLogado = false;

	public void ImprimirMensagens(Integer mensagem) {
		if (mensagem == null || mensagem < 0) {
			return;
		}
		
		switch (mensagem) {
		case 1: {
			System.out.println("---< Bem Vindo a Indie Lens! >---");
			System.out.println("Selecione uma das opções a baixo para continuar:");
			System.out.println("1. Acessar Página Institucional");
			System.out.println("2. Acessar Sobre nós");
			System.out.println("3. Acessar Página de Conta");
			System.out.println("4. Sair da página");
			System.out.println("---------------------------------");
			System.out.print("Seleção: ");
			break;
		}
		case 4: {
			System.out.println("---< Bem Vindo de Volta! >---");
			System.out.println("Selecione a opção a qual deseja realizar:");
			System.out.println("1. Login");
			System.out.println("2. Cadastro");
			System.out.println("3. Voltar");
			System.out.println("-----------------------------");
			System.out.print("Seleção: ");
			break;
		}
		case 5: {
			System.out.println("---< Bem Vindo de Volta! >---");
			System.out.println("Para realizar o Login Insira seu email:");
			System.out.println("-----------------------------");
			System.out.print("email: ");
			break;
		}
		
		default:
			System.err.println("Opção Inválida.");
			break;
		}
	}
	
	public boolean telaPrincipal () {
		Scanner leitor = new Scanner(System.in);
		
		ImprimirMensagens(1);
		Integer opcao = leitor.nextInt();
		
		return selecaoOpcao(opcao);
	}
	
	public boolean selecaoOpcao (Integer opcao) {
		if (opcao == null || opcao > 4 || opcao < 1) {
			System.err.println("Opção Inválida Tente Novamente.");
		}
		
		switch (opcao) {
			case 1 : { 
				telaInstitucional(); 
				break;
			}
			case 2 : { 
				telaSobreNos(); 
				break; 		
			}
			case 3 : { 
				Conta();
				break;
			}
			case 4 : {
				return false;
			}
		}
		return true;
	}
	
	public void telaInstitucional() {
		System.out.println("Work in progress");
	}
	
	public void telaSobreNos() {
		System.out.println("Work in progress");		
	}

	public void Conta() {
		Telas tela = new Telas();
		Scanner leitorConta = new Scanner(System.in);
		ImprimirMensagens(4);
		Integer opcaoConta = leitorConta.nextInt();
		
		switch (opcaoConta) {
		case 1: {
			login(leitorConta);
			break;
		}
		case 2: {
			System.out.println("Cadastro");
			break;
		}
		case 3: {
			break;
		}
		default:
			System.err.println("Opção Inválida, tente novamente.");
			Conta();
			break;
		}
	}
	
	public void login(Scanner leitorConta) {
		if (estaLogado) {
			System.err.println("Você já está logado!");
			telaPrincipal();
		} else {
			ImprimirMensagens(5);
			String usuario = leitorConta.next();
			
			System.out.println("Agora Insira sua Senha:");
			System.out.println("-----------------------------");
			System.out.print("senha: ");
			
			String senha = leitorConta.next();
			
			if (usuario.equals("admin") && senha.equals("123")) {
				estaLogado = true;
				System.out.println("-----------------------------");
				System.out.println("Bem vindo " + usuario);
				System.out.println("");
			} else {
				System.err.println("usuario inválido");
			}
		}
	}
	
	public void gerarLog() {
		
	}
	
	public void invocarLogs() {
		System.out.println("----< Histórico de ações >----");
		for (int i = 0; i < logs.size(); i++) {
			System.out.println(logs.get(i));
		}
		System.out.println("------------------------------");
	}
	
	public void encerrarOperação(String confirmação) {
		if (confirmação.charAt(0) == 'S' || confirmação.charAt(0) == 's') {
			invocarLogs();
		} else {
			System.out.println("Volte Sempre!");
		}
	}
	
	//TODO
	//gerador de logs
	//formato: [data] : ação
	//log após cada ação
	// institucional
	// sobrenos
}
