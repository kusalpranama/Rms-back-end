package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.entity.CustomerEntity;
import edu.icet.model.Customer;
import edu.icet.model.Item;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

   private final ModelMapper mapper;
    final ObjectMapper objectMapper;

    @Override
    public void addCustomer(Customer customer) {
    repository.save(mapper.map(customer,CustomerEntity.class));
    }

    @Override
    public void updateCustomer(Customer customer) {
        repository.save(mapper.map(customer,CustomerEntity.class));
    }

    @Override
    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Customer searchCustomerEmail(String email) {
        return mapper.map(repository.findByEmail(email),Customer.class);
    }

    @Override
    public List<Customer> viewCustomers() {
        List<Customer> customerList = new ArrayList<>();

        repository.findAll().forEach(CustomerEntity ->{
            customerList.add(mapper.map(CustomerEntity,Customer.class));
        });

        return customerList;

    }

    @Override
    public List<Customer> getByName(String name) {
        List<Customer> customerList = new ArrayList<>();

        repository.findByName(name).forEach(CustomerEntity ->{
            customerList.add(objectMapper.convertValue(CustomerEntity,Customer.class));
        });
        return customerList;
    }
}
