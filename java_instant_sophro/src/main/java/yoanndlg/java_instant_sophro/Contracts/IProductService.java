package yoanndlg.java_instant_sophro.Contracts;

import yoanndlg.java_instant_sophro.DTOs.ProductDTO;
import yoanndlg.java_instant_sophro.Enum.CategoryType;
import yoanndlg.java_instant_sophro.Enum.ProductModality;

import java.util.List;
import java.util.Set;

/**
 * The interface Product service.
 */
public interface IProductService {

    /**
     * Create product product dto.
     *
     * @param productDTO the product dto
     * @return the product dto
     */
    ProductDTO createProduct(ProductDTO productDTO);

    /**
     * Create all products list.
     *
     * @param productDTOs the product dt os
     * @return the list
     */
    List<ProductDTO> createAllProducts(List<ProductDTO> productDTOs);

    /**
     * Gets all products.
     *
     * @return the all products
     */
    List<ProductDTO> getAllProducts();

    /**
     * Gets product by id.
     *
     * @param id the id
     * @return the product by id
     */
    ProductDTO getProductById(Long id);

    /**
     * Update product product dto.
     *
     * @param id         the id
     * @param productDTO the product dto
     * @return the product dto
     */
    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    /**
     * Delete product.
     *
     * @param id the id
     */
    void deleteProduct(Long id);


    /**
     * Delete many products.
     *
     * @param ids the ids
     */
    void deleteManyProducts(List<Long>ids);


    /**
     * Gets products by category.
     *
     * @param categories the categories
     * @return the products by category
     */
    List<ProductDTO> getProductsByCategory(Set<CategoryType> categories);

    /**
     * Gets products by modalities.
     *
     * @param modalities the modalities
     * @return the products by modalities
     */
    List<ProductDTO> getProductsByModalities(Set<ProductModality> modalities);
}
