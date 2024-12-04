package edu.icet.service.impl;

import edu.icet.entity.ItemEntity;
import edu.icet.entity.RentalEntity;
import edu.icet.model.Item;
import edu.icet.model.Rental;
import edu.icet.repository.RentalRepository;
import edu.icet.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final RentalRepository repository;
    private final ModelMapper mapper;


    @Override
    public void createRental(Rental rental) {
        repository.save(mapper.map(rental, RentalEntity.class));
    }

    @Override
    public List<Rental> getAllRentals() {
        List<Rental> rentalList = new ArrayList<>();

        repository.findAll().forEach(RentalEntity ->{
            rentalList.add(mapper.map(RentalEntity,Rental.class));
        });

        return rentalList;
    }
}
