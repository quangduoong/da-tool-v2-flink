package com.github.quangduoong.datool.v2.demo.flink.cdc.bikesales;

import com.github.quangduoong.datool.v2.demo.flink.common.stream.event.CdcEvent;
import com.github.quangduoong.datool.v2.demo.flink.common.stream.utils.StreamUtils;
import com.github.quangduoong.datool.v2.demo.flink.common.stream.utils.impl.StreamUtilsImpl;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class BikeSalesCdcProcess {

    private static final StreamUtils streamUtils = new StreamUtilsImpl();

    public static void run(StreamExecutionEnvironment env) throws Exception {

        final KafkaSource<CdcEvent> source = streamUtils.getCdcKafkaSource();
        final WatermarkStrategy<CdcEvent> watermarkStrategy = WatermarkStrategy.<CdcEvent>forMonotonousTimestamps()
                .withTimestampAssigner((event, ts) -> event.getTs());

        DataStream<CdcEvent> stream = env.fromSource(source, watermarkStrategy, "bike_sales_cdc_source");
        stream.print();

        env.execute("cdc_bike_sales");
    }
}
