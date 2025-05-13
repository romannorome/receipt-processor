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
        System.out.println("Receipt stored with ID: " + receipt.getId());
    }

    public static Receipt getReceiptById(String id) {
        System.out.println("Retrieving reciept with ID: " + id);

        Receipt receipt = store.get(id);
        if (receipt == null) {
            System.out.println("Object with ID: " + id + "not found");
        }
        return receipt;
    }

    public static int retailerPts(Receipt receipt) {
        if (receipt == null) {
            System.out.println("retailerPts: 'reciept' is null");
            return 0;
        }
        return Utils.countAlphaNums(receipt.getRetailer());
    }

    public static int roundPts(Receipt receipt) {
        if (receipt == null) {
            System.out.println("roundPts: 'reciept' is null");
            return 0;
        }
        return Utils.isRound(receipt.getTotal()) ? 50 : 0;
    }

    public static int quarterPts(Receipt receipt) {
        if (receipt == null) {
            System.out.println("quarterPts: 'reciept' is null");
            return 0;
        }
        return Utils.inQuarters(receipt.getTotal()) ? 25 : 0;
    }

    public static int pairPts(Receipt receipt) {
        if (receipt == null) {
            System.out.println("pairPts: 'reciept' is null");
            return 0;
        }
        return Utils.pairs(receipt) * 5;
    }

    public static int descriptionPts(Receipt receipt) {
        if (receipt == null) {
            System.out.println("descriptionPts: 'reciept' is null");
            return 0;
        }
        int pts = 0;
        for (Item item : receipt.getItems()) {
            if (Utils.trimmedLength(item.getDescription())) {
                pts += Utils.priceCalc(item);
            }
        }
        return pts;
    }

    public static int dayPts(Receipt receipt) {
        if (receipt == null) {
            System.out.println("dayPts: 'reciept' is null");
            return 0;
        }
        return (Utils.oddDay(receipt)) ? 6 : 0;
    }

    public static int timePts(Receipt receipt) {
        if (receipt == null) {
            System.out.println("timePts: 'reciept' is null");
            return 0;
        }
        return (Utils.eveningTime(receipt)) ? 10 : 0;
    }

}
