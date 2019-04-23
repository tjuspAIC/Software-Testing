package cn.tjucic.stlab1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
//使用@RunWith(Parameterized.class)注释测试类
@RunWith(Parameterized.class)
public class testGivenMoney2 {
	static int[] coins= {50,20,5,5,1,1,1};
	static int n=coins.length;
	
	private GivenMoney2 m=null;
	private int[] input1;
	private int input2;
	private int input3;
	private boolean expected;
	//构造函数，使用数据集中一行的元素
	public testGivenMoney2(int input1[],int input2,int input3,boolean expected) {
		this.input1=input1;
		this.input2=input2;
		this.input3=input3;
		this.expected=expected;
	}
	@Before
	public void setUp(){
		m=new GivenMoney2();
	}
	//测试数据集
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
			{coins,n,54,false},
			{coins,n,75,true},
			{coins,n,31,true},
			{coins,n,0,true},
			{coins,n,-1,false},
			{coins,n,3,false},//错误案例			

		});
	}
	@Test
	public void test() {
		assertEquals(this.expected,m.subset(input1, input2, input3));
	}

}