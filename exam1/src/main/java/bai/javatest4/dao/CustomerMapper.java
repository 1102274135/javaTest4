package bai.javatest4.dao;


import bai.javatest4.ResponseResult;
import bai.javatest4.model.Address;
import bai.javatest4.model.Customer;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface CustomerMapper {
       List<Customer>  findCustomerByFirstName(String firstName);
       List<Address> getAddersses();
       int addCustomer(Customer customer);
       List<Address> findAddressByAddress(String address);
       int updateCustomer(Customer customer);
       Customer findCustomerById(int id);
       int deleteCustomer(int id);




}
