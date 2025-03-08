package yoanndlg.java_instant_sophro.Service;

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




@Service
public class ProductServiceImpl  implements IProductService {

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
                    productDTO.getDuration(),
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
                        Product product = new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getDuration(), productDTO.getCategories(), productDTO.getModalities());
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
        return List.of();
    }

    /**
     * @param id the id
     * @return
     */
    @Override
    public ProductDTO getProductById(Long id) {
        return null;
    }

    /**
     * @param id         the id
     * @param productDTO the product dto
     * @return
     */
    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return null;
    }

    /**
     * @param id the id
     */
    @Override
    public void deleteProduct(Long id) {

    }
}
