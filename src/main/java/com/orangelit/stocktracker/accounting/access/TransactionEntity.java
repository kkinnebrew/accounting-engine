package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.accounting.models.TransactionLine;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Transactions")
public class TransactionEntity {

    @Id
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    private List<TransactionLine> transactionLines;

    @OneToMany(mappedBy = "transactionId")
    public List<TransactionLine> getTransactionLines() {
        return transactionLines;
    }

}
