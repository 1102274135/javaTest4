package bai.javatest4.controller;

import bai.javatest4.ResponseResult;
import bai.javatest4.exception.CustomerNotFoundException;
import bai.javatest4.model.Customer;
import bai.javatest4.model.Page;
import bai.javatest4.service.ICutomerService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.PUBLIC_MEMBER;
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

    //获取分页
    @GetMapping("/")
    @ResponseBody
    public void list(Page page){
        logger.info("分页:"+page);
    }

    //登陆请求
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

    //添加用户
    @PutMapping("/customer")
    @ResponseBody
    public int addCustomer(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("address1") String address1, @RequestParam("address2") String address2, @RequestParam("address3") String address3){
                logger.info("开始添加用户");
               Customer customer=new Customer();
               customer.setFirstName(firstName);
               customer.setLastName(lastName);
               customer.setEmail(email);
               String address=address1+" "+address2+" "+address3;

              try {
                  int id=cutomerService.addCustomer(firstName,lastName,email,address);
                  logger.info("添加用户成功");
                  return id;
              } catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                    return -1;
             }


    }

    //更改用户
    @PostMapping("/customer")
    @ResponseBody
    public Customer updateCustomer(@RequestParam("id") Integer id,@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam ("addressId") Integer addressId){
           if(id==null){
               return null;
           }
           Customer customer=new Customer();
           customer.setId(id);
           customer.setFirstName(firstName);
           customer.setLastName(lastName);
           customer.setEmail(email);
           customer.setAddressId(addressId);
           try {
               cutomerService.updataCustomer(customer);
               Customer customer1 = cutomerService.findCustomerById(id);
               logger.info("更改用户" + customer1);
               return customer1;
           }catch (CustomerNotFoundException e){
               e.printStackTrace();
               return null;
           }


    }

    //删除用户
    @DeleteMapping("/{id}")
    @ResponseBody
    public int deleteCustomer(@PathVariable int id){
        logger.info("删除用户"+id);
        logger.info("----------");
        try {
            return cutomerService.deleteCustomer(id);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

}
