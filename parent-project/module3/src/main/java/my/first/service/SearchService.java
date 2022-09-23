package my.first.service;

import my.first.model.ProductInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    private final static List<ProductInfo> warehouse = new ArrayList<>(10);

    static {
        warehouse.add(getInstance(1, "Coffee Black", 3.5));
        warehouse.add(getInstance(2, "Coffee Espresso", 2.9));
        warehouse.add(getInstance(3, "Coffee Latte", 4.0));
        warehouse.add(getInstance(4, "Coffee Latte Big", 4.5));
        warehouse.add(getInstance(5, "Black Tea", 2.5));
        warehouse.add(getInstance(6, "Green Tea", 2.5));
        warehouse.add(getInstance(7, "Water Still", 1.5));
        warehouse.add(getInstance(8, "Water Sparkling", 1.5));
        warehouse.add(getInstance(9, "Coca Cola", 2.0));
        warehouse.add(getInstance(10, "Pepsi Cola", 2.0));
    }

    public List<ProductInfo> search(String pattern) {
        if(pattern == null) {
            return Collections.emptyList();
        }
        return warehouse.stream()
                .filter(productInfo -> productInfo
                        .getName()
                        .toLowerCase()
                        .contains(pattern.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Factory method
     *
     * @param id
     * @param name
     * @param price
     * @return
     */
    static ProductInfo getInstance(int id, String name, double price) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(id);
        productInfo.setName(name);
        productInfo.setPrice(price);
        return productInfo;
    }

}
