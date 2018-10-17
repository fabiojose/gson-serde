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

> In the example above we are using the generic JsonObject from Gson library, but could be any POJO.

Why I need to pass a class in the GsonSerde's constructor? 

This is necessary because Gson uses the class to parse the things.

Then, use it in `Consumed.with()` or `Prodused.with()`

```java
Consumed.with(Serdes.String(), gsonSerde);

Produced.with(Serdes.String(), gsonSerde);
```
