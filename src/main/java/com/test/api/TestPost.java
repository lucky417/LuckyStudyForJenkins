package com.test.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.client.RestfulClient;
import com.test.utils.ExcelProcess;
import com.test.utils.JSONParserSe;

public class TestPost extends testApi {

	public TestPost() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Object[][] excelData;
	RestfulClient client;
	HashMap<String, String> hashHead;
	String url;
    int responseCode;
    com.alibaba.fastjson.JSONObject responseBody;
    HashMap<String, String> responseHeads;
	
	@BeforeClass
	public void setup() throws Exception {
		//读取用例Excel
		excelData = ExcelProcess.proessExcel(super.excelPath, 0);

		//实例化client
		client = new RestfulClient();
		
		//设置好请求头部
		hashHead = new HashMap<String,String>();
		hashHead.put("Content-Type","application/x-www-form-urlencoded");	
	}
	
	
	@Test
	public void testPostRequest() throws Exception {
		for(int i=1;i<excelData.length;i++) {
			//从特定位置读取测试数据
			String address = excelData[i][3].toString();
		    url = host + address;
		    String checpPoint = excelData[i][4].toString();
		    String checkValue = excelData[i][5].toString();
		    //用namevaluepair存储所有请求参数
		    List<NameValuePair> keys = new ArrayList<NameValuePair>();
		for (int j=7;j<excelData[i].length-1;j=j+2) {
			//因为每种参数个数不确定，在这里进行非空判断
			if(excelData[i][j]==null) {
				break;
			}
			NameValuePair pair = new BasicNameValuePair(excelData[i][j].toString(),excelData[i][j+1].toString());
			keys.add(pair);
			System.out.println(pair);
		}
		//发出请求
		client.sendPost(url, keys, hashHead);
		responseBody=client.getBodyInJSON();
		responseCode=client.getCodeInNumber();
		
		//JSONParserSe jParser = new JSONParserSe();
		//boolean result= jParser.isResponseCorrect(responseBody, checpPoint, checkValue);
 		
		//断言判断结果
		Assert.assertEquals(responseCode, 200);
		System.out.println(responseCode);	
		}
	}

	
	
}
