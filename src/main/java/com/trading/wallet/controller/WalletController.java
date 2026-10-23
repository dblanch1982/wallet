package com.trading.wallet.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.trading.wallet.dto.*;
import com.trading.wallet.service.IWalletService;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
// @CrossOrigin(origins = {"http://localhost:5173"})
public class WalletController {

    private IWalletService walletService;

    // Get Wallet Information
    // @CrossOrigin(origins = {"http://localhost:5173"})

    @GetMapping(path = "/fetch/{wallet}" , version = "1.0")
    public ResponseEntity<WalletInformationDto> getWalletInformation(@PathVariable Long walletId) {
        WalletInformationDto wallet = walletService.fetchWallet(walletId);
        return ResponseEntity.ok().body(wallet);

    }

}
