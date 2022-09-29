package my.first.dao;

import my.first.MysqlDataSource;
import my.first.model.ProductInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductInfoDaoImpl implements ProductInfoDao {

    private MysqlDataSource dataSource;

    public ProductInfoDaoImpl() throws ClassNotFoundException {
        this.dataSource = new MysqlDataSource();
    }

    @Override
    public void create(ProductInfo productInfo) {

    }

    @Override
    public List<ProductInfo> readAll() {
        List<ProductInfo> products = new ArrayList<>();
        try {
            final Connection connection = dataSource.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM product_info");
            while (resultSet.next()) {
                final ProductInfo productInfo = new ProductInfo();
                productInfo.setId(resultSet.getInt("id"));
                productInfo.setName(resultSet.getString("product_name"));
                productInfo.setPrice(resultSet.getDouble("price"));
                products.add(productInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void update(ProductInfo productInfo) {

    }

    @Override
    public void delete(ProductInfo productInfo) {

    }
}
