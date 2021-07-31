package cn.segema.learn.interview.security;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLEncoderDecoderDemo {
	 public static void main(String[] args) {
	        String encoded = URLEncoder.encode("中文!", StandardCharsets.UTF_8);
	        System.out.println(encoded);
	        
	        String decoded = URLDecoder.decode("%E4%B8%AD%E6%96%87%21", StandardCharsets.UTF_8);
	        System.out.println(decoded);
	    }
}
