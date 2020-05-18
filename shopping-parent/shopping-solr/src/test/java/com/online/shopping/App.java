package com.online.shopping;


import org.apache.solr.client.solrj.SolrClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.solr.core.SolrTemplate;

@SpringBootApplication
@MapperScan("com.online.shopping.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    @Autowired
    private SolrClient solrClient;

    @Bean
    public SolrTemplate solrTemplate() {
        return new SolrTemplate(solrClient);

    }
}
