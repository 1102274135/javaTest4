package bai.javatest4.controller;

import bai.javatest4.ResponseResult;
import bai.javatest4.model.Customer;
import bai.javatest4.service.ICutomerService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class CustomerController {
    @Resource(name = "customerService")
    private ICutomerService cutomerService;
    private static final Logger logger=LoggerFactory.getLogger(CustomerController.class);

    @PostMapping("/{firstName}")
    @ResponseBody
    public ResponseResult<Void> ifLogin(@PathVariable("firstName") String firstName,@RequestParam("lastName") String lastName){
        ResponseResult<Void> responseResult=new ResponseResult<>();
        boolean login=cutomerService.ifLogin(firstName,lastName);

        if(login){
            responseResult.setState(1);
            responseResult.setMessage("登陆成功");
            logger.info("登陆成功");
        }else {
            responseResult.setState(0);
            responseResult.setMessage("登陆失败");
        }
        return responseResult;
    }
    @PutMapping("/customer")
    @ResponseBody
    public int addCustomer(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email, @Param("address1") String address1, @Param("address2") String address2, @Param("address3") String address3){
                String address=address1+" "+address2+" "+address3;
                int flag=cutomerService.addCustomer(firstName,lastName,email,address);
                if(flag>0){
                    logger.info("添加用户成功");
                    return cutomerService.getIdByFirstName(firstName);
                }else {
                    return -1;
                }
    }

    @PostMapping("/customer")
    @ResponseBody
    public Customer updateCustomer(@Param("id") Integer id,@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email, @Param("addressId") int addressId){
           if(id==null){
               return null;
           }
           Customer customer=new Customer();
           customer.setId(id);
           customer.setFirstName(firstName);
           customer.setLastName(lastName);
           customer.setEmail(email);
           customer.setAdderssId(addressId);
           if(cutomerService.updataCustomer(customer)>0){
               Customer customer1= cutomerService.findCustomerById(id);
               logger.info("更改用户"+customer1);
               return customer1;
           }
           return null;
    }

    @Delete("/{id}")
    @ResponseBody
    public int deleteCustomer(@PathVariable int id){
        logger.info("删除用户"+id);
       return cutomerService.deleteCustomer(id);
    }

}
