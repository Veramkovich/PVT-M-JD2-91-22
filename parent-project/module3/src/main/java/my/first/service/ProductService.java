package my.first.service;

import my.first.dao.ProductInfoDao;
import my.first.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Transactional
    public void addNewProduct(ProductInfo product) {
        //TODO: add field validations; check product name duplication;
        productInfoDao.create(product);
    }

}
