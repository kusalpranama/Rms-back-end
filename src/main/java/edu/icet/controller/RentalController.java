package edu.icet.controller;
import edu.icet.model.Rental;
import edu.icet.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/rental")
public class RentalController {

    private final RentalService service ;

    @PostMapping("/create")
    public void createRental(@RequestBody Rental rental) {
         service.createRental(rental);
    }

    @GetMapping
    public List<Rental> getAllRentals() {
        return service.getAllRentals();
    }
}
