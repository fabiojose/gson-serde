package com.github.fabiojose.kafka;

import java.nio.charset.Charset;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.google.gson.Gson;

/**
 * The Gson Serializer, used to get an object and parse to byte array.
 * 
 * @author fabiojose
 *
 * @param <T>
 */
public class GsonSerializer<T> implements Serializer<T> {
	
	private Gson gson = new Gson();

	@Override
	public void close() {
	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {		
	}

	@Override
	public byte[] serialize(String topic, T value) {
		return gson.toJson(value).getBytes(Charset.forName("UTF-8"));
	}

}
