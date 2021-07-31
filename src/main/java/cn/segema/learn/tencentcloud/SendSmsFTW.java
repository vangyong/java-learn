package cn.segema.learn.tencentcloud;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;

/**
 * @description 新版本调用
 * @author wangyong
 * @createDate 2021/01/21
 */
public class SendSmsFTW {
	public static void main(String[] args) {
		try {

			Credential cred = new Credential("11","22");

			HttpProfile httpProfile = new HttpProfile();
			httpProfile.setEndpoint("sms.tencentcloudapi.com");

			ClientProfile clientProfile = new ClientProfile();
			clientProfile.setHttpProfile(httpProfile);

			SmsClient client = new SmsClient(cred, "", clientProfile);

			SendSmsRequest req = new SendSmsRequest();
			req.setSmsSdkAppid("1400197749");
			req.setSign("汇诚联信");
			req.setTemplateID("677305");
			
//			req.setSmsSdkAppid("15bbdb808cbc4c12de2d291c8d6e46ef");
			
			String[] phoneNumberSet1 = { "18190767007" };
			req.setPhoneNumberSet(phoneNumberSet1);

			String[] templateParamSet1 = {"ABC"};
			req.setTemplateParamSet(templateParamSet1);

			SendSmsResponse resp = client.SendSms(req);

			System.out.println(SendSmsResponse.toJsonString(resp));
		} catch (TencentCloudSDKException e) {
			System.out.println(e.toString());
		}

	}
}
