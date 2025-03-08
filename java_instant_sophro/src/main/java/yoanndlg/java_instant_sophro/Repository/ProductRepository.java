package yoanndlg.java_instant_sophro.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yoanndlg.java_instant_sophro.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //    ! Le fichier sert juste à extend JPA pour le CRUD

}
