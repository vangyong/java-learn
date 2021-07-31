package cn.segema.learn.interview.security;

import java.util.Base64;

public class Base64Demo {
	 public static void main(String[] args) {
	        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad };
	        String b64encoded = Base64.getEncoder().encodeToString(input);
	        System.out.println(b64encoded);
	    }
}
