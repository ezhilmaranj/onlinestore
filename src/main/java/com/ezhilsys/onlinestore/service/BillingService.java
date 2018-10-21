package com.ezhilsys.onlinestore.service;

import com.ezhilsys.onlinestore.model.Bill;

public interface BillingService {

    Bill calculateNetAmount(Bill bill);

}