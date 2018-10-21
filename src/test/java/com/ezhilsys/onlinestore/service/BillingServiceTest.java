package com.ezhilsys.onlinestore.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ezhilsys.onlinestore.model.Bill;
import com.ezhilsys.onlinestore.model.Customer;
import com.ezhilsys.onlinestore.model.Item;

import junit.framework.Assert;

public class BillingServiceTest {

    private BillingService billingService = new BillingServiceImpl();

    List<Item> lineItems = null;
    Bill bill = new Bill();

    @Before
    public void setupBillData() {
    }

    @Test
    public void validateEmployeeWithGenericDiscount() {
        lineItems = new ArrayList<>();
        Item item1 = new Item();
        item1.setId("1");
        item1.setPrice(new BigDecimal(50));
        item1.setType("GENERAL");
        lineItems.add(item1);

        Item item2 = new Item();
        item2.setId("2");
        item2.setPrice(new BigDecimal(50));
        item2.setType("GROCERY");
        lineItems.add(item2);

        Item item3 = new Item();
        item3.setId("3");
        item3.setPrice(new BigDecimal(50));
        item3.setType("GENERAL");
        lineItems.add(item3);

        Item item4 = new Item();
        item4.setId("4");
        item4.setPrice(new BigDecimal(50));
        item4.setType("GENERAL");
        lineItems.add(item4);

        Item item5 = new Item();
        item5.setId("5");
        item5.setPrice(new BigDecimal(50));
        item5.setType("GENERAL");
        lineItems.add(item5);
        bill.setLineItems(lineItems);

        Customer customer = new Customer();
        customer.setEmployee(true);
        bill.setCustomer(customer);
        billingService.calculateNetAmount(bill);

        Assert.assertEquals(180.50, bill.getNetAmount().doubleValue());
    }

    @Test
    public void validateOnlyEmployeeDiscount() {
        lineItems = new ArrayList<>();
        Item item1 = new Item();
        item1.setId("1");
        item1.setPrice(new BigDecimal(4));
        item1.setType("GENERAL");
        lineItems.add(item1);

        Item item2 = new Item();
        item2.setId("2");
        item2.setPrice(new BigDecimal(13));
        item2.setType("GROCERY");
        lineItems.add(item2);

        Item item3 = new Item();
        item3.setId("3");
        item3.setPrice(new BigDecimal(2));
        item3.setType("GENERAL");
        lineItems.add(item3);

        Item item4 = new Item();
        item4.setId("4");
        item4.setPrice(new BigDecimal(5));
        item4.setType("GENERAL");
        lineItems.add(item4);

        Item item5 = new Item();
        item5.setId("5");
        item5.setPrice(new BigDecimal(9));
        item5.setType("GENERAL");
        lineItems.add(item5);
        bill.setLineItems(lineItems);

        Customer customer = new Customer();
        customer.setEmployee(true);
        bill.setCustomer(customer);
        billingService.calculateNetAmount(bill);
        
        Assert.assertEquals(27.00, bill.getNetAmount().doubleValue());
    }

    @Test
    public void validateAffiliateWithGenericDiscount() {

        lineItems = new ArrayList<>();
        Item item1 = new Item();
        item1.setId("1");
        item1.setPrice(new BigDecimal(50));
        item1.setType("GENERAL");
        lineItems.add(item1);

        Item item2 = new Item();
        item2.setId("2");
        item2.setPrice(new BigDecimal(50));
        item2.setType("GROCERY");
        lineItems.add(item2);

        Item item3 = new Item();
        item3.setId("3");
        item3.setPrice(new BigDecimal(50));
        item3.setType("GENERAL");
        lineItems.add(item3);

        Item item4 = new Item();
        item4.setId("4");
        item4.setPrice(new BigDecimal(50));
        item4.setType("GENERAL");
        lineItems.add(item4);

        Item item5 = new Item();
        item5.setId("5");
        item5.setPrice(new BigDecimal(50));
        item5.setType("GENERAL");
        lineItems.add(item5);
        bill.setLineItems(lineItems);

        Customer customer = new Customer();
        customer.setAffiliate(true);
        bill.setCustomer(customer);
        billingService.calculateNetAmount(bill);
        Assert.assertEquals(218.50, bill.getNetAmount().doubleValue());
    }

    @Test
    public void validateAffiliateDiscount() {
        lineItems = new ArrayList<>();
        Item item1 = new Item();
        item1.setId("1");
        item1.setPrice(new BigDecimal(4));
        item1.setType("GENERAL");
        lineItems.add(item1);

        Item item2 = new Item();
        item2.setId("2");
        item2.setPrice(new BigDecimal(13));
        item2.setType("GROCERY");
        lineItems.add(item2);

        Item item3 = new Item();
        item3.setId("3");
        item3.setPrice(new BigDecimal(2));
        item3.setType("GENERAL");
        lineItems.add(item3);

        Item item4 = new Item();
        item4.setId("4");
        item4.setPrice(new BigDecimal(5));
        item4.setType("GENERAL");
        lineItems.add(item4);

        Item item5 = new Item();
        item5.setId("5");
        item5.setPrice(new BigDecimal(9));
        item5.setType("GENERAL");
        lineItems.add(item5);
        bill.setLineItems(lineItems);

        Customer customer = new Customer();
        customer.setAffiliate(true);
        bill.setCustomer(customer);
        billingService.calculateNetAmount(bill);
        Assert.assertEquals(31.00, bill.getNetAmount().doubleValue());
    }

