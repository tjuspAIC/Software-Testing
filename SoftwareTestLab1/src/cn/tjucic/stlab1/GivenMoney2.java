package cn.tjucic.stlab1;

public class GivenMoney2 {
	//�ݹ��˼· �ɽ�����ֽ�Ϊ
	//1.������а�����n��Ԫ�أ�����תΪsubset(input,n-1,givenMoney-input[n-1])
	//2.������в�������n��Ԫ�أ�����תΪsubset(input,n-1,givenMoney)
	//��ʼ������givenMoneyΪ0ʱ����ʱ�Ѿ����ų���Ԫ�ؿ��Թ���һ�����������true
	//nС��1��givenMoney!=0ʱ������false
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
