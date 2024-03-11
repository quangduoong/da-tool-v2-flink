package com.github.quangduoong.datool.v2.demo.flink.common.stream.utils.impl;

import com.github.quangduoong.datool.v2.demo.flink.common.stream.utils.Utils;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class UtilsImpl implements Utils {

    @Override
    public Config getConfigs() {
        return ConfigFactory.load("application.conf");

    }
}
