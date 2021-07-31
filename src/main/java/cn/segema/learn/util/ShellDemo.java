package cn.segema.learn.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import cn.segema.learn.interview.dynamicload.JarLoadDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShellDemo {
	private static Logger logger = LoggerFactory.getLogger(JarLoadDemo.class);

	public static String exec(String command) throws InterruptedException {
		String returnString = "";
		Process pro = null;
		Runtime runTime = Runtime.getRuntime();
		if (runTime == null) {
			System.err.println("Create runtime false!");
		}
		try {
			pro = runTime.exec(command);
			int exitValue = pro.waitFor();  
			if (0 != exitValue) {
				logger.error( "call shell failed. error code is :" + exitValue);
	        }  
			BufferedReader input = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			PrintWriter output = new PrintWriter(new OutputStreamWriter(pro.getOutputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				returnString = returnString + line + "\n";
			}
			input.close();
			output.close();
			pro.destroy();
		} catch (IOException ex) {
			logger.error(ex.getMessage());
		}
		return returnString;
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println(exec("ls -al"));
	}
}
