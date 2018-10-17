# gson-serde
Kafka Serde that wraps the Gson library and we can work with JSON on topics.

# How to use

Import the `GsonSerde` class

```java
import com.github.fabiojose.kafka.GsonSerde;
```

Create an instance of `GsonSerde`

```java
final GsonSerde<JsonObject> gsonSerde = new GsonSerde<>(JsonObject.class);
```

In the example above we are using the generic JsonObject of Gson library, but cound be any POJO.

Then, use it in `Consumed.with()` or `Prodused.with()`

```java
Consumed.with(Serdes.String(), gsonSerde);

Produced.with(Serdes.String(), gsonSerde);
```