    @Test
    public void validateLogTermCustomerWithGenericDiscount() {
        lineItems = new ArrayList<>();
        Item item1 = new Item();
        item1.setId("1");
        item1.setPrice(new BigDecimal(50));
        item1.setType("GENERAL");
        lineItems.add(item1);

        Item item2 = new Item();
        item2.setId("2");
        item2.setPrice(new BigDecimal(50));
        item2.setType("GROCERY");
        lineItems.add(item2);

        Item item3 = new Item();
        item3.setId("3");
        item3.setPrice(new BigDecimal(50));
        item3.setType("GENERAL");
        lineItems.add(item3);

        Item item4 = new Item();
        item4.setId("4");
        item4.setPrice(new BigDecimal(50));
        item4.setType("GENERAL");
        lineItems.add(item4);

        Item item5 = new Item();
        item5.setId("5");
        item5.setPrice(new BigDecimal(50));
        item5.setType("GENERAL");
        lineItems.add(item5);
        bill.setLineItems(lineItems);

        Customer customer = new Customer();
        customer.setMemberOn(new Date("2015/01/01"));
        bill.setCustomer(customer);
        billingService.calculateNetAmount(bill);
        
        Assert.assertEquals(228.00, bill.getNetAmount().doubleValue());
    }

    @Test
    public void validateLogTermCustomerDiscount() {

        lineItems = new ArrayList<>();
        Item item1 = new Item();
        item1.setId("1");
        item1.setPrice(new BigDecimal(4));
        item1.setType("GENERAL");
        lineItems.add(item1);

        Item item2 = new Item();
        item2.setId("2");
        item2.setPrice(new BigDecimal(13));
        item2.setType("GROCERY");
        lineItems.add(item2);

        Item item3 = new Item();
        item3.setId("3");
        item3.setPrice(new BigDecimal(2));
        item3.setType("GENERAL");
        lineItems.add(item3);

        Item item4 = new Item();
        item4.setId("4");
        item4.setPrice(new BigDecimal(5));
        item4.setType("GENERAL");
        lineItems.add(item4);

        Item item5 = new Item();
        item5.setId("5");
        item5.setPrice(new BigDecimal(9));
        item5.setType("GENERAL");
        lineItems.add(item5);
        bill.setLineItems(lineItems);

        Customer customer = new Customer();
        customer.setMemberOn(new Date("2015/01/01"));
        bill.setCustomer(customer);
        billingService.calculateNetAmount(bill);
        
        Assert.assertEquals(32.00, bill.getNetAmount().doubleValue());
    }

    @Test
    public void validateGenericDiscount() {
        lineItems = new ArrayList<>();
        Item item1 = new Item();
        item1.setId("1");
        item1.setPrice(new BigDecimal(50));
        item1.setType("GENERAL");
        lineItems.add(item1);

        Item item2 = new Item();
        item2.setId("2");
        item2.setPrice(new BigDecimal(50));
        item2.setType("GROCERY");
        lineItems.add(item2);

        Item item3 = new Item();
        item3.setId("3");
        item3.setPrice(new BigDecimal(50));
        item3.setType("GENERAL");
        lineItems.add(item3);

        Item item4 = new Item();
        item4.setId("4");
        item4.setPrice(new BigDecimal(50));
        item4.setType("GENERAL");
        lineItems.add(item4);

        Item item5 = new Item();
        item5.setId("5");
        item5.setPrice(new BigDecimal(50));
        item5.setType("GENERAL");
        lineItems.add(item5);
        bill.setLineItems(lineItems);

        Customer customer = new Customer();
        customer.setMemberOn(new Date("2017/01/01"));
        bill.setCustomer(customer);
        billingService.calculateNetAmount(bill);
        
        Assert.assertEquals(237.50, bill.getNetAmount().doubleValue());
    }

    @Test
    public void validateZeroDiscount() {
        lineItems = new ArrayList<>();
        Item item1 = new Item();
        item1.setId("1");
        item1.setPrice(new BigDecimal(4));
        item1.setType("GENERAL");
        lineItems.add(item1);

        Item item2 = new Item();
        item2.setId("2");
        item2.setPrice(new BigDecimal(13));
        item2.setType("GROCERY");
        lineItems.add(item2);

        Item item3 = new Item();
        item3.setId("3");
        item3.setPrice(new BigDecimal(2));
        item3.setType("GENERAL");
        lineItems.add(item3);

        Item item4 = new Item();
        item4.setId("4");
        item4.setPrice(new BigDecimal(5));
        item4.setType("GENERAL");
        lineItems.add(item4);

        Item item5 = new Item();
        item5.setId("5");
        item5.setPrice(new BigDecimal(9));
        item5.setType("GENERAL");
        lineItems.add(item5);
        bill.setLineItems(lineItems);

        Customer customer = new Customer();
        customer.setMemberOn(new Date("2017/01/01"));
        bill.setCustomer(customer);
        billingService.calculateNetAmount(bill);
        
        Assert.assertEquals(33.00, bill.getNetAmount().doubleValue());
    }
}
