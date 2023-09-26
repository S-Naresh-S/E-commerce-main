package com.ecommerce.demo.control;

import com.ecommerce.demo.rep.userdao;
import com.ecommerce.demo.userdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class controller {
    @Autowired
    userdao obj;
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("login.html")
    public String login() {
        return "login";
    }
    @RequestMapping("products.html")
    public String products() {
        return "products";
    }
    @RequestMapping("index.html")
    public String index0() {
        return "index";
    }
    @RequestMapping("about.html")
    public String about() {
        return "about";
    }
    @RequestMapping("newuser.html")
    public String indx() {
        return "newuser";
    }
    @RequestMapping("page2.html")
    public String page() {
        return "page2";
    }

    @RequestMapping("forgotpass.html")
    public String list(){
        return "forgotpass";
    }

    @RequestMapping("newuse")
    public String use(userdata data, Model model){
        Iterable<userdata> dat=obj.findAll();
        for (userdata da: dat) {
            if(data.getEmail().equals(da.getEmail())){
                model.addAttribute("mail","Email already registered");
                return "incorrect";
            }
        }
        if(data.getPassword().equals(data.getCpassword())){
        obj.save(data);
        System.out.println(data.toString());
        model.addAttribute("userid",data.getId());
        return "afterregister";}
        else{
            model.addAttribute("pass","Password does not match");
            return "incorrect";
        }
    }

    @RequestMapping("display")
    public String display(@RequestParam int id, @RequestParam String password, Model model){
        userdata data=obj.findById(id).orElse(new userdata());
        System.out.println(data.getPassword());
        if(password.equals(data.getPassword())){
            model.addAttribute("id",data.getId());
            model.addAttribute("name",data.getName());
            model.addAttribute("email",data.getEmail());
        return "display";
        }
        else {
            model.addAttribute("incorrect","Incorrect Credentials");
        return "incorrect";
        }
    }

    @RequestMapping("delete")
    public String delete(@RequestParam int id,@RequestParam String password, Model model){

        userdata data=obj.findById(id).orElse(new userdata());
        if(password.equals(data.getPassword())){
        obj.deleteById(id);
        model.addAttribute("deleted","Successfully Deleted");
        model.addAttribute("data",data.getName()+", See You Again !!!");
        return "delete";}
        else{
            model.addAttribute("incorrect","Incorrect Credentials");
            return "incorrect";
        }
    }
    @RequestMapping("forgot")
    public  String forgot(@RequestParam String email, @RequestParam String password, Model model){
        Iterable<userdata> data=obj.findAll();
        for ( userdata dat:data) {
            if(dat.getEmail().equals(email) && dat.getPassword().equals(password)){
                model.addAttribute("recovername","Name: "+dat.getName());
                model.addAttribute("recover","ID: "+dat.getId());
                model.addAttribute("share","Don't Share your User ID !!!");
                return "recovered";
            }
        }
        model.addAttribute("incorrect","Incorrect Credentials");
        return "incorrect";
    }

    @RequestMapping("forgotpassword")
    public  String forgot(@RequestParam int id, @RequestParam String email, Model model){
        userdata data=obj.findById(id).orElse(new userdata());

            if(email.equals(data.getEmail())){
                model.addAttribute("recovername","Name: "+data.getName());
                model.addAttribute("recoverpassw","Password: "+data.getPassword());
                return "recovered";
        }else{
        model.addAttribute("incorrect","Incorrect Credentials");
        return "incorrect";}
    }

    @RequestMapping("log")
    public  String log(@RequestParam int id, @RequestParam String password, Model model){
        userdata data=obj.findById(id).orElse(new userdata());

        if(password.equals(data.getPassword())){
            model.addAttribute("name","Hello, "+data.getName()+" !");

            return "afterlogin";
        }else{
            model.addAttribute("incorrect","Incorrect Credentials");
            return "incorrect";}
    }
    @RequestMapping("usersdetail")
    public String userdetails(Model model){
        Iterable<userdata> data=obj.findAll();
        model.addAttribute("lists",data);
        return "usertable";
    }

}
