package cn.segema.learn.interview.protect.p6;

public class Test6 {
	 public static void main(String[] args) {
	        MyObject6 obj = new MyObject6();
	        try {
				obj.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}        // Compile OK   -------（1）
	    }
}
