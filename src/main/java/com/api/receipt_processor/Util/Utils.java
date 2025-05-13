package com.api.receipt_processor.Util;

import java.time.LocalDate;
import java.time.LocalTime;

import com.api.receipt_processor.Model.Item;
import com.api.receipt_processor.Model.Receipt;

public class Utils {
    public static int countAlphaNums(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isRound(double total) {

        return (total == (int) total) ? true : false;
    }

    public static boolean inQuarters(double total) {
        return (total % .25 == 0) ? true : false;
    }

    public static int pairs(Receipt receipt) {
        int itemCount = receipt.items.size();

        return itemCount / 2;
    }

    public static boolean trimmedLength(String str) {
        return (str.trim().length() % 3 == 0) ? true : false;
    }

    public static int priceCalc(Item item) {
        long calc = Math.round(item.getPrice() * 0.2);

        return (int) calc;
    }

    public static boolean oddDay(Receipt receipt) {
        LocalDate date = receipt.getPurchase_Date();
        int day = date.getDayOfMonth();

        return (day % 2 != 0) ? true : false;
    }

    public static boolean eveningTime(Receipt receipt) {
        LocalTime time = receipt.getPurchase_Time();
        LocalTime after = LocalTime.of(14, 0);
        LocalTime before = LocalTime.of(16, 0);

        return (time.isAfter(after) && time.isBefore(before)) ? true : false;
    }
}
