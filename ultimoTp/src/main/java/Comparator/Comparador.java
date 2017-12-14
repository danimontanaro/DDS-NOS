package Comparator;

public enum Comparador {
	
	MENORAMAYOR{
		public boolean comparar(double valor, double otroValor){
			return valor > otroValor;
		}
	},
	
	MAYORAMENOR{
		public boolean comparar(double valor,double otroValor){
			return valor < otroValor;
		}
	};
	
	public abstract boolean comparar(double valor, double otroValor);
}
