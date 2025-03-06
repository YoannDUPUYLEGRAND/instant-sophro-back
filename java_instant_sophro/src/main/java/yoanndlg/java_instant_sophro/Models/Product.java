package yoanndlg.java_instant_sophro.Models;



import jakarta.persistence.*;
import yoanndlg.java_instant_sophro.Enum.CategoryType;
import yoanndlg.java_instant_sophro.Enum.ProductModality;

import java.time.Duration;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * The type Product.
 */
@Entity
@Table(name = "products")
public class Product {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_product", nullable = false, updatable = false)
        private Long id;

    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    @Column(name = "description", nullable = false, updatable = false)
    private String description;

    @Column(name = "duration", nullable = false, updatable = false)
    private Duration duration;

    @ElementCollection(targetClass = CategoryType.class)
    @CollectionTable(name = "categories", joinColumns = @JoinColumn(name = "id_product"))
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Set<CategoryType> categories = new HashSet<>();

    @ElementCollection(targetClass = ProductModality.class)
    @CollectionTable(name = "modalities", joinColumns = @JoinColumn(name = "id_product"))
    @Enumerated(EnumType.STRING)
    @Column(name = "modality")
    private Set<ProductModality> modalities = new HashSet<>();

    /**
     * Instantiates a new Product.
     *
     * @param name        the name
     * @param description the description
     * @param duration    the duration
     * @param categories  the categories
     * @param modalities  the modalities
     */
    public Product(String name, String description, Duration duration, Set<CategoryType> categories, Set<ProductModality> modalities) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.categories = categories;
        this.modalities = modalities;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(duration, product.duration) && Objects.equals(categories, product.categories) && Objects.equals(modalities, product.modalities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, duration, categories, modalities);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", categories=" + categories +
                ", modalities=" + modalities +
                '}';
    }
//TODO faire liens Tables
    }
