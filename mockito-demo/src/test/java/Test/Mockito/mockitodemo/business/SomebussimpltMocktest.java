package Test.Mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SomebussimpltMocktest {

	@Mock

	private DataService Mock;

	@InjectMocks
	private SomeBussimpl buss;

	@Test
	void test() {
		

		when(Mock.retrieveAllData()).thenReturn(new int[] {25,15,5});
		int res = buss.findtheGreatest();
		assertEquals(25,res);
	}

	@Test
	void test2() {
		

		when(Mock.retrieveAllData()).thenReturn(new int[] {25});
		int res = buss.findtheGreatest();
		assertEquals(25,res);
	}

}
