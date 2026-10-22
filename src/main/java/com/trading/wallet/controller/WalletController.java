package com.trading.wallet.controller;

import org.springframework.http.ResponseEntity;
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

    private final IWalletService walletService;

    // Get Wallet Information
    // @CrossOrigin(origins = {"http://localhost:5173"})
    public ResponseEntity<WalletInformationDto> getWalletInformation() {
        WalletInformationDto wallet = walletService.fetchWallet();
        return ResponseEntity.ok().body(wallet);

    }

}
