package com.example.foodshop.repository;

import com.example.foodshop.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByLastName(String Name);

    Customer save(Customer customer);
}
