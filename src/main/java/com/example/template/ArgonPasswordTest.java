package com.example.template;

import com.example.template.model.Customer;
import com.example.template.repository.CustomerRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class ArgonPasswordTest {
    public static void main(String[] args) {
        Argon2 arg = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d, 16, 16);
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = customerRepository.find(333);
        System.out.println(arg.verify(customer.getPassword(), "333".toCharArray()));
    }
}
