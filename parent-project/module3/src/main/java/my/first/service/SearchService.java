package my.first.service;

import my.first.dao.ProductInfoDao;
import my.first.dao.ProductInfoDaoImpl;
import my.first.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final ProductInfoDao productInfoDao;

    @Autowired
    @Qualifier("simpleHttpClient")
    private HttpClient httpClient;

    @Autowired
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
