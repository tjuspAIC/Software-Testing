package cn.tjucic.stlab1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class testGivenMoney {
	private GivenMoney m=null;
	private int input2;
	private boolean expected;
	public testGivenMoney(int input2,boolean expected) {
		this.input2=input2;
		this.expected=expected;
	}
	@Before
	public void setUp(){
	    int[] input1={50,20,5,5,1,1,1};
		m=new GivenMoney(input1);
	}
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
				{50,true},
				{54,false},	
				{75,true},			
				{100,false},	
				{-1,false},
				{0,true},
				{3,false},//´íÎó°¸Àý			

		});
	}
	@Test
	public void test() {
		assertEquals(this.expected,m.whether(input2));
	}

}
