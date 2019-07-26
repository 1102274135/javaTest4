package bai.javatest4.service;

import bai.javatest4.dao.CustomerMapper;
import bai.javatest4.model.Address;
import bai.javatest4.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements ICutomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public boolean ifLogin(String firstName,String lastName) {
        Customer customer=customerMapper.findCustomerByFirstName(firstName);
        if(customer==null){
            return false;
        }
        if(lastName.equals(customer.getLastName())){
            return true;
        }
        return false;
    }

    public int addCustomer(String firstName, String lastName, String email, String address) {
        List<Address> address1=customerMapper.findAddressByAddress(address);
        System.out.println("dd");
        if(address1.size()==0){
            return 0;
        }
        System.out.println("这是ADDRESS"+address1);
        int addid=address1.get(1).getId();
        Customer customer=new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setAdderssId(addid);
        System.out.println(customer);
        return customerMapper.addCustomer(customer);
    }

    @Override
    public int getIdByFirstName(String firstName) {
       Customer customer= customerMapper.findCustomerByFirstName(firstName);
       return customer.getId();
    }

    @Override
    public int updataCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
         return 1;
    }


    public Customer findCustomerById(int id) {
        return customerMapper.findCustomerById(id);
    }
    public int deleteCustomer(int id){
        return customerMapper.deleteCustomer(id);
    }
}
