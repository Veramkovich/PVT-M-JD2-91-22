package my.first.service;

import my.first.dao.ProductInfoDao;
import my.first.dao.ProductInfoDaoImpl;
import my.first.model.ProductInfo;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    private final ProductInfoDao productInfoDao;

    public SearchService() throws IOException, ClassNotFoundException {
        this(new ProductInfoDaoImpl());
    }

    public SearchService(ProductInfoDao productInfoDao) {
        this.productInfoDao = productInfoDao;
    }

    public List<ProductInfo> search(String pattern) {
        if (pattern == null) {
            return Collections.emptyList();
        }
        return productInfoDao.readAll().stream()
                .filter(productInfo -> productInfo
                        .getName()
                        .toLowerCase()
                        .contains(pattern.toLowerCase()))
                .collect(Collectors.toList());
    }
}
