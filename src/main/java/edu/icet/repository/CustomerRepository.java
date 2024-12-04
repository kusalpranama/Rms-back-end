package edu.icet.repository;

import edu.icet.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {
    Optional<CustomerEntity> findByEmail(String email);
    List<CustomerEntity> findByName(String name);
}
