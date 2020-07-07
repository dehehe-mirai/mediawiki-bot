package io.hardplant.sync.service.impl;

import org.fastily.jwiki.core.Wiki;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.hardplant.cmmn.WikiEditor;
import io.hardplant.sheet_parser.SheetDAO;
import io.hardplant.sheet_parser.SheetTableConverter;
import io.hardplant.sync.service.SyncService;
import okhttp3.HttpUrl;

@Configuration
public class TestConfig {

    @Value("${wiki.endpoint}")
    private String endpoint;
    
    @Bean
    public SheetDAO sheetDao() {
        return new SheetDAO(); 
    }

    @Bean
    public WikiEditor wikiEditor() {
        return new WikiEditor(new Wiki.Builder().withApiEndpoint(HttpUrl.parse(endpoint)).build());
    }

    @Bean
    public SheetTableConverter converter() {
        return new SheetTableConverter();
    }
    
    @Bean
    public SyncService syncService() {
        return new SyncServiceImpl();
    }
}