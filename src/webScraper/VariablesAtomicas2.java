package webScraper;

import java.util.HashMap;
import java.util.Map;

public class VariablesAtomicas2 {
    public static void main(String[] args) {


        String from = "BCN";
        String to = "JFK";

        Double lowestPrice = 0.0;
        Double avgPrice = 0.0;
        Double result = getPriceTrip("Delta Airlines", from, to);
        System.out.println(result);
    }

    private static double getPriceTrip(String airline, String from, String to) {
        Map<String, Double> pricesByAirline = new HashMap<>();
        pricesByAirline.put("American Airlines", 550.0);
        pricesByAirline.put("US Airways", 619.0);
        pricesByAirline.put("Delta Airlines", 540.0);
        pricesByAirline.put("Singapore Airlines", 612.0);
        pricesByAirline.put("Qatar Airways", 590.0);
        pricesByAirline.put("Cathay Pacific Airways", 585.0);
        pricesByAirline.put("Sky Airlines", 540.0);
        pricesByAirline.put("Copa Airlines Colombia", 510.0);
        pricesByAirline.put("Avianca", 580.0);
        pricesByAirline.put("LATAM Airlines Group", 500.0);
        pricesByAirline.put("AeroMexico", 710.0);
        pricesByAirline.put("Aerolineas Argentinas", 940.0);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pricesByAirline.get(airline);
    }
}
