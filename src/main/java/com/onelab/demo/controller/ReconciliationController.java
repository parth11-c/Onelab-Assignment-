package com.onelab.demo.controller;

 
 
import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onelab.demo.model.Settlement;
import com.onelab.demo.model.Transaction;
import com.onelab.demo.service.ReconciliationService;

@RestController
@RequestMapping("/api")
public class ReconciliationController {

    private final ReconciliationService service;

    public ReconciliationController(ReconciliationService service) {
        this.service = service;
    }

    @GetMapping("/reconcile")
    public Map<String, Object> reconcile() {

        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", 100.00, "2026-03-30"),
                new Transaction("T2", 200.00, "2026-03-31"),
                new Transaction("T3", 150.50, "2026-03-15"),
                new Transaction("T4", 99.99, "2026-03-20"),
                new Transaction("T5", 300.00, "2026-03-10")
        );

        List<Settlement> settlements = Arrays.asList(
                new Settlement("S1", "T1", 100.00, "2026-03-31"),
                new Settlement("S2", "T2", 200.00, "2026-04-01"),
                new Settlement("S3", "T3", 150.50, "2026-03-16"),
                new Settlement("S4", "T4", 100.00, "2026-03-21"),
                new Settlement("S5", "T5", 300.00, "2026-03-11"),
                new Settlement("S6", "T5", 300.00, "2026-03-11")
        );

        return service.reconcile(transactions, settlements);
    }
}