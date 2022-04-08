package com.project.batch.config;

import com.project.batch.model.Transaction;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import javax.batch.api.chunk.ItemReader;

public class SpringBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Value("input/record.csv")
    private Resource inputCsv;

    @Value("file:xml/output.xml")
    private Resource outputXml;

    @Bean
    public ItemReader<Transaction> itemReader() {
        FlatFileItemReader<Transaction> flatFileItemReader = new FlatFileItemReader<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        String tokens[] = {"username", "userid", "transactiondate", "amount"};
        tokenizer.setNames(tokens);
        flatFileItemReader.setResource(inputCsv);
        return flatFileItemReader;
    }
}
