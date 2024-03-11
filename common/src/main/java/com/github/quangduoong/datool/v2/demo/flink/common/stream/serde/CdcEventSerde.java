package com.github.quangduoong.datool.v2.demo.flink.common.stream.serde;

import com.github.quangduoong.datool.v2.demo.flink.common.stream.event.CdcEvent;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CdcEventSerde {

    public static class DeserializationSchema
            implements org.apache.flink.api.common.serialization.DeserializationSchema<CdcEvent> {

        @Override
        public CdcEvent deserialize(byte[] bytes) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readValue(bytes, CdcEvent.class);
        }

        @Override
        public boolean isEndOfStream(CdcEvent cdcEvent) {
            return false;
        }

        @Override
        public TypeInformation<CdcEvent> getProducedType() {
            return null;
        }
    }
}
