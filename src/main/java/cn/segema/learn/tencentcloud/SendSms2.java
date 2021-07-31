package cn.segema.learn.tencentcloud;

import java.util.ArrayList;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

public class SendSms2 {
	public static void main(String[] args) {
		try {
			int tempId = 846502;
			String phoneNumber = "18190767007";
			ArrayList<String> params = new ArrayList<String>();
			params.add("1");
			params.add("2");
			params.add("3");
			// 初始化单发
			SmsSingleSender singleSender = new SmsSingleSender(1400474204, "15bbdb808cbc4c12de2d291e8d6e46ef");
			SmsSingleSenderResult singleSenderResult = singleSender.sendWithParam("86", phoneNumber, tempId, params,
					"泸州公司", "", "");
			System.out.println(singleSenderResult);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}
