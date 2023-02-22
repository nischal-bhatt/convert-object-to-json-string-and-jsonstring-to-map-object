package com.example.demo;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class ControllerClass {

	@PostMapping("/hey")
	public Map<String,String> store(@RequestBody RequestPayload requestpayload) throws JsonProcessingException
	{
		System.out.println(requestpayload);
		String json = storeToDb(requestpayload);
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});
		
		
		
		return map;
	}

	private String storeToDb(RequestPayload requestpayload) throws JsonProcessingException {
		
		requestpayload.x = "nish";
		requestpayload.y = "bpraakolol.nish";
		
		ObjectWriter ow = new ObjectMapper().writer();
		String json = ow.writeValueAsString(requestpayload);
		System.out.println(json);
		
		return json;
		
	}
}

class RequestPayload{
	
	public String x;
	public String y;
	@Override
	public String toString() {
		return "RequestPayload [x=" + x + ", y=" + y + "]";
	}
	
	
}
