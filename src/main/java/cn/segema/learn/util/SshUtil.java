package cn.segema.learn.util;

import java.io.InputStream;
import java.net.Socket;

public class SshUtil {

	public static int detectSshVersion(String ip, int port) throws Exception {
		Socket socket = null;
		InputStream in = null;
		try {
			socket = new Socket(ip, port);
			in = socket.getInputStream();
			byte[] buf = new byte[256];
			int len = in.read(buf);
			if (-1 == len) {
				System.out.println("Invalid SSH Version and set to 2");
				return 2;
			}
			String verString = new String(buf, 0, len);
			int major = 0;
			int minor = 0;
			try {
				int l = verString.indexOf(45);
				int r = verString.indexOf(46);
				major = Integer.parseInt(verString.substring(l + 1, r));
				l = r;
				r = verString.indexOf(45, r);
				if (r == -1) {
					minor = Integer.parseInt(verString.substring(l + 1));
				} else {
					minor = Integer.parseInt(verString.substring(l + 1, r));
				}
			} catch (Throwable var23) {
				System.out.println(var23);
			}
			if (major != 1) {
				return 2;
			}
			if (minor != 99) {
				if (minor >= 5) {
					return 1;
				}
				return 1;
			}
		} catch (Exception var24) {
			throw var24;
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (Exception var22) {
					;
				}
			}

		}
		return 2;
	}

	public static void main(String[] args) throws Exception {
		String ip = "10.51.13.207";
		int port = 22;
		int version = detectSshVersion(ip, port);
		System.out.println(version);
	}

}
