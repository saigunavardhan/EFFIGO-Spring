package Test.Mockito.mockitodemo.business;

public class SomeBussimpl {
	private DataService dataservice;
	
	
	public SomeBussimpl() {
		
	}
	public SomeBussimpl(DataService dataservice) {
		super();
		this.dataservice = dataservice;
	}



	public int findtheGreatest() {
		int [] data = dataservice.retrieveAllData();
		int greatestValue = Integer.MIN_VALUE;
		for(int value:data) {
			if(value>greatestValue)
				greatestValue = value;
		}
		
		return greatestValue;
	}
}

interface DataService{
	int [] retrieveAllData();
}