package edu.icet.controller;

import edu.icet.model.Customer;
import edu.icet.model.Item;
import edu.icet.model.LoginRequest;
import edu.icet.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    private final CustomerService service;

    @PostMapping("/add-customer")
    public void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }

    @PutMapping("/update-customer")
    public void updateCustomer(@RequestBody Customer customer){
        service.updateCustomer(customer);
    }

    @DeleteMapping("/delete-customer/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        service.deleteCustomer(id);
    }

    @GetMapping("/search-by-email/{email}")
    public Customer searchCustomerEmail(@PathVariable String email){
        return service.searchCustomerEmail(email);
    }

    @GetMapping("/search-by-name/{name}")
    public List<Customer> searchCustomerByName(@Valid @PathVariable String name){
        return service.getByName(name);
    }
    @GetMapping("/getAll")
    public List<Customer> viewCustomers(){
        return service.viewCustomers();
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Customer customer = service.searchCustomerEmail(loginRequest.getEmail());

            if (customer != null && customer.getPassword().equals(loginRequest.getPassword())) {
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("customer", customer);
                return ResponseEntity.ok(response);
            }

            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "Invalid credentials"
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "Login failed"
            ));
        }
    }
}
