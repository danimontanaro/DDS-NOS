import java.util.List;

import Entity.Periodo;
import Modelo.DAOGlobalMYSQL;

public class probando {

	public static void main(String[] args) {
		DAOGlobalMYSQL<Periodo> modelPeriodo = new DAOGlobalMYSQL<Periodo>(Periodo.class);
		List<Periodo> lista = modelPeriodo.getAll();
		
		for(Periodo p:lista){
			System.out.println("¡AL>GO "+p.getDesde());
		}

	}

}
