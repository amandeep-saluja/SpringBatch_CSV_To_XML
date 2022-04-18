package com.project.batch.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "transactionRecord")
public class Transaction {

    private Integer userId;
    private String userName;
    private LocalDateTime transactionDate;
    private Double Amount;

    @Override
    public String toString() {
        return "Transaction{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", transactionDate=" + transactionDate +
                ", Amount='" + Amount + '\'' +
                '}';
    }
}
