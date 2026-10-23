package com.trading.wallet.service;

import com.trading.wallet.dto.WalletInformationDto;

public interface IWalletService{
    WalletInformationDto fetchWallet(Long id) ;
}