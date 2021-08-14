package banco;

public class ContaCorrente extends Conta{

	public ContaCorrente(String correntista, int numero, double saldo) {
		super(correntista, numero, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Nome Correntista: " + this.getNomeCorrentista() + ", Numero Conta: " + this.getNumeroConta() + ", Saldo:"
				+ this.getSaldo() ;
		}
}
