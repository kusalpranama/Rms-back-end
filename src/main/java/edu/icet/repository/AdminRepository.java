package edu.icet.repository;

import edu.icet.entity.AdminEntity;
import edu.icet.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminEntity,Integer> {
    Optional<AdminEntity> findByEmail(String email);
}
