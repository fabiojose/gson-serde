package com.github.fabiojose.kafka;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

/**
 * Kafka Gson Serde.
 * 
 * @author fabiojose
 *
 */
public final class GsonSerde<T> implements Serde<T> {
	
	private Class<T> type;
	
	public GsonSerde(final Class<T> type) {
		this.type = type;
	}

	@Override
	public void close() {		
	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {		
	}

	@Override
	public Deserializer<T> deserializer() {
		return new GsonDeserializer<>(type);
	}

	@Override
	public Serializer<T> serializer() {
		return new GsonSerializer<>();
	}
}
