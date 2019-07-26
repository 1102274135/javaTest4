package bai.javatest4;

import bai.javatest4.dao.CustomerMapper;
import bai.javatest4.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DockertestApplicationTests {

    @Autowired
    private CustomerMapper customerMapper;
    @Test
    public void contextLoads() {
       Customer customer=new Customer();
       customer.setLastName("sdasa");
       customer.setFirstName("sdfsdfds");
       customer.setEmail("38283823@qq.com");
       customer.setAddressId(1);

       System.out.println(customerMapper.addCustomer(customer));
       System.out.println(customer);
    }


}
