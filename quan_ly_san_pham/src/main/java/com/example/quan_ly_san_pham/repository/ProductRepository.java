package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> productList = new ArrayList<>();
    private static int currentId = 1;

    static {
        productList.add(new Product(currentId++, "iPhone 13", 999.99, "Smartphone cao cấp của Apple", "Apple"));
        productList.add(new Product(currentId++, "Galaxy S23", 899.99, "Flagship của Samsung", "Samsung"));
        productList.add(new Product(currentId++, "Xiaomi 13", 599.99, "Giá tốt, cấu hình mạnh", "Xiaomi"));
        productList.add(new Product(currentId++, "MacBook Pro", 1999.99, "Laptop dành cho dân chuyên", "Apple"));
        productList.add(new Product(currentId++, "Dell XPS", 1599.99, "Laptop mỏng nhẹ, mạnh mẽ", "Dell"));
        productList.add(new Product(currentId++, "Asus ROG Phone 7", 1099.99, "Điện thoại chơi game cao cấp", "Asus"));
        productList.add(new Product(currentId++, "Surface Laptop 5", 1299.99, "Laptop mượt, thiết kế đẹp", "Microsoft"));
        productList.add(new Product(currentId++, "OnePlus 11", 699.99, "Cấu hình cao, giá tốt", "OnePlus"));
        productList.add(new Product(currentId++, "Lenovo ThinkPad X1", 1799.99, "Laptop doanh nhân", "Lenovo"));
        productList.add(new Product(currentId++, "Huawei P60 Pro", 799.99, "Camera đẹp, thiết kế sang", "Huawei"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        product.setId(currentId++);
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.set(i, product);
                return;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                return;
            }
        }
    }

    @Override
    public List<Product> searchByName(String keyword) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

}
