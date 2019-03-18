package cn.tjucic.stlab1;

public class GivenMoney2 {
	//递归的思路 可将问题分解为
	//1.结果集中包含第n个元素，问题转为subset(input,n-1,givenMoney-input[n-1])
	//2.结果集中不包含第n个元素，问题转为subset(input,n-1,givenMoney)
	//初始条件：givenMoney为0时，此时已经被排除的元素可以构成一个结果，返回true
	//n小于1且givenMoney!=0时，返回false
	boolean subset(int[] input,int n,int givenMoney) {
		if(givenMoney==0) {
			return true;
		}
		else if(n<1&&givenMoney!=0) {
			return false;
		}
		else {
			return subset(input,n-1,givenMoney-input[n-1])||subset(input,n-1,givenMoney);
		}
	}

//	public static void main(String[] args) {
//	    int[] input={50,20,5,5,1,1,1};
//	    int n=input.length;
//	    int givenMoney=4;
//	    GivenMoney2 gm2=new GivenMoney2();
//	    System.out.println(gm2.subset(input, n, givenMoney));
//	}
}
