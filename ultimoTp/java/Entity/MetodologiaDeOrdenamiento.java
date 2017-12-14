package Entity;
import java.util.*;

public class MetodologiaDeOrdenamiento {
	
	private List<CondicionTaxativa> listaCondiciones;
	
	
	public MetodologiaDeOrdenamiento( List<CondicionTaxativa> listaCondiciones) {
		super();	
		this.listaCondiciones = listaCondiciones;
	}	
	
	public List<CondicionTaxativa> getListaCondiciones() {
		return listaCondiciones;
	}
	public void setListaCondiciones(ArrayList<CondicionTaxativa> listaCondiciones) {
		this.listaCondiciones = listaCondiciones;
	}
	
	public List<Empresa> ordenarLista(List<Empresa> listaEmpresas){
		
		Collections.sort(listaEmpresas, new Comparator<Empresa>(){
			@Override
			public int compare(Empresa empresa1,Empresa empresa2){								
				return darPeso(empresa1) -  darPeso(empresa2);
			}
		});
		return listaEmpresas;
	}
	
	public int darPeso(Empresa empresa){
		int peso = 0;		
		
//		for(CondicionTaxativa condicion: listaCondiciones){
//			for(Cuenta cuenta: empresa.getCuentas()){
//				for(Periodo per:cuenta.getPeriodo()){
//					if(condicion.cumpleCondicion(empresa.getNombre(), per.getDesde(), per.getHasta())){
//						peso+=20;
//						System.out.println("true "+ peso);
//					}
//					else
//						System.out.println("no cumple con condicion " + peso);
//				}
//			}
//		}
					
		return peso;
	
	}	

}

