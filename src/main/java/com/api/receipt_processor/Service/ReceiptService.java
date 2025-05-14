package com.api.receipt_processor.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.api.receipt_processor.Model.Item;
import com.api.receipt_processor.Model.Receipt;

import com.api.receipt_processor.Util.Utils;

@Service
public class ReceiptService {

    private static Map<String, Receipt> store = new HashMap<>();

    public static String getId(Receipt reciept) {
        return reciept.getId();
    }

    public static void addReceipt(Receipt receipt) {
        store.put(receipt.getId(), receipt);
    }

    public static Receipt getReceiptById(String id) {

        Receipt receipt = store.get(id);

        return receipt;
    }

    public static int retailerPts(Receipt receipt) {
        return Utils.countAlphaNums(receipt.getRetailer());
    }

    public static int roundPts(Receipt receipt) {
        return Utils.isRound(receipt.getTotal()) ? 50 : 0;
    }

    public static int quarterPts(Receipt receipt) {
        return Utils.inQuarters(receipt.getTotal()) ? 25 : 0;
    }

    public static int pairPts(Receipt receipt) {
        return Utils.pairs(receipt) * 5;
    }

    public static int descriptionPts(Receipt receipt) {
        int pts = 0;
        for (Item item : receipt.getItems()) {
            if (Utils.trimmedLength(item.getDescription())) {
                pts += Utils.priceCalc(item);
            }
        }
        return pts;
    }

    public static int dayPts(Receipt receipt) {
        return (Utils.oddDay(receipt)) ? 6 : 0;
    }

    public static int timePts(Receipt receipt) {
        return (Utils.eveningTime(receipt)) ? 10 : 0;
    }

}
