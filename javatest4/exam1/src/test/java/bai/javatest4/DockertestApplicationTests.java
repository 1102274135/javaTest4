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


        System.out.println(customerMapper.findCustomerById(2));
    }


}
