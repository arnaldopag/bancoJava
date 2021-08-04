package banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Banco {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
	   List<Conta> correntistas = new ArrayList<>();
	   
	   int opcao;
	   
		do {
			System.out.println();
			System.out.println(" ---  Menu Banco ----");
			System.out.println("1 - Cadastrar correntista");
			System.out.println("2 - Acessar conta");
			System.out.println("3- Mostrar Correntistas Cadastrados");
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
				
				    Conta cliente = new Conta(nome, numeroConta);
				    
				    correntistas.add(cliente);
				
				    System.out.print("Valor do deposito inicial: ");
				    double deposito = sc.nextDouble();
				    cliente.setSaldo(deposito);	
			     break;
			
			   case 2: 
				   System.out.println("Digite o numero da conta: ");
				   int nConta = sc.nextInt();
				   int sair;
				
				   Conta cliente1 = correntistas.stream().filter(x -> x.getNumero() == nConta).findFirst().orElse(null);
					
				   if( cliente1 != null) {
					   do {
						   System.out.println("---Opções---");
						   System.out.println("1 - Sacar");
						   System.out.println("2 - Depositar");
						   System.out.println("Digite a opção desejada: ");
						   int i = sc.nextInt();
						   if(i == 1) {
						        System.out.println("Digite o valor do saque: ");
						        double valorSaque = sc.nextDouble();
						        cliente1.sacar(valorSaque);
					         }else if(i == 2 ){
						        System.out.println("Valor do Deposito: ");
						        double valorDeposito = sc.nextDouble();
						        cliente1.depositar(valorDeposito);
						     }
						   System.out.println("Deseja Realizar outra operação? 1 - Sim 2 - Não ");
						   sair = sc.nextInt();
					   	}while(sair == 1);
					   
				     }else{
					   System.out.println("Numero da conta incorreto!!!");
				   }
				
			     break;
				   
			     case 3: 
			    	 for(Conta c : correntistas) {
			    		 System.out.println(c);
			    	 }
				
				break;	
			}
			
		}while(opcao != 0);
	 sc.close();
	}
	
}
