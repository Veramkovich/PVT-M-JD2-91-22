package my.first.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "product_info")
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    @Column(name = "product_name")
    private String name;

    @Column
    private double price;

    public ProductInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductInfo that = (ProductInfo) o;

        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
