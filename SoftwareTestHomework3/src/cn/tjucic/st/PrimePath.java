package cn.tjucic.st;

import java.util.ArrayList;

public class PrimePath {
	public static ArrayList Prime(int graph[][],int Gstart,int Gend) {//第一个参数为表示有向图的边的二维数组，第二个参数为初始节点的编号，第三个参数为终止节点的编号
		ArrayList<String> result=new ArrayList<>();//这个集合中存储了三种简单路径：1.以终止节点作为最后一个节点的
		//2.自环 3.若继续扩展会生成内部循环的路径     这三种路径都是不能被扩展的      这个简单路径的集合中，尚未移出那些为其他简单路径子路径的路径
		ArrayList<String> oldPath=new ArrayList<>();
		for(int i=1;i<graph.length;i++) {
			oldPath.add(String.valueOf(i));
		}
		//此时oldPath为长度为0的简单路径
		ArrayList<String> newPath=new ArrayList<>();
		for(int i=0;i<oldPath.size();i++) {
			int onlyYou=Integer.parseInt(oldPath.get(i));			
			if(onlyYou==Gend) {//终止于终止节点的路径不能被扩展，添加到result集合中
				result.add(oldPath.get(i));
			}
			else {
				for(int j=0;j<graph[onlyYou].length;j++) {
					String temp=oldPath.get(i);
					temp=temp+"->"+graph[onlyYou][j];
					newPath.add(temp);
				}
				
			}
		}
		//此时newPath为长度为1的简单路径
		
		do {
			//把原newPath作为新的oldPath
			oldPath=new ArrayList<String> (newPath);
			newPath.clear();
//			for(int i=0;i<newPath.size();i++) {
//				System.out.println(oldPath.get(i));
//			}
			for(int i=0;i<oldPath.size();i++) {
				String thisPath=oldPath.get(i);
				int firstArrow=thisPath.indexOf("-");//找到路径中第一个-的位置，以便我们找到路径的初始节点
				int lastArrow=thisPath.lastIndexOf(">");//找到路径中最后一个 >的位置，以便我们找到路径的终止节点
				
				int start=Integer.parseInt(thisPath.substring(0, firstArrow));//路径的初始节点
				int end=Integer.parseInt(thisPath.substring(lastArrow+1, thisPath.length()));//路径的终止节点			
				if(start==end||end==Gend) {
					//以图的终止节点作为路径的终止节点，或者是一个自环，将这两种路径添加到result集合中
					result.add(oldPath.get(i));
				}
				else {
					for(int j=0;j<graph[end].length;j++) 
						
					{   
						if(thisPath.indexOf(String.valueOf(graph[end][j]))!=-1&&start!=graph[end][j]) {//String.valueOf是必要的
							//找出 无法再向后拓展，否则会形成内部循环 的路径，添加到result集合中
							result.add(oldPath.get(i));
						}
						else //扩展路径
						{String temp=oldPath.get(i);
						temp=temp+"->"+graph[end][j];

						newPath.add(temp);}
					}
				}
			}
			
		}while(!newPath.isEmpty());//newPath为空，即没有可以被扩展的路径时，循环结束
	
		//System.out.println(result.size());
//		for(int i=0;i<oldPath.size();i++) {
//			//System.out.println(oldPath.get(i));
//			result.add(oldPath.get(i));
//		}

		ArrayList<String> FinalResult=new ArrayList<String>();//主路径的集合
		//移除所有为其他简单路径子路经的路径，得到主路径
		for(int i=0;i<result.size();i++) {
			boolean ifNoContain=true;
			for(int j=0;j<result.size();j++) {
				String num1=result.get(i);
				String num2=result.get(j);
				if(num2.indexOf(num1)!=-1&&num1!=num2) {
					ifNoContain=false;
					//System.out.println(num2+" has "+num1);
					//break;
				}
				
			}
			if(ifNoContain==true) {
				FinalResult.add(result.get(i));
			}
		}
		System.out.println("主路径的数量："+FinalResult.size());
		for(int i=0;i<FinalResult.size();i++) {
		    
			System.out.println("第"+(i+1)+"条主路径："+FinalResult.get(i));
		}

		return FinalResult;
	}

	public static void main(String args[]){
		int graph[][]=new int[17][];//17行表示16个点，下标为0的行空出。
		graph[1]=new int[]{2};
		graph[2]=new int[]{3,11};
		graph[3]=new int[]{4};
		graph[4]=new int[]{5,8};
		graph[5]=new int[]{6,7};
		graph[6]=new int[]{8};
		graph[7]=new int[]{4};
		graph[8]=new int[]{9,10};
		graph[9]=new int[]{10};
		graph[10]=new int[]{2};
		graph[11]=new int[]{12};
		graph[12]=new int[]{13,16};
		graph[13]=new int[]{14};
		graph[14]=new int[]{15};
		graph[15]=new int[]{12};
		graph[16]=new int[]{-1};
		ArrayList<String> result=PrimePath.Prime(graph, 1, 16);
		//part1 以下计算是否主路径可被一个测试用例覆盖，需要将PrintPrimes中87行的注释去掉,注释88行。若只需知道主路径有哪些，可将以下内容注释
		String testPath=PrintPrimes.printPrimes(6);
		System.out.println("被覆盖");
		for(int i=0;i<result.size();i++) {
			if(testPath.indexOf(result.get(i))!=-1) {
				//System.out.println("第"+(i+1)+"条主路径被当前输入的测试路径所覆盖了");
				System.out.print((i+1)+" ");
			}
		}
		System.out.println("未被覆盖");
		for(int i=0;i<result.size();i++) {
			if(testPath.indexOf(result.get(i))==-1) {
				//System.out.println("第"+(i+1)+"条主路径没有被当前输入的测试路径所覆盖");
				System.out.print((i+1)+" ");
			}
		}
		
		//part2 以下计算是否主路径可被n=0到n=100的测试用例覆盖，需要将PrintPrimes中87行的注释去掉，注释88行。耗时长，若只需知道主路径有哪些，可将以下内容注释
//		boolean[] covered=new boolean[result.size()];
//     
//		for(int i=0;i<100;i++) {
//			for(int j=0;j<result.size();j++) {
//				String testPath=PrintPrimes.printPrimes(i);
//				if(testPath.indexOf(result.get(j))!=-1) {
//					covered[j]=true;
//				}
//			}
//			
//		}
//		for(int i=0;i<covered.length;i++) {
//			System.out.println((i+1)+" "+covered[i]);
//		}
	}
}
