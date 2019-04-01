package cn.tjucic.selenium;


import jxl.*;
import jxl.read.biff.BiffException; 
import java.io.*;
 

public class Selenium {
	String[] id;
	String[] name;
	String[] url;
	public Selenium(String filePath) throws BiffException, IOException {
		Workbook book=Workbook.getWorkbook(new File(filePath));
		Sheet sheet=book.getSheet(0);
		int rows=sheet.getRows();
		int columns=sheet.getColumns();
		System.out.println(rows);
		System.out.println(columns);
		id=new String[rows-2];
		name=new String[rows-2];
		url=new String[rows-2];
		for(int i=2;i<rows;i++) {
			id[i-2]=sheet.getCell(1, i).getContents();//第二列，第n+1行
			name[i-2]=sheet.getCell(2, i).getContents();
			url[i-2]=sheet.getCell(3, i).getContents();
		}
	}
	public static void main(String args[]) throws BiffException, IOException {
		Selenium s=new Selenium("软件测试名单.xls");
		for(int i=0;i<s.id.length;i++) {
			System.out.println(s.id[i]);
			System.out.println(s.name[i]);
			System.out.println(s.url[i]);
			
		}
	}
}
