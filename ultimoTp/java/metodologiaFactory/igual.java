package metodologiaFactory;

public class igual extends expresion{

	public igual(){}
	@Override
	public boolean cumpleCondicion(int v1, int v2)
	{
		return v1 == v2;
	}
}
