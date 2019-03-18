package cn.tjucic.stlab1;

public class GivenMoney {
	private int[] resultSet;
	//将所有可能出现的组合全算出来，每个硬币都有取与不取两种可能性，所以总共2^7种情况，这里写的只适用于数组长度为7，若数组长度为n就要把for循环改为n层
	public GivenMoney(int[] input) {
		double length=Math.pow(2, input.length);
		resultSet=new int[(int)length];
		int index=0;
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				for(int k=0;k<2;k++) {
					for(int l=0;l<2;l++) {
						for(int m=0;m<2;m++) {
							for(int n=0;n<2;n++) {
								for(int o=0;o<2;o++) {
									resultSet[index]=i*input[0]+j*input[1]+k*input[2]+l*input[3]+m*input[4]+n*input[5]+o*input[6];
								    index++;
								}
							}
						}
					}
				}
			}
		}
	}
	
	public boolean whether(int givenMoney) {	
		for(int i=0;i<resultSet.length;i++) {
			if(resultSet[i]==givenMoney) {
				return true;
			}
		}
		return false;		
	}

}
