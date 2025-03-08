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
     * @param duration    the duration
     * @param categories  the categories
     * @param modalities  the modalities
     */
    public ProductDTO(String name, String description, Duration duration, Set<CategoryType> categories, Set<ProductModality> modalities) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.categories = categories;
        this.modalities = modalities;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Sets duration.
     *
     * @param duration the duration
     */
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    /**
     * Gets categories.
     *
     * @return the categories
     */
    public Set<CategoryType> getCategories() {
        return categories;
    }

    /**
     * Sets categories.
     *
     * @param categories the categories
     */
    public void setCategories(Set<CategoryType> categories) {
        this.categories = categories;
    }

    /**
     * Gets modalities.
     *
     * @return the modalities
     */
    public Set<ProductModality> getModalities() {
        return modalities;
    }

    /**
     * Sets modalities.
     *
     * @param modalities the modalities
     */
    public void setModalities(Set<ProductModality> modalities) {
        this.modalities = modalities;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", categories=" + categories +
                ", modalities=" + modalities +
                '}';
    }

}