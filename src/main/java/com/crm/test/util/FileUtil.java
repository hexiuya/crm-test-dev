package com.crm.test.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class FileUtil {
	public static void write(String filePath, List list) {
		FileWriter fw = null;
		try {
			// 如果文件存在，则追加内容；如果文件不存在，则创建文件
			File f = new File(filePath);
			//创建新文件
			if(f.exists()){
				f.delete();
				f.createNewFile();
			}
			fw = new FileWriter(f, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		for (Object object : list) {
			try {
				pw.println(new String(object.toString().getBytes(),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		pw.flush();
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取当前系统的换行符
	 */
	public static String lineSeparator() {
		// 注意在将流写入文件时，换行应根据操作系统的不同来决定。
		// 在程序我们应尽量使用System.getProperty("line.separator")来获取当前系统的换
		// 行符，而不是写/r/n或/n。
		// 这样写程序不够灵活
		// 当我们在java控制台输出的时候，/r和/n都能达到换行的效果。
		if (System.getProperty("line.separator").equals("/r/n")) {
			System.out.println("//r//n is for windows");
			return "/r/n";
		} else if (System.getProperty("line.separator").equals("/r")) {
			System.out.println("//r is for Mac");
			return "/r";
		} else if (System.getProperty("line.separator").equals("/n")) {
			System.out.println("//n is for Unix/Linux");
			return "/n";
		}
		
		return "/r";
	}
}
