package com.sha.springbootmicroservice3gateway.service;

import com.google.gson.JsonElement;
import com.sha.springbootmicroservice3gateway.request.TransactionServiceRequest;
import com.sha.springbootmicroservice3gateway.util.RetrofitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionServiceRequest transactionServiceRequest;

    @Autowired
    public TransactionServiceImpl(TransactionServiceRequest transactionServiceRequest) {
        this.transactionServiceRequest = transactionServiceRequest;
    }

    @Override
    public JsonElement saveTransaction(JsonElement transaction) {
        return RetrofitUtils.executeInBlock(transactionServiceRequest.saveTransaction(transaction));
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        RetrofitUtils.executeInBlock(transactionServiceRequest.deleteTransaction(transactionId));
    }

    @Override
    public List<JsonElement> getAllTransactionsOfAuthorizedUser(Long userId) {
        return RetrofitUtils.executeInBlock(transactionServiceRequest.getAllTransactionsOfAuthorizedUser(userId));
    }
}
