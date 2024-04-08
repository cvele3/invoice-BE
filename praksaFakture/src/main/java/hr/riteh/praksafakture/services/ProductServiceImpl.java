package hr.riteh.praksafakture.services;

import hr.riteh.praksafakture.database.dto.ProductEntityDto;
import hr.riteh.praksafakture.database.entity.ProductEntity;
import hr.riteh.praksafakture.database.mapper.ProductMapper;
import hr.riteh.praksafakture.database.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Double getTotalProductsPrice(Map<Long, Long> products) {
        log.info("Calculating total price of products");

        return products.entrySet().stream()
                .mapToDouble(entry -> productRepository.findById(entry.getKey()).get().getPrice() * entry.getValue())
                .sum();
    }

    @Override
    public ProductEntity getProduct(Long productId) {
        log.info("Getting product with id: {}", productId);
        return productRepository.findById(productId)
            .orElseThrow(() -> new IllegalArgumentException("Product with id: " + productId + " does not exist"));
    }

    @Override
    public Double getSumProductPrice(Long productId, Long quantity) {
        log.info("Calculating price of product with id: {} and quantity: {}", productId, quantity);
        return productRepository.findById(productId).get().getPrice() * quantity;
    }

    @Override
    public ProductEntity createProduct(ProductEntity productEntity) {
        log.info("Creating product: {}", productEntity.getName());
        return productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        log.info("Getting all products");
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long productId) {
        log.info("Deleting product with id: {}", productId);
        productRepository.deleteById(productId);
    }

    @Override
    public ProductEntity updateProduct(ProductEntityDto productEntityDto) {
        log.info("Updating product with id: {}", productEntityDto.getId());
        ProductEntity oldProductEntity = productRepository.findById(productEntityDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Product with id: " + productEntityDto.getId() + " does not exist"));

        log.info("ProductEntity before update: {}", oldProductEntity.toString());
        ProductEntity updatedProductEntity = productMapper.update(oldProductEntity, productEntityDto);
        productRepository.save(updatedProductEntity);

        log.info("ProductEntity after update: {}", updatedProductEntity.toString());
        return updatedProductEntity;
    }
}
