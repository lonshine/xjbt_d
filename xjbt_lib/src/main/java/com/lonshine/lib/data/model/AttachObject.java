package com.lonshine.lib.data.model;

/**
 * Attach 数据，便于反序列化。
 */
public class AttachObject {
    public static AttachObject by(Object value) {
        AttachObject object = new AttachObject();
        object.class_name = value.getClass().getName();
        object.value = value;
        return object;
    }
    
    public String class_name;
    public Object value;
}
