package banco;

public class Conta {
	private String correntista;
	private int numero;
	private double saldo;
	
	
	
	public Conta(String correntista, int numero) {
		super();
		this.correntista = correntista;
		this.numero = numero;
		this.saldo = 0.00;
	}

	public String getCorrentista() {
		return correntista;
	}
	
	public void setCorrentista(String correntista) {
		this.correntista = correntista;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
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
   
  @Override
   public String toString() {
	return "Nome correntista: " + correntista + ", Numero da Conta: " + numero + ", Saldo: " + saldo;
   }
 
	
}
