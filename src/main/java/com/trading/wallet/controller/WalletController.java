package com.trading.wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.trading.wallet.dto.WalletInformationDto;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/wallet")
@RequiredArgsConstructor 
//@CrossOrigin(origins = {"http://localhost:5173"})
public class WalletController {

    // Get Wallet Information
    //@CrossOrigin(origins = {"http://localhost:5173"})
    public WalletInformationDto getWalletInformation() {
        WalletInformationDto wallet = walletService.getWallet();
        return ResponseEntity.ok().body(wallet);
    // Authentication

    // 



    
}
