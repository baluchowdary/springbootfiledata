package com.kollu.springbootfiledata.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Configuration;

import com.kollu.springbootfiledata.util.CustomCacheErrorHandler;

@Configuration
public class RedisCacheErrorHandlerConfig implements CachingConfigurer {

    private static final Logger log = LoggerFactory.getLogger(RedisCacheErrorHandlerConfig.class);

    @Override
    public CacheErrorHandler errorHandler() {
        return new CustomCacheErrorHandler();
    }
}
