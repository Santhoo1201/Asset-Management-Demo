package com.example.demo.responseAndDto;

import java.util.Date;

public class TechnicalStaffsLoginResp {
	
	private String token;
	private long expirationTime;
	
	public TechnicalStaffsLoginResp(String token, long expirationTime) {
		super();
		this.token = token;
		this.expirationTime = expirationTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(long expirationTime) {
		this.expirationTime = expirationTime;
	}
	
	

}
