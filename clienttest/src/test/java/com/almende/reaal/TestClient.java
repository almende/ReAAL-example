/*
 * Copyright: Almende B.V. (2014), Rotterdam, The Netherlands
 * License: The Apache Software License, Version 2.0
 */
package com.almende.reaal;

import junit.framework.TestCase;

import org.junit.Test;

import com.almende.reaal.jackson.JOM;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * The Class TestClient.
 */
public class TestClient extends TestCase {

	/**
	 * Test client.
	 * @throws JsonProcessingException 
	 */
	@Test
	public void testClient() throws JsonProcessingException {
		final AccountBean account = new AccountBean();
		account.setOauthToken("M2FmNDM0ZDJlOTQxYmI1MmRhMWY");
		account.setOauthSecret("ZTM0OGRiM2I5NDZmYWZjODhmNGM");

		System.out.println(SenseClient.get(account, "users/current.json"));

		/**
		 * The Class Sensor.
		 */
		class Sensor{
			private String name="accelerometer";
			private String display_name="Accelerometer";
			private String device_type="BMA123";
			private String pager_type="email";
			private String data_type="json";
			private String data_structure="\"{\"x-axis\":\"float\",\"y-axis\":\"float\",\"z-axis\":\"float\"}";
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getDisplay_name() {
				return display_name;
			}
			public void setDisplay_name(String display_name) {
				this.display_name = display_name;
			}
			public String getDevice_type() {
				return device_type;
			}
			public void setDevice_type(String device_type) {
				this.device_type = device_type;
			}
			public String getPager_type() {
				return pager_type;
			}
			public void setPager_type(String pager_type) {
				this.pager_type = pager_type;
			}
			public String getData_type() {
				return data_type;
			}
			public void setData_type(String data_type) {
				this.data_type = data_type;
			}
			public String getData_structure() {
				return data_structure;
			}
			public void setData_structure(String data_structure) {
				this.data_structure = data_structure;
			}
		}
		
		ObjectNode json = JOM.createObjectNode();
		json.set("sensor", JOM.getInstance().valueToTree(new Sensor()));
		System.out
				.println(SenseClient
						.post(account,
								"sensors",
								json.toString()));
	}
}
