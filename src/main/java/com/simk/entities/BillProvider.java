package com.simk.entities;

import java.io.Serializable;

public class BillProvider extends Bill implements Serializable {
    private String ProviderName;

    public String getProviderName() {
        return ProviderName;
    }

    public void setProviderName(String providerName) {
        ProviderName = providerName;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s+"," +
                "ProviderName='" + ProviderName + '\'';
    }
}
