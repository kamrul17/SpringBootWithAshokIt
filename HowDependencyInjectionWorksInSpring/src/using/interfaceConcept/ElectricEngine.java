package using.interfaceConcept;

public class ElectricEngine implements IEngine{

	@Override
	public int start() {
		System.out.println("ElectricEngine");
		return 1;
	}

}