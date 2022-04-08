package com.project.batch.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "transactionRecord")
public class Transaction {
    private String userName;
    private Integer userId;
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
