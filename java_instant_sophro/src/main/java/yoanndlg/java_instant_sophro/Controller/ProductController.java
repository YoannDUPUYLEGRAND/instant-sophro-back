package yoanndlg.java_instant_sophro.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yoanndlg.java_instant_sophro.DTOs.ProductDTO;
import yoanndlg.java_instant_sophro.Enum.CategoryType;
import yoanndlg.java_instant_sophro.Enum.ProductModality;
import yoanndlg.java_instant_sophro.Repository.ProductRepository;
import yoanndlg.java_instant_sophro.Service.ProductServiceImpl;

import java.util.List;
import java.util.Set;


/**
 * The type Product controller.
 */
//TODO Add @CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductServiceImpl productService;

    /**
     * The Product repository.
     */
    @Autowired
    ProductRepository productRepository;


    /**
     * Create product response entity.
     *
     * @param productDTO the product dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct (@Validated @RequestBody ProductDTO productDTO){
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }


    /**
     * Create all products response entity.
     *
     * @param productDTOs the product dt os
     * @return the response entity
     */
    @PostMapping("/all")
    public ResponseEntity<List<ProductDTO>> createAllProducts(@Validated @RequestBody List<ProductDTO> productDTOs) {
        List<ProductDTO> createdProducts = productService.createAllProducts(productDTOs);
        return new ResponseEntity<>(createdProducts, HttpStatus.CREATED);
    }

    /**
     * Get all products response entity .
     *
     * @return the response entity
     */
    @GetMapping
    public ResponseEntity <List<ProductDTO>> getAllProducts(){
        logger.info("Fetching all products");
        List<ProductDTO> productDTOs = productService.getAllProducts();
        return ResponseEntity.ok(productDTOs);
    }

    /**
     * Get product by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        ProductDTO productDTO = productService.getProductById(id);
        return ResponseEntity.ok(productDTO);
    }

    /**
     * Update product response entity.
     *
     * @param id         the id
     * @param productDTO the product dto
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @Validated @RequestBody ProductDTO productDTO){
        ProductDTO updatedProduct = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * Delete product response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Produit supprimé",HttpStatus.NO_CONTENT);
    }


    /**
     * Delete many products response entity.
     *
     * @param ids the ids
     * @return the response entity
     */
    @DeleteMapping
    public ResponseEntity<String> deleteManyProducts(@RequestBody List<Long> ids){
        productService.deleteManyProducts(ids);
        return new ResponseEntity<>("Produits supprimés avec succès",HttpStatus.NO_CONTENT);
    }



    @GetMapping("/by-categories")
    public ResponseEntity<List<ProductDTO>> getProductsByCategories(@RequestParam Set<CategoryType> categories) {
        List<ProductDTO> products = productService.getProductsByCategory(categories);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/by-modalities")
    public ResponseEntity<List<ProductDTO>> getProductsByModalities(@RequestParam Set<ProductModality> modalities) {
        List<ProductDTO> products = productService.getProductsByModalities(modalities);
        return ResponseEntity.ok(products);
    }
}
