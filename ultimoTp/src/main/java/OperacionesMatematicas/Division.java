package OperacionesMatematicas;



public class Division {

	public double calcular(double operando1, double operando2) {
		if(operando2 != 0)
			return operando1 / operando2; 
		return 0;
		/*else 
			throw new OperacionInvalidaException("Se intento dividir por 0.");
			*/
	}
}
