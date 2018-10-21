package com.ezhilsys.onlinestore.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

import com.ezhilsys.onlinestore.model.Bill;
import com.ezhilsys.onlinestore.model.Customer;

public class BillingServiceImpl implements BillingService {

    private static final BigDecimal employeeDiscount = new BigDecimal(30);

    private static final BigDecimal affiliateDiscount = new BigDecimal(10);

    private static final BigDecimal longTermCustomerDiscount = new BigDecimal(5);

    @Override
    public Bill calculateNetAmount(Bill bill) {
        calculateLoyaltyDiscount(bill);
        BigDecimal loyaltyDiscount = bill.getLineItems().stream().map(item -> item.getDiscount()).reduce(BigDecimal::add).get().setScale(2, RoundingMode.FLOOR);

        BigDecimal totalAmount = bill.getLineItems().stream().map(item -> item.getPrice()).reduce(BigDecimal::add).get().setScale(2, RoundingMode.FLOOR);

        bill.setTotalAmount(totalAmount);

        BigDecimal genericDiscount = calculateGenericDiscount(totalAmount.subtract(loyaltyDiscount));

        bill.setDiscountAmount(loyaltyDiscount.add(genericDiscount));

        bill.setNetAmount(totalAmount.subtract(bill.getDiscountAmount()));
        return bill;
    }

    private void calculateLoyaltyDiscount(Bill bill) {
        BigDecimal discountPercentage = findDiscountPercentage(bill.getCustomer());
        if (discountPercentage.intValue() != 0) {
            bill.getLineItems().stream().forEach(item -> {
                if (!item.getType().equalsIgnoreCase("GROCERY")) {
                    item.setDiscount(item.getPrice().multiply(discountPercentage).divide(new BigDecimal(100)).setScale(2, RoundingMode.FLOOR));
                    item.setNetPrice(item.getPrice().subtract(item.getDiscount()));
                }
            });
        }
    }

    private BigDecimal findDiscountPercentage(Customer customer) {
        if (customer.isEmployee()) {
            return employeeDiscount;
        } else if (customer.isAffiliate()) {
            return affiliateDiscount;
        } else {
            return isLongTermCustomer(customer.getMemberOn()) ? longTermCustomerDiscount : BigDecimal.ZERO;
        }
    }

    private boolean isLongTermCustomer(Date memberOn) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, -2);
        return memberOn.before(now.getTime());
    }

    private BigDecimal calculateGenericDiscount(BigDecimal amount) {
        if (amount.doubleValue() >= 100) {
            return new BigDecimal(5).multiply(amount).divide(new BigDecimal(100)).setScale(2, RoundingMode.FLOOR);
        } else {
            return BigDecimal.ZERO;
        }
    }
}
