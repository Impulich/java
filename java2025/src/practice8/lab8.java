import java.util.*;

// ========================= CLASS PRODUCT =========================
class Product {
    private String name;
    private double recommendedPrice;

    public Product(String name, double recommendedPrice) {
        this.name = name;
        this.recommendedPrice = recommendedPrice;
    }

    public String getName() { return name; }
    public double getRecommendedPrice() { return recommendedPrice; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

// ========================= CLASS StoreProduct =========================
// Wrapper: товар + ціна в магазині
class StoreProduct {
    private Product product;
    private double price;

    public StoreProduct(Product product, double price) {
        this.product = product;
        this.price = price;
    }

    public Product getProduct() { return product; }
    public double getPrice() { return price; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoreProduct)) return false;
        StoreProduct that = (StoreProduct) o;
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}

// ========================= CLASS STORE =========================
class Store {
    private String name;
    private Set<StoreProduct> products = new HashSet<>();

    public Store(String name) {
        this.name = name;
    }

    public void addProduct(Product p, double price) {
        products.add(new StoreProduct(p, price));
    }

    public String getName() { return name; }
    public Set<StoreProduct> getProducts() { return products; }
}

// ========================= CLASS SEARCH SERVICE =========================
class SearchService {
    private Set<Store> stores = new HashSet<>();

    public void addStore(Store s) { stores.add(s); }

    // ------------------ TASK 1 ------------------
    public double findMinPrice(Product product) {
        double min = Double.MAX_VALUE;

        for (Store store : stores) {
            for (StoreProduct sp : store.getProducts()) {
                if (sp.getProduct().equals(product)) {
                    if (sp.getPrice() < min) min = sp.getPrice();
                }
            }
        }
        return min;
    }

    // ------------------ TASK 2 ------------------
    public List<String> storesWithMinPrice(Product product) {
        double min = findMinPrice(product);
        List<String> result = new ArrayList<>();

        for (Store store : stores) {
            for (StoreProduct sp : store.getProducts()) {
                if (sp.getProduct().equals(product) && sp.getPrice() == min) {
                    result.add(store.getName());
                }
            }
        }
        return result;
    }

    // ------------------ TASK 3 ------------------
    public boolean storeAllCheaperThanRecommended(Store store) {
        for (StoreProduct sp : store.getProducts()) {
            if (sp.getPrice() >= sp.getProduct().getRecommendedPrice())
                return false;
        }
        return true;
    }

    // Map: кількість товарів у кожному магазині
    public Map<String, Integer> countProductsPerStore() {
        Map<String, Integer> stats = new HashMap<>();

        for (Store s : stores) {
            stats.put(s.getName(), s.getProducts().size());
        }
        return stats;
    }
}

// ========================= MAIN =========================
public class lab8 {
    public static void main(String[] args) {

        Product laptop = new Product("Laptop", 30000);
        Product phone = new Product("Phone", 15000);

        Store s1 = new Store("Rozetka");
        Store s2 = new Store("Comfy");
        Store s3 = new Store("Foxtrot");

        s1.addProduct(laptop, 28000);
        s1.addProduct(phone, 16000);

        s2.addProduct(laptop, 30000);
        s2.addProduct(phone, 14000);

        s3.addProduct(laptop, 28000);
        s3.addProduct(phone, 15500);

        SearchService service = new SearchService();
        service.addStore(s1);
        service.addStore(s2);
        service.addStore(s3);

        System.out.println("Мінімальна ціна на Laptop: " + service.findMinPrice(laptop));
        System.out.println("Магазини з мінімальною ціною: " + service.storesWithMinPrice(laptop));

        System.out.println("Foxtrot усі товари нижче рекомендованої? " +
                service.storeAllCheaperThanRecommended(s3));

        System.out.println("Статистика товарів: " + service.countProductsPerStore());
    }
}
