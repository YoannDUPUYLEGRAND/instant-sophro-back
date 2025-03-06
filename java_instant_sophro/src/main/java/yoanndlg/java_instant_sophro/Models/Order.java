package yoanndlg.java_instant_sophro.Models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

/**
 * The type Order.
 */
@Entity
@Table(name = "torders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false, updatable = false)
    private Long id;

    @Column(name = "date_order", nullable = false, updatable = false)
    private Date dateOrder;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false)
    private User user;


    /**
     * Instantiates a new Order.
     *
     * @param dateOrder the date order
     * @param user      the user
     */
    public Order(Date dateOrder, User user) {
        this.dateOrder = dateOrder;
        this.user = user;
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
     * Gets date order.
     *
     * @return the date order
     */
    public Date getDateOrder() {
        return dateOrder;
    }

    /**
     * Sets date order.
     *
     * @param dateOrder the date order
     */
    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(dateOrder, order.dateOrder) && Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOrder, user);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateOrder=" + dateOrder +
                ", user=" + user +
                '}';
    }


}
