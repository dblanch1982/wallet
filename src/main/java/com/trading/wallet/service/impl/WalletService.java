package com.trading.wallet.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trading.wallet.dto.WalletInformationDto;
import com.trading.wallet.entity.Wallet;
import com.trading.wallet.repository.WalletRepository;
import com.trading.wallet.service.IWalletService;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class WalletService implements IWalletService {

    private final WalletRepository walletRepository;

    public WalletInformationDto fetchWallet(Long id) {
        Optional<Wallet> wallet = walletRepository.findById(id);
        return transformerToWalletInformationDto(wallet.get());
    }

    private WalletInformationDto transformerToWalletInformationDto(Wallet wallet) {
        return new WalletInformationDto(wallet.getWalletId(), wallet.getName(), wallet.getDescription());
    }
}