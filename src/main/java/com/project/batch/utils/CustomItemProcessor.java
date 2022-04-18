package com.project.batch.utils;

import com.project.batch.model.Transaction;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Transaction, Transaction> {
    @Override
    public Transaction process(Transaction transaction) throws Exception {
        System.out.println("Processing item: " + transaction.toString());
        return transaction;
    }
}
