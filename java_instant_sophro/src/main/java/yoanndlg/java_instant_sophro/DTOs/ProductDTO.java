package yoanndlg.java_instant_sophro.DTOs;

import yoanndlg.java_instant_sophro.Enum.CategoryType;
import yoanndlg.java_instant_sophro.Enum.ProductModality;

import java.time.Duration;
import java.util.Set;

/**
 * The type Product dto.
 */
public class ProductDTO {
    private String name;
    private String description;
    private Duration duration;
    private Set<CategoryType> categories;
    private Set<ProductModality> modalities;

    /**
     * Instantiates a new Product dto.
     *
     * @param name        the name
     * @param description the description
     * @param durationInMinutes    the duration
     * @param categories  the categories
     * @param modalities  the modalities
     */
    public ProductDTO(String name, String description, Long durationInMinutes, Set<CategoryType> categories, Set<ProductModality> modalities) {
        this.name = name;
        this.description = description;
        this.duration = Duration.ofMinutes(durationInMinutes);
        this.categories = categories;
        this.modalities = modalities;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDurationInMinutes() {
        return duration.toMinutes();
    }

    public void setDurationInMinutes(Long durationInMinutes) {
        this.duration = Duration.ofMinutes(durationInMinutes);
    }

    public Set<CategoryType> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryType> categories) {
        this.categories = categories;
    }

    public Set<ProductModality> getModalities() {
        return modalities;
    }

    public void setModalities(Set<ProductModality> modalities) {
        this.modalities = modalities;
    }
}