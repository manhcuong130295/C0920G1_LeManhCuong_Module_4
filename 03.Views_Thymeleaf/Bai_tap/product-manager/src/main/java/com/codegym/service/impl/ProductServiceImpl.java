package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> productMap = new TreeMap<>();

    static {
        productMap.put(1, new Product( "SP-001", "iphone", 1200,  10,"https://didongviet.vn/pub/media/catalog/product/i/p/iphone-xs-max-64gb-like-new_2.jpg"));
        productMap.put(2, new Product( "SP-002", "nokia", 1200,10,"https://cdn.shopify.com/s/files/1/2505/6374/products/nokia_5_3-front_back-Cyan-en_IN.png?v=1599046616"));
        productMap.put(3, new Product("SP-003", "samsung galaxy", 1200,  10,"https://www.gizmochina.com/wp-content/uploads/2020/07/Samsung-Galaxy-Note-20-Ultra-564x564.jpg"));
        productMap.put(4, new Product("SP-004", "sony", 1200,  10,"https://drop.ndtv.com/TECH/product_database/images/320201754510PM_635_sony_xperia_l1_front_back.jpeg"));
        productMap.put(5, new Product( "SP-005", "exiter", 10200, 10,"https://cdn.bongdaplus.vn/Assets/Media/2020/06/23/63/yamaha-exciter-d.jpg"));
        productMap.put(6, new Product( "SP-006", "airblade", 11200,  10,"https://i.ytimg.com/vi/L8g1phODlcg/hqdefault.jpg"));
        productMap.put(7, new Product( "SP-007", "apple watch", 1200, 10,"https://images-na.ssl-images-amazon.com/images/I/71wa1rw1tUL._AC_SX522_.jpg"));
        productMap.put(8, new Product( "SP-008", "ipad", 1200,  10,"https://m.media-amazon.com/images/I/714poCrMlHL._AC_SL1500_.jpg"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
