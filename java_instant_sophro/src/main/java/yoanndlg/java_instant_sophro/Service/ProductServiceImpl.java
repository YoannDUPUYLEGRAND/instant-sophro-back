package yoanndlg.java_instant_sophro.Service;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import yoanndlg.java_instant_sophro.Contracts.IProductService;
import yoanndlg.java_instant_sophro.DTOs.ProductDTO;
import yoanndlg.java_instant_sophro.Exceptions.ProductException;
import yoanndlg.java_instant_sophro.Models.Product;
import yoanndlg.java_instant_sophro.Repository.ProductRepository;
import yoanndlg.java_instant_sophro.Utils.ProductUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl  implements IProductService {

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductRepository productRepository;

    /**
     * @param productDTO the product dto
     * @return
     */
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        try{
            Product product = new Product(
                    productDTO.getName(),
                    productDTO.getDescription(),
                    productDTO.getDurationInMinutes(),
                    productDTO.getCategories(),
                    productDTO.getModalities()
            );
            return ProductUtils.convertToDto(productRepository.save(product));
        } catch (DataIntegrityViolationException e){
            throw new RuntimeException("Produit non crée");
        }
    }

    /**
     * @param productDTOs the product dt os
     * @return
     */
    @Override
    public List<ProductDTO> createAllProducts(List<ProductDTO> productDTOs) {
        List<ProductDTO> createdProducts = new ArrayList<>();
                try{
                    for (ProductDTO productDTO : productDTOs) {
                        Product product = new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getDurationInMinutes(), productDTO.getCategories(), productDTO.getModalities());
                        createdProducts.add(ProductUtils.convertToDto(productRepository.save(product)));
                    }
                    return createdProducts;
                } catch (Exception e) {
                    throw new ProductException("Erreur lors de la création des produits", HttpStatus.INTERNAL_SERVER_ERROR, "PRODUCT_CREATION_ERROR");
                }
    }

    /**
     * @return
     */
    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            productDTOs.add(ProductUtils.convertToDto(product));
        }
        return productDTOs;
    }

    /**
     * @param id the id
     * @return
     */
    @Override
    public ProductDTO getProductById(Long id) {
        try{
            return ProductUtils.convertToDto(productRepository.findById(id).orElseThrow(() ->new ProductException("Produit non trouvé", HttpStatus.NOT_FOUND, "PRODUCT_NOT_FOUND")));
        } catch (ProductException e){
            throw new ProductException("Produit non trouvé", HttpStatus.NOT_FOUND, "PRODUCT_NOT_FOUND");
        }
    }

    /**
     * @param id         the id
     * @param productDTO the product dto
     * @return
     */
    @Override
    @Transactional
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        try {
            Optional<Product> existingProduct = productRepository.findById(id);
            if (existingProduct.isPresent()) {
                Product product = existingProduct.get();
                product.setName(productDTO.getName());
                product.setDescription(productDTO.getDescription());
                product.setDurationInMinutes(productDTO.getDurationInMinutes());
                product.setCategories(productDTO.getCategories());
                product.setModalities(productDTO.getModalities());
                logger.info("Updating product with id: " + id);
                Product updatedProduct = productRepository.save(product);
                logger.info("Product updated successfully");
                return ProductUtils.convertToDto(updatedProduct);
            } else {
                throw new ProductException("Produit non trouvé", HttpStatus.NOT_FOUND, "PRODUCT_NOT_FOUND");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param id the id
     */
    @Override
    public void deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e){
            throw new ProductException("Erreur lors de la récupérations du produit avec l'ID: " + id, HttpStatus.INTERNAL_SERVER_ERROR, "PRODUCT_FETCH_ERROR");
        }
    }

    /**
     * @param ids
     */
    @Override
    public void deleteManyProducts(List<Long> ids) {
        try {
            for (Long id : ids) {
                productRepository.deleteById(id);
            }
        } catch (Exception e){
            throw new ProductException("Erreur lors de la récupérations du produit avec l'ID: " + ids, HttpStatus.INTERNAL_SERVER_ERROR, "PRODUCT_FETCH_ERROR");
        }

    }


}
