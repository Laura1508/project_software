package com.api.reporte_financiero.service;

import com.api.reporte_financiero.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionClassifier {

        public List<Transaction> filterIncomes(List<Transaction> txs) {
            return txs.stream()
                    .filter(tx -> !tx.getAccountFrom().equals(tx.getAccountTo()))
                    .collect(Collectors.toList());
        }

        public List<Transaction> filterSelfTransfers(List<Transaction> txs) {
            return txs.stream()
                    .filter(tx -> tx.getAccountFrom().equals(tx.getAccountTo()))
                    .collect(Collectors.toList());
        }
    }
