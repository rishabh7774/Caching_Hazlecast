package com.example.Caching_Hazlecast.config;

import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public Config configure() {
        return new Config()
                .setInstanceName("hazlecast-insatnce")
                .addMapConfig(new MapConfig()
                        .setName("userCache")
                        .setTimeToLiveSeconds(60)
                        .setEvictionConfig(new EvictionConfig()
                                .setSize(200)
                                .setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE)
                                .setEvictionPolicy(EvictionPolicy.LRU)
                        )
                );
    }

}