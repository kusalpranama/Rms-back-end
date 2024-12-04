package edu.icet.service;

import edu.icet.entity.RentalEntity;
import edu.icet.model.Rental;

import java.util.List;

public interface RentalService {

    void createRental(Rental rental);

    List<Rental> getAllRentals();
}
