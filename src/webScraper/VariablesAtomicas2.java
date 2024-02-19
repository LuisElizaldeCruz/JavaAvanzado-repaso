package webScraper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class VariablesAtomicas2 {
    private static Map<String, Double> pricesByAirline;

    public static void main(String[] args) {
        init();

        String from = "BCN";
        String to = "JFK";

        Double lowestPrice = getLowestPrice(from, to);
        Double avgPrice = getAvgtPrice(from, to);

        System.out.println("Lowest price: " + lowestPrice);
        System.out.printf("avg price: %.2f",avgPrice);
    }

    private static Double getLowestPrice(String from, String to) {

        AtomicReference<Double> lowestPrice = new AtomicReference<>(null);
        pricesByAirline.keySet().stream().parallel().forEach(airline -> {
            Double price = getPriceTrip(airline, from, to);
            if (lowestPrice.get() == null || price < lowestPrice.get()) {
                lowestPrice.set(price);
            }

        });
        return lowestPrice.get();
    }

    private static Double getAvgtPrice(String from, String to) {

        AtomicReference<Double> sumPrice = new AtomicReference<>(0.0);
        AtomicInteger countAirlines = new AtomicInteger(0);
        pricesByAirline.keySet().stream().parallel().forEach(airline -> {
            Double price = getPriceTrip(airline, from, to);
            double result = sumPrice.get() + price;
            sumPrice.set(result);
            countAirlines.incrementAndGet();

        });

        return sumPrice.get() / countAirlines.get();
    }

    private static void init() {
        pricesByAirline = new HashMap<>();
        pricesByAirline.put("American Airlines", 550.0);
        pricesByAirline.put("US Airways", 610.0);
        pricesByAirline.put("Delta Airlines", 540.0);
        pricesByAirline.put("Singapore Airlines", 612.0);
        pricesByAirline.put("Qatar Airways", 590.0);
        pricesByAirline.put("Cathay Pacific Airways", 585.0);
        pricesByAirline.put("Sky Airlines", 540.0);
        pricesByAirline.put("Copa Airlines Colombia", 610.0);
        pricesByAirline.put("Avianca", 580.0);
        pricesByAirline.put("LATAM Airlines Group", 600.0);
        pricesByAirline.put("AeroMexico", 740.0);
        pricesByAirline.put("Aerolineas Argentinas", 940.0);
    }

    private static Double getPriceTrip(String airline, String from, String to) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pricesByAirline.get(airline);
    }
}
