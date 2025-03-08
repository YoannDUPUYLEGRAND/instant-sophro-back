package yoanndlg.java_instant_sophro.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yoanndlg.java_instant_sophro.DTOs.ProductDTO;
import yoanndlg.java_instant_sophro.Repository.ProductRepository;
import yoanndlg.java_instant_sophro.Service.ProductServiceImpl;



@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    ProductRepository productRepository;


    @PostMapping
    public ResponseEntity<ProductDTO> createProduct (@Validated @RequestBody ProductDTO productDTO){
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
}
