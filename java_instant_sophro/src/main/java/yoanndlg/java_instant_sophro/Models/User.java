package yoanndlg.java_instant_sophro.Models;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tusers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false, updatable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();

    public User() {}

    public User(String username, String email, String password,Set<Order> orders) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.orders = orders;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(orders, user.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, surname, email, password, orders);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", orders=" + orders +
                '}';
    }
}