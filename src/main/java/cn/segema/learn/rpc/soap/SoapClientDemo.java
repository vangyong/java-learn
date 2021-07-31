package cn.segema.learn.rpc.soap;

import java.util.Arrays;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.log4j.Logger;

public class SoapClientDemo {
	
	private static final Logger logger = Logger.getLogger(SoapClientDemo.class);

	public static void main(String[] args) throws Exception {

////		System.setProperty("org.apache.cxf.stax.allowInsecureParser", "1");
////		System.setProperty("UseSunHttpHandler", "false");
//		JaxWsDynamicClientFactory factroy = JaxWsDynamicClientFactory.newInstance();
//		Client client = factroy.createClient("http://localhost:8080/csa/services/disposalStrategy?wsdl");
//		// QName name = new QName("http://service.xzyd.cupid.tsoc.venustech.com/",
//		// "disposalStrategy");
//		
//		String param = "<?xml version='1.0' encoding='utf-8'?><content><field><token>8123d04f47cc94413687ed09d7871150</token><resource_id>01dc3fcc7d514027a67e76cba17b1a2b</resource_id><disposal_object_type>恶意ip</disposal_object_type>    <disposal_resource>112.96.66.179</disposal_resource><ip_type>IPV4</ip_type><ip_ascription_type>移动自有</ip_ascription_type><ip_department></ip_department><ip_business_system></ip_business_system><customer></customer><customer_business_system></customer_business_system><disposal_description>针对恶意ip行为进行描述，或对该恶意资源进行处置建议描述</disposal_description><whether_disposal>是</whether_disposal><cause></cause><disposal_status>已结束</disposal_status><disposal_type>0</disposal_type><disposal_time>1626419910513</disposal_time><branch_code>xz</branch_code><disposal_person></disposal_person></field></content>";
//		Object[] results = client.invoke("disposalStrategy", param);
//		logger.info("sendCxf 结果:" + Arrays.toString(results));
		
		
//		System.setProperty("org.apache.cxf.stax.allowInsecureParser", "1");
//		System.setProperty("UseSunHttpHandler", "false");
		JaxWsDynamicClientFactory factroy = JaxWsDynamicClientFactory.newInstance();
		Client client = factroy.createClient("http://ws.webxml.com.cn/WebServices/TraditionalSimplifiedWebService.asmx?wsdl");
		// QName name = new QName("http://service.xzyd.cupid.tsoc.venustech.com/",
		// "disposalStrategy");
		Object[] results = client.invoke("toTraditionalChinese", "123333");
		logger.info("sendCxf 结果:" + Arrays.toString(results));

	}

}
