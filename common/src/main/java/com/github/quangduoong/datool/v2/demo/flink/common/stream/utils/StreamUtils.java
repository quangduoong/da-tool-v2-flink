package com.github.quangduoong.datool.v2.demo.flink.common.stream.utils;

import com.github.quangduoong.datool.v2.demo.flink.common.stream.event.CdcEvent;
import org.apache.flink.connector.kafka.source.KafkaSource;

public  interface StreamUtils extends Utils {
    KafkaSource<CdcEvent>  getCdcKafkaSource();
}
