package com.test.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.client.RestfulClient;
import com.test.utils.ExcelProcess;
import com.test.utils.JSONParserSe;

public class TestPost2 extends testApi {

	public TestPost2() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Object[][] excelData;
	RestfulClient client;
	HashMap<String, String> hashHead;
	String url="https://api.apishop.net/communication/phone/getLocationByPhoneNum";
    int responseCode;
    com.alibaba.fastjson.JSONObject responseBody;
    HashMap<String, String> responseHeads;
	
	@Test
	public void testPostRequest() throws Exception {
		/*
	 		//1. choise one type
		HttpPost post = new HttpPost("https://api.apishop.net/communication/phone/getLocationByPhoneNum?");
		//2. add the header submi the parameter as the table type
	    post.setHeader("Content-Type", "application/x-www-form-urlencoded");
	    //3.add the paremeter
	    post.setEntity(new StringEntity("apiKey=8DYAfSVf07cb15d254e9331cc6c3abd7d0a47b72f474712&phoneNum=18910575487"));
	    //4.click the send button
	    CloseableHttpClient client = HttpClients.createDefault();
	    //5.get the response
	    CloseableHttpResponse response = client.execute(post);
	    //output
	    System.out.println(EntityUtils.toString(response.getEntity()));
	    System.out.println("good");

		*/
	
		
		client = new RestfulClient();
		
	      List<NameValuePair> params = new ArrayList<NameValuePair>();
	      params.add(new BasicNameValuePair("apiKey", " 8DYAfSVf07cb15d254e9331cc6c3abd7d0a47b72f474712"));
	      params.add(new BasicNameValuePair("phoneNum", "18910575487"));
	      
			//设置好请求头部
			hashHead = new HashMap<String,String>();
			hashHead.put("Content-Type","application/x-www-form-urlencoded");
		
		//发出请求
		client.sendPost(url, params, hashHead);
		responseBody=client.getBodyInJSON();
		responseCode=client.getCodeInNumber();
		
		JSONParserSe jParser = new JSONParserSe();
 		
		//断言判断结果
		Assert.assertEquals(responseCode, 200);
		System.out.println(responseCode);
		
	}

	
}
