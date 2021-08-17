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
			System.out.println("1 - Cadastrar Conta");
			System.out.println("2 - Acessar Conta");
			System.out.println("3 - Mostrar Correntistas Cadastrados");
			System.out.println("0 - Sair");
			System.out.println("Digite a opção desejada: ");
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
				    
				    System.out.println("---Escolha o tipo de Conta---");
				    System.out.println("1 - Conta Corrente");
				    System.out.println("2 - Conta Poupança");
				    int opcaoConta = sc.nextInt();
				    
				    if(opcaoConta == 1) {
				    	 clientesCorrente.add(new ContaCorrente(nome, numeroConta,deposito));
				    }else {
				    	 clientesPoupanca.add(new ContaPoupanca(nome, numeroConta,deposito));
				    	 
				    	System.out.println("---Realize uma simulação de rendimentos---");
				    	System.out.print("Deposito inicial: ");
				    	double depositoInicial = sc.nextDouble();
				    	System.out.print("Tempo em meses que deixara rendendo: ");
				    	int tempoMeses = sc.nextInt();
				    	 
				    	System.out.println(TestePoupanca.rendimento(depositoInicial, tempoMeses));
				    }
				  
			     break;
			
			     case 2:
			    	  System.out.println("Digite o numero da conta: ");
					   int numeroContaAcesso = sc.nextInt();
					   int sair;
					   ArrayList<Conta> clientesConcatena = new ArrayList<>(clientesPoupanca.size() + clientesCorrente.size());
					   clientesConcatena.addAll(clientesPoupanca);
					   clientesConcatena.addAll(clientesCorrente);
					   
					   Conta verificarConta = clientesConcatena.stream().filter(x -> x.getNumeroConta() == numeroContaAcesso).findFirst().orElse(null);
					   
					   if( verificarConta != null) {
						   do {
							   System.out.println("---Opções---");
							   System.out.println("1 - Sacar");
							   System.out.println("2 - Depositar");
							   System.out.println("Digite a opção desejada: ");
							   int i = sc.nextInt();
							   if(i == 1) {
							        System.out.println("Digite o valor do saque: ");
							        double valorSaque = sc.nextDouble();
							        verificarConta.sacar(valorSaque);
						         }else if(i == 2 ){
							        System.out.println("Valor do Deposito: ");
							        double valorDeposito = sc.nextDouble();
							        verificarConta.depositar(valorDeposito);
							     }
							   System.out.println("Deseja Realizar outra operação? 1 - Sim 2 - Não ");
							   sair = sc.nextInt();
						   	}while(sair == 1);
						   
					     }else{
						   System.out.println("Numero da conta incorreto!!!");
					   }
			    	 
				   
				 break;
			     case 3: 
			    	 System.out.println("---Contas Correntes---");
			    	 for(ContaCorrente corrente : clientesCorrente) {
			    		 System.out.println(corrente);
			    	 }
			    	 System.out.println("---Contas Pupança---");
			    	 for(ContaPoupanca poupanca : clientesPoupanca) {
			    		 System.out.println(poupanca);
			    	 }
				break;	
			}
			
		}while(opcao != 0);
	 sc.close();
	}
	
}
