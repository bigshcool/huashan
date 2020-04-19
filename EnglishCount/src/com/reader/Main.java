package com.reader;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("输入读取文件目录");
		Scanner in=new Scanner(System.in);
		String url=in.nextLine();

		String st=null;
		try {
			st=Read.getfile(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------加密算法--------------");
		System.out.println("--------------1.取＋运算算法--------------");
		System.out.println("--------------2.取-加密算法--------------");
		System.out.println("--------------3.取^加密算法--------------");
		System.out.println("--------------4.取反加密算法--------------");
		System.out.println("\n------------输入你需要选择的加密功能--------------");
		int n=in.nextInt();
		int m=0;
		switch (n) {
		case 1:
				System.out.println("输入取+计算方法相加排序的数值");
				m=in.nextInt();
				st=Read.jia(st, m);
				break;
		case 2:
				System.out.println("输入取-计算方法相减排序的数值");
				m=in.nextInt();
				st=Read.jian(st, m);
				break;
		case 3:
				System.out.println("输入取^计算方法的数值");
				m=in.nextInt();
				st=Read.yihuo(st, m);
				break;
		case 4:
				st=Read.res(st);
				break;

		default:
			break;
		}
		in.nextLine();
		System.out.println("输入输出文件目录");
		String url2=in.nextLine();
		Read.StringStream(st, url2);
		
	}

}
