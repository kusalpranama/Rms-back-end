package edu.icet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rental {
    private Integer rentalId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private LocalDate dueDate;
    private double totalCost;

}
