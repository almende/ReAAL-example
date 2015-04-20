package com.almende.reaal;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

/**
 */
public class SenseAPI extends DefaultApi10a
{

  private static final String AUTHORIZATION_URL = "http://api.sense-os.nl/oauth/authorize?oauth_token=%s";

  @Override
  public String getAccessTokenEndpoint()
  {
    return "http://api.sense-os.nl/oauth/access_token";
  }

  @Override
  public String getAuthorizationUrl(Token requestToken)
  {
    return String.format(AUTHORIZATION_URL, requestToken.getToken());
  }

  @Override
  public String getRequestTokenEndpoint()
  {
    return "http://api.sense-os.nl/oauth/request_token";
  }

}
