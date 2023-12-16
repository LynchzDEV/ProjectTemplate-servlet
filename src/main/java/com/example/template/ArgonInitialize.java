package com.example.template;

import com.example.template.model.Customer;
import com.example.template.repository.CustomerRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class ArgonInitialize {
    public static void main(String[] args) {
        Argon2 arg = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d, 16, 16);
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.getEntityManager().getTransaction().begin();
        char[] password;

        for (Customer c : customerRepository.findAll()) {
            password = c.getCustomerNumber().toString().toCharArray();
            c.setPassword(arg.hash(2, 16, 1, password));
        }

        customerRepository.getEntityManager().getTransaction().commit();
    }


}
