package banco;

import java.text.DecimalFormat;

public class ContaCorrente extends Conta{
	private double salario;
	

	public ContaCorrente(String correntista, int numero, double saldo) {
		super(correntista, numero, saldo);
		this.salario = 0;
		
	}
	
	public String emprestimo(double valor, int tempoMeses) {
	
		double taxaJuros = 1.10;
		
		if(tempoMeses <= 12) {
			taxaJuros = 1.20;
		}else if(tempoMeses <= 24) {
			taxaJuros = 1.30;
		}else {
			taxaJuros = 1.40;
		}
		double valorFinal = valor * taxaJuros;
		double parcelaMes = valorFinal / tempoMeses;
		
		DecimalFormat format = new DecimalFormat(".##");
		
		return "Valor Emprestimo: " + valor + " Valor Parcela: " + format.format(parcelaMes) +" Quantidade Parcelas: " + tempoMeses +  " Valor Final: " + format.format(valorFinal) ;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
		
	@Override
	public String toString() {
		return "Nome Correntista: " + this.getNomeCorrentista() + ", Numero Conta: " + this.getNumeroConta() + ", Saldo:"
				+ this.getSaldo() + " Salario: " + this.salario ;
		}
}
