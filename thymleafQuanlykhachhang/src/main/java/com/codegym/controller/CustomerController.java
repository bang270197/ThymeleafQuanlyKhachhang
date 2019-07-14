package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping("/show-customer")
    public String showCustomer(Model model) {
        model.addAttribute("customer", customerService.findAll());
        return "/customer/list";
    }

    @GetMapping("/show-create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView createCustomer(@ModelAttribute Customer customer) {

        customer.setId((int) (Math.random() * 100));
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
       // modelAndView.addObject("customer",new Customer());
        modelAndView.addObject("addMessage", "Them thanh cong");
        return modelAndView;
    }

    @GetMapping("/view-customer/{id}")
    public ModelAndView viewCustomer(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("/customer/view");
        modelAndView.addObject("customer",customerService.findById(id));
        return modelAndView;
    }

    @GetMapping("/delete-showCustomer/{id}")
    public ModelAndView showdelete(@PathVariable int id){
        Customer customer=customerService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/customer/delete");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }

    @PostMapping("/delete-customer")
    public ModelAndView deleteCustomer(@ModelAttribute Customer customer){
            Customer customer1=customerService.findById(customer.getId());
            if (customer1!=null)
            {
                customerService.remove(customer1.getId());
                ModelAndView modelAndView=new ModelAndView("/customer/delete");
                modelAndView.addObject("deleteMessage","Xoa thanh cong");
                return modelAndView;
            }else {
                ModelAndView modelAndView=new ModelAndView("/customer/error-404");
                return modelAndView;
            }
    }

    @GetMapping("/edit-showCustomer/{id}")
    public ModelAndView showEdit(@PathVariable int id){
        Customer customer=customerService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/customer/edit");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }

    @PostMapping("/edit-customer")
    public ModelAndView editCustomer(@ModelAttribute Customer customer){
        if (customer!=null){
            customerService.edit(customer);
            ModelAndView modelAndView=new ModelAndView("/customer/edit");
            modelAndView.addObject("customer",customer);
            modelAndView.addObject("editMessage","Sua thanh cong");
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("/customer/error-404");
            return modelAndView;
        }
    }

}
