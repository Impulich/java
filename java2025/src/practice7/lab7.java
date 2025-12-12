package practice7;

import java.util.*;

class Product {
    String name;
    double rec;
    Product(String n, double r){ name=n; rec=r; }
}

class Store {
    String name;
    Map<Product, Double> prices = new HashMap<>();
    Store(String n){ name=n; }
    void add(Product p,double price){ prices.put(p,price); }
}

class SearchService {
    List<Store> stores = new ArrayList<>();

    // 1) Типізований iterator (b)
    double findMin(String product) {
        double min = Double.MAX_VALUE;
        Iterator<Store> it = stores.iterator();
        while (it.hasNext()) {
            for (var e : it.next().prices.entrySet())
                if (e.getKey().name.equals(product))
                    min = Math.min(min, e.getValue());
        }
        return min;
    }

    // 2) Нетипізований iterator (a)
    List<Store> storesWithMin(String product) {
        double min = findMin(product);
        List<Store> res = new ArrayList<>();
        Iterator it = stores.iterator();
        while (it.hasNext()) {
            Store s = (Store) it.next();
            for (var e : s.prices.entrySet())
                if (e.getKey().name.equals(product) && e.getValue() == min)
                    res.add(s);
        }
        return res;
    }

    // 3) for-each (c)
    List<Store> allCheaper() {
        List<Store> res = new ArrayList<>();
        for (Store s : stores) {
            boolean ok = true;
            for (var e : s.prices.entrySet())
                if (e.getValue() >= e.getKey().rec) ok = false;
            if (ok) res.add(s);
        }
        return res;
    }
}

public class lab7 {
    public static void main(String[] args) {

        Product phone = new Product("Телефон", 900);
        Product laptop = new Product("Ноутбук", 2000);

        Store s1 = new Store("Rozetka");
        s1.add(phone, 850);

        Store s2 = new Store("Comfy");
        s2.add(phone, 850);
        s2.add(laptop, 1999);

        Store s3 = new Store("Foxtrot");
        s3.add(phone, 890);

        SearchService ss = new SearchService();
        ss.stores.addAll(List.of(s1, s2, s3));

        System.out.println("1) Мінімальна ціна на товар:");
        System.out.println("   " + ss.findMin("Телефон"));

        System.out.println("\n2) Магазини з мінімальною ціною:");
        ss.storesWithMin("Телефон").forEach(s ->
                System.out.println("   - " + s.name)
        );

        System.out.println("\n3) Магазини, де ВСІ товари дешевші за рекомендовану ціну:");
        ss.allCheaper().forEach(s ->
                System.out.println("   - " + s.name)
        );
    }
}
