package com.test.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class PostDemo {

	public static void main(String[] args) throws  Exception {
		postway("https://api.apishop.net/communication/phone/getLocationByPhoneNum?","apiKey=8DYAfSVf07cb15d254e9331cc6c3abd7d0a47b72f474712&phoneNum=18910575487","Content-Type", "application/x-www-form-urlencoded");
		
		// TODO Auto-generated method stub
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
	}
	

	public static void postway(String url,String entity,String type,String value) {
		try {
			HttpPost post = new HttpPost(url);
			try {
				post.setEntity(new StringEntity(entity));
				post.setHeader(type, value);
				CloseableHttpClient client = HttpClients.createDefault();
				try {
					System.out.println("post：" + post);
					CloseableHttpResponse response = client.execute(post);
					System.out.println(EntityUtils.toString(response.getEntity()));
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			
	}

}
