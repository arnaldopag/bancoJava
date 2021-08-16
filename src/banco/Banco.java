package banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Banco {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
	   List<ContaCorrente> clientesCorrente = new ArrayList<>();
	   List<ContaPoupanca> clientesPoupanca = new ArrayList<>();
	   
	   ContaPoupanca TestePoupanca = new ContaPoupanca("Teste",123,0);
	   
	   int opcao;
	   
		do {
			System.out.println();
			System.out.println(" ---  Menu Banco ----");
			System.out.println("1 - Cadastrar Conta Corrente");
			System.out.println("2 - Cadastrar Conta Poupan�a");
			System.out.println("3 - Acessar Conta Corrente");
			System.out.println("4 - Acessar Conta Poupan�a");
			System.out.println("5 - Mostrar Correntistas Cadastrados");
			System.out.println("0 - Sair");
			System.out.println("Digite a op��o desejada: ");
			opcao = sc.nextInt();
			
			switch(opcao) {
			   case 1: 
			     	System.out.println("--- Cadastro Correntista---");
			     	System.out.print("Nome do Correntista: ");
				    String nome = sc.next();
				    
				    
				    System.out.print("Numero da Conta: ");
				    int numeroConta = sc.nextInt();
				
				
				    System.out.print("Valor do deposito inicial: ");
				    double deposito = sc.nextDouble();
				  
				    clientesCorrente.add(new ContaCorrente(nome, numeroConta,deposito));
			     break;
			   case 2:
			     	System.out.println("--- Cadastro Conta Poupan�a---");
			     	System.out.print("Nome do Correntista: ");
				    String nomePoupanca = sc.next();
				    
				    
				    System.out.print("Numero da Conta: ");
				    int numeroPoupanca = sc.nextInt();
				
				
				    System.out.print("Valor do deposito inicial: ");
				    double depositoPoupanca = sc.nextDouble();
				    
				    System.out.println("---Simula��o de rendimentos---");
				    System.out.print("Valor do deposito inicial: ");
				    double valorInicial = sc.nextDouble();
				    System.out.print("Tempo em meses que pretende deixar rendendo: ");
				    int tempoMeses = sc.nextInt();
				    
				   System.out.println(TestePoupanca.rendimento(valorInicial,tempoMeses));
				    
				    clientesPoupanca.add(new ContaPoupanca(nomePoupanca, numeroPoupanca,depositoPoupanca));
			
			     break;
				   
			   case 3: 
				   
				   System.out.println("Digite o numero da conta: ");
				   int nConta = sc.nextInt();
				   int sair;
				   
				   Conta contaTeste  = clientesCorrente.stream().filter(x -> x.getNumeroConta() == nConta).findFirst().orElse(null);
				   
				   if( contaTeste != null) {
					   do {
						   System.out.println("---Op��es---");
						   System.out.println("1 - Sacar");
						   System.out.println("2 - Depositar");
						   System.out.println("Digite a op��o desejada: ");
						   int i = sc.nextInt();
						   if(i == 1) {
						        System.out.println("Digite o valor do saque: ");
						        double valorSaque = sc.nextDouble();
						        contaTeste.sacar(valorSaque);
					         }else if(i == 2 ){
						        System.out.println("Valor do Deposito: ");
						        double valorDeposito = sc.nextDouble();
						        contaTeste.depositar(valorDeposito);
						     }
						   System.out.println("Deseja Realizar outra opera��o? 1 - Sim 2 - N�o ");
						   sair = sc.nextInt();
					   	}while(sair == 1);
					   
				     }else{
					   System.out.println("Numero da conta incorreto!!!");
				   }
				
			     break;
			     case 4:
			    	  System.out.println("Digite o numero da conta: ");
					   int nContaPoupanca = sc.nextInt();
					   
					   Conta contaPoupanca = clientesCorrente.stream().filter(x -> x.getNumeroConta() == nContaPoupanca).findFirst().orElse(null);
					   
					   if( contaPoupanca != null) {
						   do {
							   System.out.println("---Op��es---");
							   System.out.println("1 - Sacar");
							   System.out.println("2 - Depositar");
							   System.out.println("Digite a op��o desejada: ");
							   int i = sc.nextInt();
							   if(i == 1) {
							        System.out.println("Digite o valor do saque: ");
							        double valorSaque = sc.nextDouble();
							        contaPoupanca.sacar(valorSaque);
						         }else if(i == 2 ){
							        System.out.println("Valor do Deposito: ");
							        double valorDeposito = sc.nextDouble();
							        contaPoupanca.depositar(valorDeposito);
							     }
							   System.out.println("Deseja Realizar outra opera��o? 1 - Sim 2 - N�o ");
							   sair = sc.nextInt();
						   	}while(sair == 1);
						   
					     }else{
						   System.out.println("Numero da conta incorreto!!!");
					   }
			    	 
				   
				 break;
			     case 5: 
			    	 System.out.println("---Contas Correntes---");
			    	 for(ContaCorrente corrente : clientesCorrente) {
			    		 System.out.println(corrente);
			    	 }
			    	 System.out.println("---Contas Pupan�a---");
			    	 for(ContaPoupanca poupanca : clientesPoupanca) {
			    		 System.out.println(poupanca);
			    	 }
				break;	
			}
			
		}while(opcao != 0);
	 sc.close();
	}
	
}
