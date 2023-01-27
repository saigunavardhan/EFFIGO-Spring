package Test.Mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomebussimplStubTest {

	@Test
	void test() {
		DataServiceStub stub = new DataServiceStub();
		SomeBussimpl buss = new SomeBussimpl(stub);
		int res = buss.findtheGreatest();
		assertEquals(25,res);
	}

}

class DataServiceStub implements DataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 25, 15, 5 };
	}

}
