/*
 * Copyright: Almende B.V. (2014), Rotterdam, The Netherlands
 * License: The Apache Software License, Version 2.0
 */
package com.almende.reaal;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The Class AccountBean.
 */
@JsonPropertyOrder({ "zprId", "email", "senseId", "password", "oauthToken",
		"oauthSecret", "oauthVerifier","oauthConsumerKey","oauthConsumerSecret" })
public class AccountBean implements Serializable {
	private static final long	serialVersionUID	= -782957937560492020L;

	/**
	 * Instantiates a new account bean.
	 */
	public AccountBean() {}

	private String	zprId			= null;
	private String	email			= null;
	private String	senseId			= null;
	private String	password		= null;
	private String	oauthToken		= null;
	private String	oauthSecret		= null;
	private String	oauthVerifier	= null;
	private String	sessionId		= null;

	/**
	 * @return ZprId
	 */
	public String getZprId() {
		return zprId;
	}

	/**
	 * Sets the zpr id.
	 *
	 * @param zprId
	 *            the new zpr id
	 */
	public void setZprId(String zprId) {
		this.zprId = zprId;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return SenseId
	 */
	public String getSenseId() {
		return senseId;
	}

	/**
	 * Sets the sense id.
	 *
	 * @param senseId
	 *            the new sense id
	 */
	public void setSenseId(String senseId) {
		this.senseId = senseId;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the oauthToken.
	 * 
	 * @return the oauthToken
	 */
	public String getOauthToken() {
		return oauthToken;
	}

	/**
	 * Sets the oauthToken.
	 * 
	 * @param oauthToken
	 *            the new oauthToken
	 */
	public void setOauthToken(String oauthToken) {
		this.oauthToken = oauthToken;
	}

	/**
	 * Gets the oauth secret.
	 *
	 * @return the oauth secret
	 */
	public String getOauthSecret() {
		return oauthSecret;
	}

	/**
	 * Sets the oauth secret.
	 *
	 * @param oauthSecret
	 *            the new oauth secret
	 */
	public void setOauthSecret(String oauthSecret) {
		this.oauthSecret = oauthSecret;
	}

	/**
	 * Gets the oauthVerifier.
	 * 
	 * @return the oauthVerifier
	 */
	public String getOauthVerifier() {
		return oauthVerifier;
	}

	/**
	 * Sets the oauthVerifier.
	 * 
	 * @param oauthVerifier
	 *            the new oauthVerifier
	 */
	public void setOauthVerifier(String oauthVerifier) {
		this.oauthVerifier = oauthVerifier;
	}

	/**
	 * Gets the oauth consumer key.
	 * 
	 * @return the oauth consumer key
	 */
	public String getOauthConsumerKey() {
		return Settings.SenseConsumerKey;
	}

	/**
	 * Gets the oauth consumer secret.
	 * 
	 * @return the oauth consumer secret
	 */
	public String getOauthConsumerSecret() {
		return Settings.SenseConsumerSecret;
	}

	/**
	 * Checks whither the Oauth tokens from Sense are known.
	 * 
	 * @return isOauth
	 */
	public boolean isOauth() {
		return (oauthToken != null && !oauthToken.isEmpty()
				&& oauthVerifier != null && !oauthVerifier.isEmpty());
	}

	/**
	 * Gets the session id.
	 * 
	 * @return the session id
	 */
	@JsonIgnore
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * Sets the session id.
	 * 
	 * @param sessionId
	 *            the new session id
	 */
	@JsonIgnore
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
