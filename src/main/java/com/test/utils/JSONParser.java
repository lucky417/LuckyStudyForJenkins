package com.test.utils;

import com.alibaba.fastjson.JSONObject; 

public class JSONParser {
    JSONObject internalJSON; 
    
    public String getCity(JSONObject jo){
        String province ="";
        try { 
        	//先获取反馈中的result这个一个内部JSON对象　
            JSONObject internalJSON = jo.getJSONObject("result");
            //再根据键名查找键值
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&");
            System.out.println(internalJSON);
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&");
             province = internalJSON.getString("city") ;
        }catch (Exception e){
            e.printStackTrace();
        }
		return province;
    }

}
