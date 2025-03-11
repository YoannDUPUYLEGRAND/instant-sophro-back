package yoanndlg.java_instant_sophro.Models;

import jakarta.persistence.*;
import yoanndlg.java_instant_sophro.Enum.CategoryType;
import yoanndlg.java_instant_sophro.Enum.ProductModality;
import yoanndlg.java_instant_sophro.Utils.DurationConverter;

import java.time.Duration;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Product.
 */
@Entity
@Table(name = "tproducts")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Convert(converter = DurationConverter.class)
    @Column(name = "duration", nullable = false)
    private Duration duration;

    @ElementCollection(targetClass = CategoryType.class)
    @CollectionTable(name = "tcategories", joinColumns = @JoinColumn(name = "id_product"))
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Set<CategoryType> categories = new HashSet<>();

    @ElementCollection(targetClass = ProductModality.class)
    @CollectionTable(name = "tmodalities", joinColumns = @JoinColumn(name = "id_product"))
    @Enumerated(EnumType.STRING)
    @Column(name = "modality")
    private Set<ProductModality> modalities = new HashSet<>();

    /**
     * Instantiates a new Product.
     *
     * @param name              the name
     * @param description       the description
     * @param durationInMinutes the duration in minutes
     * @param categories        the categories
     * @param modalities        the modalities
     */
    public Product(String name, String description, long durationInMinutes, Set<CategoryType> categories, Set<ProductModality> modalities) {
        this.name = name;
        this.description = description;
        this.duration = Duration.ofMinutes(durationInMinutes);
        this.categories = categories;
        this.modalities = modalities;
    }

//    Constructeur par défault
    public Product(){

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
     * Gets duration in minutes.
     *
     * @return the duration in minutes
     */
    public long getDurationInMinutes() {
        return duration.toMinutes();
    }

    /**
     * Sets duration in minutes.
     *
     * @param durationInMinutes the duration in minutes
     */
    public void setDurationInMinutes(long durationInMinutes) {
        this.duration = Duration.ofMinutes(durationInMinutes);
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
                ", duration=" + duration.toMinutes() + " minutes" +
                ", categories=" + categories +
                ", modalities=" + modalities +
                '}';
    }
}