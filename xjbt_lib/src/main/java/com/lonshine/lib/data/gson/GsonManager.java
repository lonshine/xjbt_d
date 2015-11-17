package com.lonshine.lib.data.gson;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import com.lonshine.lib.data.model.AbstractFeedModel;
import com.lonshine.lib.data.model.AttachObject;
import com.lonshine.lib.data.model.DeserializationExclusionStrategy;
import com.lonshine.lib.data.model.SerializationExclusionStrategy;

import java.lang.reflect.Type;


/**
 * Gson 构造器
 */
public class GsonManager {

    //解析类型
    public static final String TYPE_USER     = "User";//用户


    private static final GsonManager INSTANCE = new GsonManager();

    private GsonManager() {}

    //只能用来解析，但不能用来序列化数据。请注意使用方法。
    public static Gson get() {
        return INSTANCE.mGson;
    }

    Gson mGson = create();

    protected Gson create() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(createFeedModelRuntimeTypeAdapterFactory());
        builder.registerTypeAdapter(new TypeToken<AttachObject>() {
        }.getType(), createAttachObjectTypeAdapter());
        builder.addSerializationExclusionStrategy(new SerializationExclusionStrategy());
        builder.addDeserializationExclusionStrategy(new DeserializationExclusionStrategy());

        builder.registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
            @Override
            public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(String.format("%1$.2f", src));
            }
        });
        builder.registerTypeAdapter(Float.class, new JsonSerializer<Float>() {
            @Override
            public JsonElement serialize(Float src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(String.format("%1$.2f", src));
            }
        });
        return builder.create();
    }

    @NonNull
    private JsonDeserializer<AttachObject> createAttachObjectTypeAdapter() {
        return new JsonDeserializer<AttachObject>() {

            @Override
            public AttachObject deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
                try {
                    AttachObject result = new AttachObject();
                    JsonObject object = json.getAsJsonObject();
                    String class_name = object.get("class_name").getAsString();
                    Class value_type = Class.forName(class_name);

                    result.value = context.deserialize(object.get("value"), value_type);
                    return result;
                } catch (Exception e) {
                    throw new JsonParseException("deserialize attach object failed", e);
                }
            }
        };
    }

    protected RuntimeTypeAdapterFactory<AbstractFeedModel> createFeedModelRuntimeTypeAdapterFactory() {
        return RuntimeTypeAdapterFactory.of(AbstractFeedModel.class, "class_name");
//                .registerSubtype(Link.class, Feed.FEED_TYPE_LINK);
    }
}
