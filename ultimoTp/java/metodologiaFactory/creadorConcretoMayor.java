package metodologiaFactory;

public class creadorConcretoMayor extends expresionFactory{

	@Override
	public expresion FactoryMethod()
	{
		return new mayor();
	}
	
	

}
