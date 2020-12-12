package web4.web4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import struct.Linkman;
import struct.LoginInfo;
import struct.Table;
import web4.web4.dao.CustomerRepository;

import javax.servlet.http.HttpServletRequest;
//@RestController
@Controller
public class AddController {

    @PostMapping("/add")
    public String jumptoAdd(HttpServletRequest request)
    {

        return "redirect:/add";
    }
    @GetMapping("/add")
    public String showadd(HttpServletRequest request,Model model,Customer customer)
    {
        Object flag = request.getSession().getAttribute("login");
        if(null != flag)
        {
            flag = model.getAttribute("customer");
            if(null == flag)
            {
                //model.addAttribute("linkman",man);
                //Customer customer = new Customer();
                model.addAttribute("customer",customer);
            }
        }
        else
            return "redirect:/login";

        return "add";
    }
    private CustomerRepository customerRepository;
    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }
    @PostMapping("/checkadd")
    public String add(HttpServletRequest request,Model model,Customer customer)
    {

//        Table t = (Table)request.getSession().getAttribute("table");
//        t.getTable().add(man);
        customerRepository.save(customer);
        return "redirect:/login";
    }
}
