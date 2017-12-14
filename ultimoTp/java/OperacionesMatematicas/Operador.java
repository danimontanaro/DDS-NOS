package OperacionesMatematicas;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlEnum;



public enum Operador{
	  DIVISION{
		public double calcular(double operando1, double operando2) {
			if(operando2 != 0)
				return (operando1 / operando2); 
			return 0;
			/*else 
				throw new OperacionInvalidaException("Se intento dividir por 0.");*/
		}
	   },

	  MULTIPLICACION{
		public double calcular(double operando1, double operando2) {
			return operando1 * operando2; 
		}
	   },

	  SUMA{
		public double calcular(double operando1, double operando2) {
			return operando1 + operando2; 
		}
	   },
		  
	  RESTA{
		public double calcular(double operando1, double operando2) {
			return operando1 - operando2; 
		}
	   };

	public abstract double calcular(double calcular, double calcular2);

} 
	//public abstract double calcular(double operando1, double operando2);
