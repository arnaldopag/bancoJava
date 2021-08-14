package banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Banco {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcao;
	   List<Conta> correntistas = new ArrayList<>();
		do {
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
				
				    System.out.println("Valor do deposito inicial: ");
				    double deposito = sc.nextDouble();
				    cliente.setSaldo(deposito);	
			     break;
			
			 /* case 2: 
				System.out.println("Digite o numero da conta: ");
				int nConta = sc.nextInt();
				String s = "S";
				if(acesso) {
				    do {
					    System.out.println("---Opções---");
					    System.out.println("1 - Sacar");
					    System.out.println("2 - Depositar");
					    System.out.println("Digite a opção desejada: ");
					   int i = sc.nextInt();
					     if(i == 1) {
						        System.out.println("Digite o valor do saque: ");
						        double valorSaque = sc.nextDouble();
						        cliente.sacar(valorSaque);
					         }else if(i == 2 ){
						        System.out.println("Valor do Deposito: ");
						        double valorDeposito = sc.nextDouble();
						        cliente.setSaldo(valorDeposito);
						     }
					     System.out.println("Deseja Realizar outra operação? S - Sim N - Não ");
					     s = sc.next();
					   }while(s != "n");
				      }else{
					   System.out.println("Numero da conta incorreto!!!");
				   }
				
				   break;
				   
				   */
			     case 3: 
			    	 for(Conta cliente1 : correntistas) {
			    		 System.out.println(cliente1);
			    	 }
				
				break;
				
	       }
		}while(opcao != 0);
	
	}
	
	
	
	
	
	  public static Integer posicao(List<Conta> correntistas, int nConta) {
			for (int i = 0; i <correntistas.size(); i++ )
			 if(correntistas.get(i).getNumero() == nConta) {
			 return i;
			}
			return null;
		}
}
