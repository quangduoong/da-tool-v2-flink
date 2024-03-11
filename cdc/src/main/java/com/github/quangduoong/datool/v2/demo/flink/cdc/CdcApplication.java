package com.github.quangduoong.datool.v2.demo.flink.cdc;

import com.github.quangduoong.datool.v2.demo.flink.cdc.bikesales.BikeSalesCdcProcess;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class CdcApplication {
    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        try {
            if (!args[0].equals("cdc")) {
            }

            switch (args[1]) {

                case "bike_sales":
                    BikeSalesCdcProcess.run(env);
                    break;

                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
