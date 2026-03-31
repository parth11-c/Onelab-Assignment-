package com.onelab.demo.service;

import com.onelab.demo.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReconciliationService {

    public Map<String, Object> reconcile(List<Transaction> transactions, List<Settlement> settlements) {

        Map<String, Transaction> txnMap = new HashMap<>();
        for (Transaction t : transactions) {
            txnMap.put(t.id, t);
        }
        Map<String, Integer> settlementCount = new HashMap<>();

        List<String> late = new ArrayList<>();
        List<String> duplicates = new ArrayList<>();
        List<String> rounding = new ArrayList<>();
        List<String> missing = new ArrayList<>();

        double txnTotal = 0;
        double settlementTotal = 0;

        for (Transaction t : transactions) {
            txnTotal += t.amount;
        }

        Set<String> processed = new HashSet<>();

        for (Settlement s : settlements) {

            if (!processed.contains(s.transactionId)) {
                settlementTotal += s.amount;
                processed.add(s.transactionId);
            }

            settlementCount.put(s.transactionId,
                    settlementCount.getOrDefault(s.transactionId, 0) + 1);

          
            if (s.date.startsWith("2026-04")) {
                late.add(s.transactionId);
            }
            Transaction t = txnMap.get(s.transactionId);
            if (t != null && Math.abs(t.amount - s.amount) > 0.01) {
                rounding.add(s.transactionId);
            }
        }

        for (String id : settlementCount.keySet()) {
            if (settlementCount.get(id) > 1) {
                duplicates.add(id);
            }
        }

        for (Transaction t : transactions) {
            if (!settlementCount.containsKey(t.id)) {
                missing.add(t.id);
            }
        }
        Map<String, Object> result = new HashMap<>();
        result.put("missing", missing);
        result.put("late", late);
        result.put("duplicates", duplicates);
        result.put("rounding", rounding);
        result.put("difference", settlementTotal - txnTotal);
        result.put("note", "Duplicate settlements excluded from total calculation");

        return result;
    }
}