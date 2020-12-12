package web4.web4.controller;

import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web4.web4.dao.CustomerRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ajax/todo")
public class AjaxController{
    private CustomerRepository customerRepository;
    @GetMapping("/list")
    String ajax(@RequestParam String content)
    {
        List<Customer> a = customerRepository.findByphone(content);
       //customerReposi
        // tory.
        System.out.println(a);

        if(a.size()==0)
            return "0";
        else
            return "1";
    }
    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }
//    List<TODO> list(HttpSession session, @SessionAttribute(required = false) List<TODO> todos){
//        System.out.println("ll");
//        if (todos == null) {
//            todos = new ArrayList<TODO>();
//            session.setAttribute("todos",todos);
//        }
//        return todos;
//    }
}