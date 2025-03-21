package com.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.KakaoProfile;
import com.java.dto.OauthToken;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	@Autowired HttpSession session; 

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
//	@ResponseBody
	@RequestMapping("/kakao/oauth")
	public String oauth(String code) {
		
		
		// 1차 인가코드 받기
		System.out.println("kakao oauth code : "+code);
		// code : code
		String grant_type = "authorization_code";
		String client_id = "c525719f62469b47a427c0cd1e9f92d2";
		String redirect_uri = "http://localhost:8181/kakao/oauth";
		String content_type = "application/x-www-form-urlencoded;charset=utf-8";
		
		// ------------------------------ 
		// 2차 토큰키 전송
		
		//HTTP 전송 : HttpURLConnection
//		URL url = new URL(urlBuilder.toString());
//      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//      conn.setRequestMethod("GET");

		
		//HTTP 전송 : RestTemplate
		
		//headers
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", content_type);
		
		//데이터 묶기
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", grant_type);
		params.add("client_id", client_id);
		params.add("redirect_uri", redirect_uri);
		params.add("code", code);
		
		//HTTP 전송
		HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest = new HttpEntity<>(params,headers);
		//http 요청 url
		String oauthUrl = "https://kauth.kakao.com/oauth/token";
		//http 전송
		ResponseEntity<String> response = rt.exchange(oauthUrl, HttpMethod.POST,kakaoTokenRequest,String.class);
		System.out.println("kakaoToken response : "+response);
		//response에서 받은 데이터(json)를 OauthToken객체 파일에 저장
		ObjectMapper objectMapper = new ObjectMapper();
		OauthToken oAuthToken = null;
		
		try {
			oAuthToken = objectMapper.readValue(response.getBody(), OauthToken.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("oAuthToken 객체에서 access_token 출력 : "+oAuthToken.getAccess_token());
		
		//-------------------------------------------------------------------------
		
		// access_token 분리해서 전송하면, 회원정보 아이디,닉네임,사진,성별,... 등을 받아옴
		String access_token = oAuthToken.getAccess_token();
		String authorization = "Bearer "+access_token;
		
		
		// http 전송 : RestTemplate
		RestTemplate rt2 = new RestTemplate();
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", authorization);
		headers2.add("Content-Type", content_type);
		
		// 1개로 묶기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest2 = new HttpEntity<>(headers2); 
		
		//url
		String oauthUrl2 = "https://kapi.kakao.com/v2/user/me";
		
		// http전송 - 카카오 회원정보 : 닉네임, 사진, ...
		ResponseEntity<String> response2 = 
		rt.exchange(oauthUrl2,HttpMethod.POST,kakaoTokenRequest2,String.class);
		System.out.println("회원정보 response2 : "+response2);
		
		System.out.println("데이터 출력 : "+response2.getBody());
		ObjectMapper objectMapper2 = new ObjectMapper();
		KakaoProfile kakaoProfile = null;
		
		try {
			//response에서 받은 데이터(json)를 KakaoProfile객체 저장
			kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
		} catch (Exception e) { e.printStackTrace();}
		
		System.out.println("kakaoProfile 닉네임 : "+kakaoProfile.getProperties().getNickname());
		System.out.println("kakaoProfile id : "+kakaoProfile.getId());
		System.out.println("kakaoProfile profile_image : "+kakaoProfile.getProperties().getProfile_image());
		
		// 세션 저장
		session.setAttribute("kakaoProfile_nickname", kakaoProfile.getProperties().getNickname());
		session.setAttribute("kakaoProfile_id", kakaoProfile.getId());
		
		return "redirect:/";
	}
}
