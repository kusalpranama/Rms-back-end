package edu.icet.repository;

import edu.icet.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<RentalEntity,Integer> {
}
