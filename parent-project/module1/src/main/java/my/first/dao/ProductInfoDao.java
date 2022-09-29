package my.first.dao;

import my.first.model.ProductInfo;

import java.sql.SQLException;
import java.util.List;

public interface ProductInfoDao {

    void create(ProductInfo productInfo);

    List<ProductInfo> readAll();

    void update(ProductInfo productInfo);

    void delete(ProductInfo productInfo);
}
