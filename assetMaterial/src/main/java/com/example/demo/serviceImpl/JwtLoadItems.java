package com.example.demo.serviceImpl;

import java.security.Key;
import java.util.Base64.Decoder;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.example.demo.model.TechnicalStaffs;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtLoadItems {
	
	private final String secretKey ="3cfa76ef14937c1c0ea519f8fc057a80fcd04a7420f8e8bcd0a7567c272e007b";
	private final long expirationTime = 3600000;
	
	public String generteToken(TechnicalStaffs technicalStaffs) {
		Map<String,Object> claims = new HashMap();
		return createToken(technicalStaffs,claims);
	}
	
	public String createToken(TechnicalStaffs technicalStaffs,Map<String,Object> claims) {
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(technicalStaffs.getSfmEmailId())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+expirationTime))
				.signWith(getSignKey(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	private Key getSignKey() {
		
		byte[] signKey = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(signKey);
	}
	
	public long expiration() {
		
		return expirationTime;
	}
	
	public String exactUserEmail(String token) {
		
		return exactClaims(token,Claims::getSubject);
	}
	
	public Date exactExpirationTime(String token) {
		
		return exactClaims(token,Claims::getExpiration);
	}
	
	private <T> T exactClaims(String token,Function<Claims,T> claimsResolver) {
		
		Claims claims = exactAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims exactAllClaims(String token) {
		
		return Jwts.parserBuilder()
				.setSigningKey(getSignKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	public boolean isValidToken(String token, TechnicalStaffs technicalStaffs) {
		
		String gettedTechnicalStaffsEmailId = exactUserEmail(token);
		return (gettedTechnicalStaffsEmailId.equals(technicalStaffs.getSfmEmailId()) && !isExpiredToken(token));
	}
	
	private boolean isExpiredToken(String token) {
		
		return (exactExpirationTime(token).before(new Date()));
	}
	
	
	
	//start the Logout method via token
	
	Set<String> toLogOutTheToken = new HashSet<String>();
	
	public void logOutToken(String token) {
		
		toLogOutTheToken.add(token);
		
	}
	
	public boolean isTokenLogOut(String token) {
		
		return toLogOutTheToken.contains(token);
	}
	

}
