package com.github.quangduoong.datool.v2.demo.flink.common.stream.event;

import lombok.Value;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

@Value
public class CdcEvent {

    private static final long serialVersionUID = 1L;

    @JsonProperty("before")
    private HashMap<String, Object> before;

    @JsonProperty("after")
    private HashMap<String, Object> after;

    @JsonProperty("ts_ms")
    private Long ts;

    @JsonProperty("transaction")
    private String transaction;

    @JsonProperty("source")
    private HashMap<String, Object> source;

    @JsonProperty("op")
    private String op;
}
