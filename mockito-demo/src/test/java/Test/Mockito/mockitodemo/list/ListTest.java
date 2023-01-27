package Test.Mockito.mockitodemo.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {
	@Test
	void test() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(3);	
		assertEquals(3, listMock.size());
	}
	
	@Test
	void multipleReturns() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(3).thenReturn(2);	
		assertEquals(3, listMock.size());
	}
	
	@Test
	void parameters() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("Guna");	
		assertEquals("Guna", listMock.get(0));
	}

}
