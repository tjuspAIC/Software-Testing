package cn.tjucic.st;

import java.util.ArrayList;

public class PrimePath {
	public static ArrayList Prime(int graph[][],int Gstart,int Gend) {//��һ������Ϊ��ʾ����ͼ�ıߵĶ�ά���飬�ڶ�������Ϊ��ʼ�ڵ�ı�ţ�����������Ϊ��ֹ�ڵ�ı��
		ArrayList<String> result=new ArrayList<>();//��������д洢�����ּ�·����1.����ֹ�ڵ���Ϊ���һ���ڵ��
		//2.�Ի� 3.��������չ�������ڲ�ѭ����·��     ������·�����ǲ��ܱ���չ��      �����·���ļ����У���δ�Ƴ���ЩΪ������·����·����·��
		ArrayList<String> oldPath=new ArrayList<>();
		for(int i=1;i<graph.length;i++) {
			oldPath.add(String.valueOf(i));
		}
		//��ʱoldPathΪ����Ϊ0�ļ�·��
		ArrayList<String> newPath=new ArrayList<>();
		for(int i=0;i<oldPath.size();i++) {
			int onlyYou=Integer.parseInt(oldPath.get(i));			
			if(onlyYou==Gend) {//��ֹ����ֹ�ڵ��·�����ܱ���չ����ӵ�result������
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
		//��ʱnewPathΪ����Ϊ1�ļ�·��
		
		do {
			//��ԭnewPath��Ϊ�µ�oldPath
			oldPath=new ArrayList<String> (newPath);
			newPath.clear();
//			for(int i=0;i<newPath.size();i++) {
//				System.out.println(oldPath.get(i));
//			}
			for(int i=0;i<oldPath.size();i++) {
				String thisPath=oldPath.get(i);
				int firstArrow=thisPath.indexOf("-");//�ҵ�·���е�һ��-��λ�ã��Ա������ҵ�·���ĳ�ʼ�ڵ�
				int lastArrow=thisPath.lastIndexOf(">");//�ҵ�·�������һ�� >��λ�ã��Ա������ҵ�·������ֹ�ڵ�
				
				int start=Integer.parseInt(thisPath.substring(0, firstArrow));//·���ĳ�ʼ�ڵ�
				int end=Integer.parseInt(thisPath.substring(lastArrow+1, thisPath.length()));//·������ֹ�ڵ�			
				if(start==end||end==Gend) {
					//��ͼ����ֹ�ڵ���Ϊ·������ֹ�ڵ㣬������һ���Ի�����������·����ӵ�result������
					result.add(oldPath.get(i));
				}
				else {
					for(int j=0;j<graph[end].length;j++) 
						
					{   
						if(thisPath.indexOf(String.valueOf(graph[end][j]))!=-1&&start!=graph[end][j]) {//String.valueOf�Ǳ�Ҫ��
							//�ҳ� �޷��������չ��������γ��ڲ�ѭ�� ��·������ӵ�result������
							result.add(oldPath.get(i));
						}
						else //��չ·��
						{String temp=oldPath.get(i);
						temp=temp+"->"+graph[end][j];

						newPath.add(temp);}
					}
				}
			}
			
		}while(!newPath.isEmpty());//newPathΪ�գ���û�п��Ա���չ��·��ʱ��ѭ������
	
		//System.out.println(result.size());
//		for(int i=0;i<oldPath.size();i++) {
//			//System.out.println(oldPath.get(i));
//			result.add(oldPath.get(i));
//		}

		ArrayList<String> FinalResult=new ArrayList<String>();//��·���ļ���
		//�Ƴ�����Ϊ������·����·����·�����õ���·��
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
		System.out.println("��·����������"+FinalResult.size());
		for(int i=0;i<FinalResult.size();i++) {
		    
			System.out.println("��"+(i+1)+"����·����"+FinalResult.get(i));
		}

		return FinalResult;
	}

	public static void main(String args[]){
		int graph[][]=new int[17][];//17�б�ʾ16���㣬�±�Ϊ0���пճ���
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
		//part1 ���¼����Ƿ���·���ɱ�һ�������������ǣ���Ҫ��PrintPrimes��87�е�ע��ȥ��,ע��88�С���ֻ��֪����·������Щ���ɽ���������ע��
		String testPath=PrintPrimes.printPrimes(6);
		System.out.println("������");
		for(int i=0;i<result.size();i++) {
			if(testPath.indexOf(result.get(i))!=-1) {
				//System.out.println("��"+(i+1)+"����·������ǰ����Ĳ���·����������");
				System.out.print((i+1)+" ");
			}
		}
		System.out.println("δ������");
		for(int i=0;i<result.size();i++) {
			if(testPath.indexOf(result.get(i))==-1) {
				//System.out.println("��"+(i+1)+"����·��û�б���ǰ����Ĳ���·��������");
				System.out.print((i+1)+" ");
			}
		}
		
		//part2 ���¼����Ƿ���·���ɱ�n=0��n=100�Ĳ����������ǣ���Ҫ��PrintPrimes��87�е�ע��ȥ����ע��88�С���ʱ������ֻ��֪����·������Щ���ɽ���������ע��
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
