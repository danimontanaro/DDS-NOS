package metodologiaFactory;

public class creadorConcretoIgual extends expresionFactory{

	@Override
	public expresion FactoryMethod() {
		// TODO Auto-generated method stub
		return new igual();
	}

}
