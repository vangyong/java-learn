package cn.segema.learn.tencentcloud;

import java.util.Random;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class APIV3SignDemo {
	
	public static String sign(String s, String key, String method) throws Exception {
		Mac mac = Mac.getInstance(method);
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), mac.getAlgorithm());
		mac.init(secretKeySpec);
		byte[] hash = mac.doFinal(s.getBytes("UTF-8"));
		return DatatypeConverter.printBase64Binary(hash);
	}

	public static String getStringToSign(String method, String endpoint, TreeMap<String, Object> params) {
		StringBuilder s2s = new StringBuilder();
		s2s.append(method).append(endpoint).append("/?");

		for (String k : params.keySet()) {
			s2s.append(k).append("=").append(params.get(k).toString()).append("&");
		}
		return s2s.toString().substring(0, s2s.length() - 1);
	}

	public static void main(String[] args) throws Exception {

		TreeMap<String, Object> params = new TreeMap<String, Object>();
		params.put("Nonce", new Random().nextInt(java.lang.Integer.MAX_VALUE));
		params.put("Timestamp", System.currentTimeMillis() / 1000);
		params.put("Region", "");
		params.put("Action", "SendSms");
		params.put("Version", "2019-07-11");

		String str2sign = getStringToSign("POST", "sms.tencentcloudapi.com", params);
		String signature = sign(str2sign, "", "HmacSHA1");
		System.out.println("Signature=" + signature);
	}
}
