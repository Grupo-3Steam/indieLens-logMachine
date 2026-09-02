package com.indielens;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Telas {
	
	List<String> logs = new ArrayList<String>();
	Boolean estaLogado = false;
	String user = "admin";
	String passkey = "123";

	public void ImprimirMensagens(Integer mensagem) {
		if (mensagem == null || mensagem < 0) {
			return;
		}
		
		switch (mensagem) {
		case 1: {
			gerarLog("acessou seleção de página");
			System.out.println("");
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
		
		case 2: {
			gerarLog("acessou página Institucional");
			System.out.println("-----< Institucional >-----");
			System.out.println("A IndieLens é uma plataforma de inteligência de mercado projetada para transformar dados brutos da indústria de games em decisões estratégicas.");	
			System.out.println("A partir da análise de mais de 130 mil registros da Steam,");
			System.out.println("temos como objetivo transformar dados brutos em indicadores, comparações e recomendações estratégicas");
			System.out.println("para apoiar a tomada de decisão no ciclo de desenvolvimento de novos jogos");
			System.out.println("-----------------------------");
			System.out.println("Digite 1 para retornar a tela principal");
			System.out.print("Seleção: ");
			break;
		}
		
		case 3: {
			gerarLog("acessou página sobre nós");
			System.out.println("-----< Quem nós somos? >-----");
			System.out.println("Nosso objetivo é guiar desenvolvedores independentes na criação e posicionamento de seus títulos com menor risco comercial,");	
			System.out.println("além de auxiliar criadores de conteúdo e streamers a identificar nichos em ascensão longe da saturação dos grandes estúdios.");
			System.out.println("");
			System.out.println("> Tome Decisões criativas, agora orientadas por dados.");
			System.out.println("");
			System.out.println("-----------------------------");
			System.out.println("Digite 1 para retornar a tela principal");
			System.out.print("Seleção: ");
			break;
		}
		case 4: {
			gerarLog("acessou página de contas");
			System.out.println("");
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
			gerarLog("iniciou login");
			System.out.println("");
			System.out.println("---< Bem Vindo de Volta! >---");
			System.out.println("Para realizar o Login Insira seu email:");
			System.out.println("-----------------------------");
			System.out.print("email: ");
			break;
		}
		case 6: {
			gerarLog("iniciou cadastro");
			System.out.println("");
			System.out.println("---< Bem Vindo a IndieLens! >---");
			System.out.println("Para realizar o cadastro Insira seu email:");
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
			gerarLog("selecionou opção Inválida: " + opcao);
			System.err.println("Opção Inválida Tente Novamente.");
		}
		
		switch (opcao) {
			case 1 : { 
				gerarLog("selecionou opção 1");
				telaInstitucional(); 
				break;
			}
			case 2 : { 
				gerarLog("selecionou opção 2");
				telaSobreNos(); 
				break; 		
			}
			case 3 : { 
				gerarLog("selecionou opção 3");
				Conta();
				break;
			}
			case 4 : {
				gerarLog("selecionou opção 4");
				return false;
			}
		}
		return true;
	}
	
	public void telaInstitucional() {
		Scanner leitorInst = new Scanner(System.in);
		boolean opcaoCorreta = true;
		
		ImprimirMensagens(2);
		
		while (opcaoCorreta) {
			Integer opcao = leitorInst.nextInt();
			
			if (opcao == 1) {
				gerarLog("saiu da tela institucional");
				opcaoCorreta = false;
			} else {
				gerarLog("falhou em selecionar opção válida, realizando teste novamente");
				System.err.println("opção Inválida, tente novamente");
				System.out.println("Digite 1 para retornar a tela principal");
				System.out.print("Seleção: ");
			}
			
		}
		
	}
	
	public void telaSobreNos() {
		Scanner leitorSobre = new Scanner(System.in);
		boolean opcaoCorreta = true;
		
		ImprimirMensagens(3);
		
		while (opcaoCorreta) {
			Integer opcao = leitorSobre.nextInt();
			
			if (opcao == 1) {
				gerarLog("saiu da sobre nós");
				opcaoCorreta = false;
			} else {
				gerarLog("falhou em selecionar opção válida, realizando teste novamente");
				System.err.println("opção Inválida, tente novamente");
				System.out.println("Digite 1 para retornar a tela principal");
				System.out.print("Seleção: ");
			}
			
		}
	}

	public void Conta() {
		Scanner leitorConta = new Scanner(System.in);
		ImprimirMensagens(4);
		Integer opcaoConta = leitorConta.nextInt();
		
		switch (opcaoConta) {
		case 1: {
			if (estaLogado) {
				gerarLog("tentou logar já estando logado");
				System.out.println("Você já está logado!");
			} else {
				login(leitorConta);
				
			}
			break;
		}
		case 2: {
			if (estaLogado) {
				gerarLog("tentou realizar cadastro já estando logado");
				System.out.println("Você já está logado!");
			} else {
				cadastro(leitorConta);
			}
			break;
		}
		case 3: {
			gerarLog("retornando a seleção de página");
			break;
		}
		default:
			gerarLog("selecionou opção inválida, tentando novamente");
			System.err.println("Opção Inválida, tente novamente.");
			Conta();
			break;
		}
	}
	
	public void login(Scanner leitorConta) {
		ImprimirMensagens(5);
		String usuario = leitorConta.next();
		gerarLog("inseriu email: " + usuario);
		
		System.out.println("Agora Insira sua Senha:");
		System.out.println("-----------------------------");
		System.out.print("senha: ");
		
		String senha = leitorConta.next();
		gerarLog("inseriu senha: " + senha);
		
		if (usuario.equals(user) && senha.equals(passkey)) {
			gerarLog("realizou login");
			estaLogado = true;
			System.out.println("-----------------------------");
			System.out.println("Bem vindo " + usuario);
			System.out.println("");
		} else {
			gerarLog("falhou em realizar o login, senha ou email incorreto");
			System.err.println("usuario inválido.");
		}
		
	}
	
	public void cadastro(Scanner leitorConta) {
		ImprimirMensagens(6);
		String senha = null;
		String usuario = leitorConta.next();
		Boolean senhasDiferentes = true;
		
		gerarLog("inseriu usuário: " + usuario);
		
		System.out.println("Agora Insira uma Senha:");
		System.out.println("-----------------------------");
		System.out.print("senha: ");
		
		while (senhasDiferentes) {
			senha = leitorConta.next();
			gerarLog("inseriu senha: " + senha);
			System.out.println("Confirme sua senha:");
			System.out.println("-----------------------------");
			System.out.print("senha: ");
				
			String senhaconfirmacao = leitorConta.next();
			gerarLog("inseriu confirmação de senha: " + senha);
			
			if (senha.equals(senhaconfirmacao)) {
				senhasDiferentes = false;
			} else {
				gerarLog("senhas não coincidiram, requisitando senhas novamente");
				System.err.println("As senhas não coincidem, tente novamente");
				System.out.println("----------------------------------------");
				System.out.println("Insira sua Senha:");
				System.out.println("-----------------------------");
				System.out.print("senha: ");
			}
		}
		
		user = usuario;
		passkey = senha;
		
		gerarLog("criou nova conta com sucesso: usuário: " + user + "; senha: " + passkey + "");
		login(leitorConta);
		
	}
	
	public void gerarLog(String informacao) {
		
		LocalDateTime dataHora = LocalDateTime.now();
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String textoFormatado = dataHora.format(formatador); 
		
		String mensagem = "[" + textoFormatado + "] : Usuário " + informacao + ";";
		logs.add(mensagem);
	}
	
	public void invocarLogs() {
		gerarLog("requisitou histórico de logs");
		System.out.println("----< Histórico de ações >----");
		for (int i = 0; i < logs.size(); i++) {
			System.out.println(logs.get(i));
		}
		System.out.println("------------------------------");
	}
	
	public void encerrarOperacao(Scanner leitor) {
		gerarLog("iniciou o encerramento do programa");
		System.out.println("------------------------");
		System.out.println("Deseja Imprimir os Logs? (S/N)");
		System.out.println("------------------------");
		String letra = leitor.next();
		
		if (letra.charAt(0) == 'S' || letra.charAt(0) == 's') {
			gerarLog("confirmou o encerramento do programa");
			invocarLogs();
		} else {
			System.out.println("Volte Sempre!");
		}
	}
}
