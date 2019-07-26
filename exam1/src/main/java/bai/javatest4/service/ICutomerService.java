package bai.javatest4.service;

import bai.javatest4.exception.CustomerNotFoundException;
import bai.javatest4.model.Customer;

public interface ICutomerService {
    boolean ifLogin(String firstName,String lastName);
    int addCustomer(String firstName,String lastName,String email,String address) throws CustomerNotFoundException;
    int updataCustomer(Customer customer) throws CustomerNotFoundException;
    Customer findCustomerById(int id) throws CustomerNotFoundException;
    int deleteCustomer(int id) throws CustomerNotFoundException;

}
