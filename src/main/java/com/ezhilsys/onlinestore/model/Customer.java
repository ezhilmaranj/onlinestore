package com.ezhilsys.onlinestore.model;

import java.util.Date;

public class Customer {
    private String id;

    private boolean isEmployee;

    private boolean isAffiliate;

    private Date memberOn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    public boolean isAffiliate() {
        return isAffiliate;
    }

    public void setAffiliate(boolean isAffiliate) {
        this.isAffiliate = isAffiliate;
    }

    public Date getMemberOn() {
        return memberOn;
    }

    public void setMemberOn(Date memberOn) {
        this.memberOn = memberOn;
    }

}
