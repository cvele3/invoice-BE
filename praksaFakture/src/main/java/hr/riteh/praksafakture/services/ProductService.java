package hr.riteh.praksafakture.services;

import hr.riteh.praksafakture.database.dto.ProductEntityDto;
import hr.riteh.praksafakture.database.entity.ProductEntity;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Double getTotalProductsPrice(Map<Long, Long> products);

    ProductEntity getProduct(Long productId);

    Double getSumProductPrice(Long productId, Long quantity);

    ProductEntity createProduct(ProductEntity productEntity);
    List<ProductEntity> getAllProducts();

    void deleteProduct(Long productId);

    ProductEntity updateProduct(ProductEntityDto productEntityDto);
}
