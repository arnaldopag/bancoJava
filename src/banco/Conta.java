package banco;

public class Conta {
	private String nomeCorrentista;
	private int numeroConta;
	private double saldo;
	
   public Conta(String nomeCorrentista, int numeroConta, double saldo) {
		this.nomeCorrentista = nomeCorrentista;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
   

public Conta() {

}


public String getNomeCorrentista() {
	return nomeCorrentista;
}

public void setNomeCorrentista(String nomeCorrentista) {
	this.nomeCorrentista = nomeCorrentista;
}

public int getNumeroConta() {
	return numeroConta;
}

public void setNumeroConta(int numeroConta) {
	this.numeroConta = numeroConta;
}

public double getSaldo() {
	return saldo;
}

public void setSaldo(double saldo) {
	this.saldo = saldo;
}

public void sacar(double valorSaque) {
	   if(valorSaque > saldo) {
		   System.out.println("Saldo insuficiente!!! Saldo Atual: " + saldo);
		   return ;
	   }
	   saldo -= valorSaque;
	   System.out.println("Valor sacado com sucesso!!!");
	   System.out.println("Saldo Atual: " + saldo);
	   
   }
   
   
   public void depositar(double valorDeposito) {
	   
	   saldo += valorDeposito;
	   System.out.println("Valor Depositado com sucesso!!!");
	   System.out.println("Saldo Atual: " + saldo);
	   
   }
   /*public boolean verificarConta(List<ContaCorrente> listaCorrente,List<ContaPoupanca> listaPoupanca, int nConta) {
   	   
		  ContaCorrente contaCorrente = listaCorrente.stream().filter(x ->  x.getNumeroConta() == nConta).findFirst().orElse(null);
		  
		  if(contaCorrente == null) {
			  ContaPoupanca contaPoupanca = listaPoupanca.stream().filter(x -> x.getNumeroConta() == nConta).findFirst().orElse(null);
			  return contaPoupanca != null;
		  }
		  
		  return contaCorrente != null;   
		  }
		  */
}
