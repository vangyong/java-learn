package cn.segema.learn.tencentcloud;

import java.util.ArrayList;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

/**
 * @description 老版本调用
 * @author wangyong
 * @createDate 2021/01/21
 */
public class SendSmsFTW2 {
	public static void main(String[] args) {
		try {
			int tempId = 677305;
			String phoneNumber = "18190767007";
			ArrayList<String> params = new ArrayList<String>();
			params.add("123");
			// 初始化单发
			SmsSingleSender singleSender = new SmsSingleSender(1400197749, "123");
			SmsSingleSenderResult singleSenderResult = singleSender.sendWithParam("86", phoneNumber, tempId, params,
					"联信科技", "", "");
			System.out.println(singleSenderResult);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}
