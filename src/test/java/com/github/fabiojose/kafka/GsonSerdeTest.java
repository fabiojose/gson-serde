package com.github.fabiojose.kafka;

import java.nio.charset.Charset;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

//Testing
public class GsonSerdeTest extends TestCase {
	
	private static final Gson GSON = new Gson();
	
	private static final String JSON = "{\"name\":\"fabiojose\"}";
	
	private static final byte[] BYTES = JSON.getBytes(Charset.forName("UTF-8"));
	
	private static final String TOPIC = "my.topic";
	
	private static JsonObject TO_TEST = GSON.fromJson(JSON, JsonObject.class);

	public GsonSerdeTest( String testName ) {
        super( testName );
    }
	
	public static Test suite() {
        return new TestSuite( GsonSerdeTest.class );
    }
	
	public void testDeserializer() {
		try(GsonDeserializer<JsonObject> de = new GsonDeserializer<>(JsonObject.class)){
		
			JsonObject actual = de.deserialize(TOPIC, BYTES);
			assertEquals(TO_TEST, actual);
			
		}
	}
	
	public void testSerializer() {
		try(GsonSerializer<JsonObject> se = new GsonSerializer<>()){
			
			byte[] actual = se.serialize(TOPIC, TO_TEST);
			assertTrue("Teste do serializer falhou", Arrays.equals(BYTES, actual));
			
		}
	}
}
