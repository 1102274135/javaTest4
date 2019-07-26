package bai.javatest4.service;

import bai.javatest4.dao.CustomerMapper;
import bai.javatest4.exception.CustomerNotFoundException;
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
        List<Customer> customer=customerMapper.findCustomerByFirstName(firstName);
        if(customer==null){
            return false;
        }
        for(Customer c : customer){
            if(lastName.equals(c.getLastName())){
                return true;
            }
        }
        return false;
    }

    public int addCustomer(String firstName, String lastName, String email, String address)throws CustomerNotFoundException {
        List<Address> address1=customerMapper.findAddressByAddress(address);
        if(address1.size()==0){
            return 0;
        }
        int addid=address1.get(1).getId();
        Customer customer=new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setAddressId(addid);

        int i=customerMapper.addCustomer(customer);
        if(i<1){
            throw new CustomerNotFoundException("添加失败");
        }
        return customer.getId();
    }
    @Override
    public int updataCustomer(Customer customer) throws CustomerNotFoundException{
        int i=customerMapper.updateCustomer(customer);
        if(i<1){
            throw new CustomerNotFoundException("更新失败");
        }
        return i;


    }


    public Customer findCustomerById(int id) throws CustomerNotFoundException{
        Customer customer= customerMapper.findCustomerById(id);
        if(customer==null){
            throw new CustomerNotFoundException("用户未找到");
        }
        return customer;
    }
    public int deleteCustomer(int id) throws CustomerNotFoundException{
        int i=customerMapper.deleteCustomer(id);
        if(i<1){
            throw new CustomerNotFoundException("删除失败");
        }
        return i;
    }


}
