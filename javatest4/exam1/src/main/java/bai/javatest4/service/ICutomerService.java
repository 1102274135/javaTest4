package bai.javatest4.service;

import bai.javatest4.model.Customer;

public interface ICutomerService {
    boolean ifLogin(String firstName,String lastName);
    int addCustomer(String firstName,String lastName,String email,String address);
    int getIdByFirstName(String firstName);
    int updataCustomer(Customer customer);
    Customer findCustomerById(int id);
    int deleteCustomer(int id);
}
