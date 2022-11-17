package my.first.dao;

import my.first.MysqlJdbcDataSource;
import my.first.model.ProductInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductInfoDaoImpl implements ProductInfoDao {

    private final MysqlJdbcDataSource dataSource;

    @Autowired
    private SessionFactory sessionFactory;

    public ProductInfoDaoImpl() {
        this.dataSource = new MysqlJdbcDataSource();
    }

    @Override
    public void create(ProductInfo productInfo) {
        Transaction tx = null;
        try (Session sess = sessionFactory.openSession()) {
            tx = sess.beginTransaction();
            sess.saveOrUpdate(productInfo);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
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
        create(productInfo);
    }

    @Override
    public void delete(ProductInfo productInfo) {
        Transaction tx = null;
        try (Session sess = sessionFactory.openSession()) {
            tx = sess.beginTransaction();
            sess.delete(productInfo);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
