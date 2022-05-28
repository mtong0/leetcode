import java.util.*;

public class StockPrice {
    TreeMap<Integer, Set<Integer>> prices;
    HashMap<Integer, Integer> timestamps;
    int max = 0;
    int min = Integer.MIN_VALUE;
    int currentTimestamp;
    public StockPrice() {
        prices = new TreeMap<>();
        timestamps = new HashMap<>();
    }

    public void update(int timestamp, int price) {
        int originalPrice;
        if (timestamp > currentTimestamp) currentTimestamp = timestamp;
        if (timestamps.containsKey(timestamp)) {
            originalPrice = timestamps.get(timestamp);

            prices.get(originalPrice).remove(timestamp);
            if (prices.get(originalPrice).size() == 0) {
                prices.remove(originalPrice);
            }
        } else {
            Set<Integer> s = prices.getOrDefault(price, new HashSet<>());
            s.add(timestamp);
            prices.put(price, s);
        }
        timestamps.put(timestamp, price);
    }

    public int current() {
        return timestamps.get(currentTimestamp);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(1, 5);
        System.out.println(stockPrice.current());
    }
}
