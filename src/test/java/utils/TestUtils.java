package utils;

import java.io.File;
import java.util.List;

public class TestUtils {

    public static boolean isSortedAsc(List<Double> prices) {
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) < prices.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static double extractPrice(String priceString) {
        if (priceString.equalsIgnoreCase("Free To Play")) {
            return 0.0;
        }

        try {
            String cleanedPrice = priceString.replace("zł", "").trim();
            cleanedPrice = cleanedPrice.replace(",", "");
            return  Double.parseDouble(cleanedPrice) / 100.0;
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public static String getFileName(String filePath) {
        return new File(filePath).getName();
    }


}
