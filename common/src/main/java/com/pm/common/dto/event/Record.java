package com.pm.common.dto.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.PROPERTY,
//        property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = ProductRecord.class, name = "product_record"),
//        @JsonSubTypes.Type(value = OrderRecord.class, name = "order_record")
//})
public interface Record {
//    protected String type;
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public Record() {
//
//    }
}
