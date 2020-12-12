package web4.web4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import struct.Linkman;
import struct.LoginInfo;
import struct.Table;
import web4.web4.dao.CustomerRepository;

import javax.security.sasl.SaslException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ChangeController {
    private CustomerRepository customerRepository;
    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }
//    @GetMapping({ "/checkadd","/change", "/checkchange", "/del"})
//    public String goBack(HttpServletRequest request) {
//        Object flag = request.getSession().getAttribute("login");
//        if (null != flag) {
//            HttpSession session = request.getSession();
//            if(null == session.getAttribute("table")){
//                Table table = new Table();
//                session.setAttribute("table",table);
//            }
//            return "change";
//        }
//        else
//            return "redirect:/login";
//    }


    @GetMapping("/change")
    public String change(HttpServletRequest request,Model model,Customer customer)
    {

        model.addAttribute("customer",customer);
        return "change";
    }
    @PostMapping("/change")
    public String showChange(@ModelAttribute(value="row")Long row, HttpServletRequest request, Model model){
//        //修改会将当前列表行传过去
//        Table t = (Table)request.getSession().getAttribute("table");
//        //利用这一行列表实例化一个联系人对象
//        Linkman linkman = t.getTable().elementAt(row);
//        //将联系人对象传给change.html以便修改
//        model.addAttribute("linkman",linkman);
//        t.getTable().remove(linkman);
        System.out.println("hh");
        customerRepository.deleteById(row);
        return "redirect:/change";
    }
    @PostMapping("/checkchange")
    public String checkChange(Customer customer, HttpServletRequest request)
    {
//        Table t = (Table)request.getSession().getAttribute("table");
//        t.getTable().add(linkman)
//      ;
        customerRepository.save(customer);
        return "redirect:/list";
    }


}