package com.example.ungdunggiaohang.utils;

import java.text.DecimalFormat;

public class Helper {
    private static Helper instance;

    public String converDoubleToMoney(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        return decimalFormat.format(amount) + "đ";
    }

    public static Helper getInstance() {
        if(instance == null) {
            instance = new Helper();
        }

        return instance;
    }
}
