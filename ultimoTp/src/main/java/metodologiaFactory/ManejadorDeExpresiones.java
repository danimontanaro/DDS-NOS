package metodologiaFactory;

public class ManejadorDeExpresiones {

	expresionFactory creadorFactory;
	expresion expresion;
	
	public expresion getExpresion() 
	{
		return expresion;
	}
	public void setCreadorFactory(expresionFactory creadorFactory) 
	{
		this.creadorFactory = creadorFactory;
	}
	public String concatenarPackage(String nombreExpresion) 
	{
		String palabra= "metodologiaFactory.creadorConcreto"+nombreExpresion;
		return palabra;
	}
	
	public void setCreadorFactory(String creadorFactoryString)  
	{
		//creo una referencia de tipo generica a partir del string 
		//que en la asignacion se amolda al tipo de string recibido
		Class<?> expresionClass = null;
		try {
			expresionClass = Class.forName(creadorFactoryString);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		//creo la instancia de ese tipo recibido
		try {
			creadorFactory = (expresionFactory) expresionClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void crearExpresion() 
	{
		this.expresion= this.creadorFactory.FactoryMethod();
	}

	
	
}
