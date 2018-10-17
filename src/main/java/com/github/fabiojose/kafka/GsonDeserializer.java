package com.github.fabiojose.kafka;

import java.nio.charset.Charset;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.google.gson.Gson;

/**
 * The Gson Deserializer, used to get the Kafka message and parse to object.
 * 
 * @author fabiojose
 *
 * @param <T> The type of JSON Object, the POJO.
 */
public class GsonDeserializer<T> implements Deserializer<T> {
	
	private final Gson gson = new Gson();
	
	private Class<T> type;
	
	public GsonDeserializer(final Class<T> type) {
		this.type = type;
	}

	@Override
	public void close() {
		
	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
		
	}

	@Override
	public T deserialize(final String topic, final byte[] value) {
		
		if(null== value) {
			return null;
		}
		
		String str = new String(value, Charset.forName("UTF-8"));
		return gson.fromJson(str, type);
	}

}
