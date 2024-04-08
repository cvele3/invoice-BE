package hr.riteh.praksafakture.controllers;

import hr.riteh.praksafakture.constants.ControllerConstants;
import hr.riteh.praksafakture.constants.PathParamConstants;
import hr.riteh.praksafakture.database.dto.ProductEntityDto;
import hr.riteh.praksafakture.database.entity.ProductEntity;
import hr.riteh.praksafakture.services.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(ControllerConstants.PRODUCT)
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(PathParamConstants.GET_ALL_PRODUCTS)
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        log.info("Getting all products");
        List<ProductEntity> productEntityList = productService.getAllProducts();

        return new ResponseEntity<>(productEntityList, HttpStatus.OK);
    }

    @GetMapping(PathParamConstants.GET_PRODUCT_BY_ID + "/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long id) {
        log.info("Getting product by id");
        ProductEntity productEntity = productService.getProduct(id);

        return new ResponseEntity<>(productEntity, HttpStatus.OK);
    }

    @PostMapping(value = PathParamConstants.CREATE_PRODUCT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity productEntity) {
        log.info("Creating product");
        ProductEntity createdProductEntity = productService.createProduct(productEntity);

        return new ResponseEntity<>(createdProductEntity, HttpStatus.OK);
    }

    @DeleteMapping(value = PathParamConstants.DELETE_PRODUCT + "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        log.info("Deleting product");
        productService.deleteProduct(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = PathParamConstants.UPDATE_PRODUCT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntityDto productEntityDto) {
        log.info("Updating product");
        ProductEntity updatedProductEntity = productService.updateProduct(productEntityDto);

        return new ResponseEntity<>(updatedProductEntity, HttpStatus.OK);
    }
}