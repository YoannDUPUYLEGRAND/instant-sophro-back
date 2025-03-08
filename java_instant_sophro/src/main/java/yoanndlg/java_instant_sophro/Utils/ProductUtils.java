package yoanndlg.java_instant_sophro.Utils;

import yoanndlg.java_instant_sophro.DTOs.ProductDTO;
import yoanndlg.java_instant_sophro.Models.Product;

public class ProductUtils {
    /**
     * Convert to dto product dto.
     *
     * @param entity the entity
     * @return the product dto
     */
    public static ProductDTO convertToDto(Product entity) {
        ProductDTO temp = new ProductDTO(
                entity.getName(),
                entity.getDescription(),
                entity.getDuration(),
                entity.getCategories(),
                entity.getModalities()
        );
        return temp;
    }

    /**
     * Convert to entity product.
     *
     * @param dto the dto
     * @return the product
     */
    public static Product convertToEntity(ProductDTO dto){
        Product temp = new Product(
                dto.getName(),
                dto.getDescription(),
                dto.getDuration(),
                dto.getCategories(),
                dto.getModalities()
        );
        return temp;
    }
}
