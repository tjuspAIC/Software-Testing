package cn.tjucic.st;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cn.tjucic.st.PrintPrimes;

@RunWith(Parameterized.class)
public class testPrintPrimes {
	private PrintPrimes p=null;
	private int input;
	private String expected;
	public testPrintPrimes(int input,String expected) {
		this.input=input;
		this.expected=expected;
	}
	@Before
	public void setUp(){
	    int[] input1={50,20,5,5,1,1,1};
		p=new PrintPrimes();
	}
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
				{6,"Prime: 2 Prime: 3 Prime: 5 Prime: 7 Prime: 9 Prime: 11 "},
				{1,"Prime: 2 " },	
						

		});
	}
	@Test
	public void test() {
		assertEquals(this.expected,p.printPrimes(input));
	}

}