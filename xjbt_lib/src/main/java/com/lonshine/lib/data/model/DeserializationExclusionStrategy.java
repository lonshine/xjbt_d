package com.lonshine.lib.data.model;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;

/**
 * 反序列化操作。
 * 添加对@Expose属性的deserialize的值进行判断。
 */
public class DeserializationExclusionStrategy implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        final Expose expose = fieldAttributes.getAnnotation(Expose.class);
        return expose != null && !expose.deserialize();
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
