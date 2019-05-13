package com.lifebank.utility;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ServiceUtils {
	public static String objToString(Object o) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(o);
		}catch (Exception e){
			return null;
		}
	}
}
