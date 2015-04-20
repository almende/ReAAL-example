/*
 * Copyright: Almende B.V. (2014), Rotterdam, The Netherlands
 * License: The Apache Software License, Version 2.0
 */
package com.almende.reaal;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

/**
 * The Class SenseClient.
 */
public class SenseClient {
	
	private static OAuthService   service = new ServiceBuilder().provider(SenseAPI.class).apiSecret(Settings.SenseConsumerSecret)
            .apiKey(Settings.SenseConsumerKey).build();
	
	
	/**
	 * Post.
	 *
	 * @param account
	 *            the account
	 * @param path
	 *            the path
	 * @param body
	 *            the body
	 * @return the string
	 */
	public static String post(final AccountBean account, final String path, final String body){
		final Token accessToken = new Token(account.getOauthToken(),account.getOauthSecret());
		OAuthRequest request = new OAuthRequest(Verb.POST, Settings.SenseBaseUrl+path);
		request.addHeader("Content-Type", "application/json");
		request.addPayload(body);
		service.signRequest(accessToken, request);
		
		System.out.println("request:"+request);
		System.out.println(request.getHeaders().toString());
		System.out.println(request.getBodyContents());
		Response response = request.send();
		return response.getBody();
	}
	
	/**
	 * Gets the.
	 *
	 * @param account
	 *            the account
	 * @param path
	 *            the path
	 * @return the string
	 */
	public static String get(final AccountBean account, final String path){
		final Token accessToken = new Token(account.getOauthToken(),account.getOauthSecret());
		OAuthRequest request = new OAuthRequest(Verb.GET, Settings.SenseBaseUrl+path);
		request.addHeader("Accept", "application/json");
		
		service.signRequest(accessToken, request);
		
		System.out.println("request:"+request);
		System.out.println(request.getHeaders().toString());
		Response response = request.send();
		return response.getBody();
	}	
}
