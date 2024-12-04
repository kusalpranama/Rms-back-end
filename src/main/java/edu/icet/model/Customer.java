package edu.icet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Customer {
    private Integer customerId;
    private String name;
    private String city;
    private String contact;
    private String email;
    private String password;
}
