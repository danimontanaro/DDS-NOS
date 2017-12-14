package metodologiaFactory;

public class igual extends expresion{

	public igual(){}
	@Override
	public boolean cumpleCondicion(double v1, double v2)
	{
		return v1 == v2;
	}
}
