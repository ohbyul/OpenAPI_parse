package com.xii.transfer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class movie_XMLtoJSON {
    public static void main(String[] args) {
	
    	// 인증키 (개인이 받아와야함) www.kobis.or.kr 사이트 가입후 발급 
    	String key = "";

    	// 파싱한 데이터를 저장할 변수
    	String result = "";

    	//xml 형식으로 가져온 데이터
    	String resultXML ="";
    	
    	try {
    		
    		//xml 형식으로 읽어오기
    		URL urlXML = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.xml?key="
    				+ key + "&movieCd=20124039");
    		BufferedReader bf2;
    		bf2 = new BufferedReader(new InputStreamReader(urlXML.openStream(), "UTF-8"));
    		resultXML = bf2.readLine();
    		System.out.println("가져온 데이터 XML 형식: " + resultXML);
    		System.out.println("====================================================================");
    		
    		//json 형식으로 읽어오기
    		URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key="
    				+ key + "&movieCd=20124039");
    		BufferedReader bf;
    		bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
    		result = bf.readLine();
    		System.out.println("가져온 데이터 JSON 형식: " + result);
    		System.out.println("====================================================================");
    		
    		
    		org.json.JSONObject xmlJSONObj = XML.toJSONObject(resultXML.toString());

    		String xmlJSONObjString = xmlJSONObj.toString();
    		
    		System.out.println("XML -> JSON : " + xmlJSONObjString );




    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}