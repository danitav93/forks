package input;

public class SimpleParameter implements ParameterInterface{

	//costo cospeciazione
	@Override
	public float getCs() {
		return 0;
	}

	//costo duplicazione
	@Override
	public float getCd() {
		return 1;
	}

	//costo transfer
	@Override
	public float getCt() {
		return 3f;
	}

	//costo loss
	@Override
	public float getCl() {
		return 2;
	}

}
