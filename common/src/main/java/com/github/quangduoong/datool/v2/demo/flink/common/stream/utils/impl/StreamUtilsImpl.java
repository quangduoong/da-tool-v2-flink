package com.github.quangduoong.datool.v2.demo.flink.common.stream.utils.impl;

import com.github.quangduoong.datool.v2.demo.flink.common.stream.event.CdcEvent;
import com.github.quangduoong.datool.v2.demo.flink.common.stream.serde.CdcEventSerde;
import com.github.quangduoong.datool.v2.demo.flink.common.stream.utils.StreamUtils;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;

import java.util.regex.Pattern;

public class StreamUtilsImpl extends UtilsImpl implements StreamUtils {

    @Override
    public KafkaSource<CdcEvent> getCdcKafkaSource() {
        return KafkaSource.<CdcEvent>builder()
                .setBootstrapServers(getConfigs().getString("broker.url"))
                .setStartingOffsets(OffsetsInitializer.committedOffsets(OffsetResetStrategy.EARLIEST))
                .setTopicPattern(Pattern.compile("bike_sales.*"))
                .setValueOnlyDeserializer(new CdcEventSerde.DeserializationSchema())
                .build();
    }
}
