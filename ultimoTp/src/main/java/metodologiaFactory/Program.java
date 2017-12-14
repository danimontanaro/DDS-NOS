package metodologiaFactory;

import java.util.ArrayList;

import Entity.CondicionTaxativa;
import Entity.Metodologia;

public class Program {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		expresionFactory cond = new creadorConcretoMayor();
//		expresion condicionConcreta = cond.FactoryMethod();
//		
		Metodologia metodologia=new Metodologia();
		//metodologia.setNombre("Metodologia1");
		
		ArrayList<CondicionTaxativa> condiciones= new ArrayList<CondicionTaxativa>();
		CondicionTaxativa condicion1= new CondicionTaxativa();
		condicion1.setIndicadorOCuenta("EBITDA");
		condicion1.setExpresion("Mayor");
		condicion1.setValorAComparar(50);

		CondicionTaxativa condicion2= new CondicionTaxativa();
		condicion2.setIndicadorOCuenta("FDS");
		condicion2.setExpresion("Igual");
		condicion2.setValorAComparar(30);
		
		condiciones.add(condicion1);
		condiciones.add(condicion2);
		
		metodologia.setCondiciones(condiciones);
		
		

		ManejadorDeExpresiones manejador= new ManejadorDeExpresiones();
		
		manejador.setCreadorFactory(manejador.concatenarPackage(condicion2.getExpresion()));
		
		manejador.crearExpresion();
		//tengo q setearle el valor q obtenga de esa cunta
		//o inducador de una determinada empresa
		//en un periodo 
		int valorCuentaOIndicador = 30;
		System.out.println(manejador.getExpresion().cumpleCondicion( valorCuentaOIndicador,condicion2.getValorAComparar() ));
	}

}
