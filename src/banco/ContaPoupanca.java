package banco;

import java.text.DecimalFormat;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String correntista, int numero, double saldo) {
		super(correntista, numero,saldo);
		// TODO Auto-generated constructor stub
	}

	public String rendimento(double valorAplicado, int tempoMeses) {
		
		double taxaJuros = 0.005;
		double valorFinal = valorAplicado * Math.pow((1 + taxaJuros),tempoMeses);
		double rendimentosTotais = valorFinal - valorAplicado;
		
		DecimalFormat format = new DecimalFormat(".##");
		
		return "Valor Inicial: " + valorAplicado +  " Valor dos redimentos: " + format.format(rendimentosTotais) + " Valor Final: " + format.format(valorFinal);
	
	}

	@Override
	public String toString() {
		return "Nome Correntista: " + this.getNomeCorrentista() + ", Numero Conta: " + this.getNumeroConta() + ", Saldo:"
				+ this.getSaldo() ;
		};
	
}
