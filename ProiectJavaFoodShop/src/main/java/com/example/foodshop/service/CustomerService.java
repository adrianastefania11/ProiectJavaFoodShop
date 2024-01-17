package com.example.foodshop.service;

import com.example.foodshop.domain.Basket;
import com.example.foodshop.domain.Customer;
import com.example.foodshop.dto.CustomerDto;
import com.example.foodshop.exception.CustomerNotFoundException;
import com.example.foodshop.mapper.CustomerMapper;
import com.example.foodshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }


    public boolean deleteCustomer(Long customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if (!exists) {
            throw  new CustomerNotFoundException("shop with Id " + customerId + " does not exist");
        }
        else {
            customerRepository.deleteById(customerId);
            return true;
        }

    }

    public List<Customer> getCustomers(){
        List<Customer> customers = customerRepository.findAll();

        List<Customer> customersToReturn = new ArrayList<>();

        for (Customer value : customers){
            customersToReturn.add(value);
        }

        return customersToReturn;
    }

    @Transactional
    public boolean updateCustomer(Long  customerd, Customer customerUpdate) {
        Customer customer = customerRepository.findById(customerd)
                .orElseThrow(() -> new CustomerNotFoundException(
                        "Customer with id " + customerd + " doesn' t exist "
                ));
        if(customer != null)
        {
            if(customerUpdate.getEmail() != null){
                customer.setEmail(customerUpdate.getEmail());
            }

            if(customerUpdate.getPassword() != null){
                customer.setPassword(customerUpdate.getPassword());
            }

            if(customerUpdate.getFirstName() != null){
                customer.setFirstName(customerUpdate.getFirstName());
            }
            if(customerUpdate.getLastName() != null){
                customer.setLastName(customerUpdate.getLastName());
            }

            return true;
        }
        else {
            return false;
        }

    }

    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.mapToEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.mapToDto(savedCustomer);
    }
}
