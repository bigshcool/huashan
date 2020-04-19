package com.reader;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.org.apache.xalan.internal.xsltc.trax.OutputSettings;

public class Read {
	public static String getfile(String name) throws IOException {
		BufferedReader file=new BufferedReader(new FileReader(name));
		Map<String, Integer>  map=new HashMap<>();
		String s=null;
		while((s=file.readLine())!=null) {
			String [] temp=s.split("[[^a-zA-Z]]");
			for(String one:temp) {
				if(map.containsKey(one)) {
					map.put(one, map.get(one)+1);
				}else {
					map.put(one,1);
				}
			}
		}
		file.close();
		
		ArrayList<Map.Entry<String, Integer>> arrayList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		//排序
		Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() {
		    public int compare(Map.Entry<String, Integer> map1, Map.Entry<String, Integer> map2) {
		        return (map2.getValue() - map1.getValue());
		    }
		});
		StringBuilder sb=new StringBuilder();
		//输出
		for (Entry<String, Integer> entry : arrayList) {
		    System.out.println(entry.getKey() + "\t" + entry.getValue());
		    if(entry.getValue()>1) {
		    	sb.append(entry.getValue());
		    }
		}
		return sb.toString();
		
	}
	
	public static String yihuo(String st,int n) {
		char [] array=st.toCharArray();
		for(int i=0;i<array.length;i++) {
			array[i]=(char) (array[i]^n);
		}
		return new String(array);
	}
	
	public static String jia(String st,int n) {
		char [] array=st.toCharArray();
		for(int i=0;i<array.length;i++) {
			array[i]=(char) (array[i]+n);
		}
		return new String(array);
	}
	
	public static String jian(String st,int n) {
		char [] array=st.toCharArray();
		for(int i=0;i<array.length;i++) {
			array[i]=(char) (array[i]-n);
		}
		return new String(array);
	}
	
	public static String res(String st) {
		StringBuilder sb=new StringBuilder(st);
		return sb.reverse().toString();
	}
	
	public static void StringStream(String st,String url) {
		InputStream in=new ByteArrayInputStream(st.getBytes());
		BufferedInputStream bs=new BufferedInputStream(in);
		int len=0;
		byte[] b=new byte[1024];
		OutputStream out=null;
		try {
			out=new FileOutputStream(new File(url));
			len=bs.read(b);
			if(len>0) {
				out.write(b, 0, len);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		try {
			out.close();
			bs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
