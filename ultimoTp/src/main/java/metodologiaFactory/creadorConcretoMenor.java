package metodologiaFactory;

public class creadorConcretoMenor extends expresionFactory{


	@Override
	public expresion FactoryMethod()
	{
		return new menor();
	}
	
}
