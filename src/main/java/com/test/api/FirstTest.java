package com.test.api;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.test.client.RestfulClient;
import com.test.utils.JSONParser;

 
public class FirstTest {
	RestfulClient client;
	JSONObject responseBody;
	JSONParser jParser;
	int responseCode;
	String city;
	String url = "https://api.apishop.net/communication/phone/getLocationByPhoneNum?"
			+ "apiKey=8DYAfSVf07cb15d254e9331cc6c3abd7d0a47b72f474712" + "&phoneNum=18910575487";
	@BeforeClass
	public void beforeTest() throws ClientProtocolException, IOException, URISyntaxException, ParseException {
		// 发送请求，获取反馈
		client = new RestfulClient();
		client.getResponse(url);
		responseBody = client.getBodyInJSON();
		responseCode = client.getCodeInNumber();
		System.out.println("***************");
		System.out.println("responseBody:"+responseBody);
		System.out.println("***************");
		System.out.println("responseCode:"+responseCode);

        //调用JSONParser获取反馈中的城市信息 
		jParser = new JSONParser();
		city = jParser.getCity(responseBody);
		System.out.println("***************");
		System.out.println("city"+city);
	}
	
	@Test
	public void Test1() {
		assertEquals(city, "北京");
		System.out.println("111");
		assertEquals(responseCode, 200);
		System.out.println("222");
	}
	
	/*@Test
	public void Test2() {
		//assertEquals(city, "北京");
		assertEquals(responseCode, 200);
	}*/
	
	
}
