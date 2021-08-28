package com.sha.springbootmicroservice3gateway.controller;

import com.google.gson.JsonElement;
import com.sha.springbootmicroservice3gateway.security.UserPrincipal;
import com.sha.springbootmicroservice3gateway.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gateway/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<?> saveTransaction(@RequestBody JsonElement product) {
        return ResponseEntity.ok(transactionService.saveTransaction(product));
    }

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long transactionId) {
        transactionService.deleteTransaction(transactionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllTransactionsOfAuthorizedUser(@AuthenticationPrincipal UserPrincipal principal) {
        return ResponseEntity.ok(transactionService.getAllTransactionsOfAuthorizedUser(principal.getId()));
    }
}
