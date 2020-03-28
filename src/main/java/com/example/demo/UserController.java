package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/user/")
public class UserController {
   @Autowired
    EntityManagerFactory factory;
   private Session getcurrentsession(){
       return  factory.unwrap(SessionFactory.class).openSession();
   }
    @RequestMapping("list")
    public String list(ModelMap map){
        Session session =getcurrentsession();
        String hql = "from User ";
        List<User> list = session.createQuery(hql).list();
        map.addAttribute("list", list);
        return "user/list";
    }
    @RequestMapping(value = "insert" , method = RequestMethod.POST)
    public String insert(ModelMap model, @ModelAttribute("user") User user){
       Session session = getcurrentsession();
       Transaction t = session.beginTransaction();
       try{
           session.save(user);
           t.commit();
           model.addAttribute("message","Them moi thanh cong");

       }catch (Exception e){
            t.rollback();
            model.addAttribute("message","Them moi that bai");
       }
        return "user/sert";
    }
    @RequestMapping(value = "insert" , method = RequestMethod.GET)
    public String insert(ModelMap model){
       model.addAttribute("user", new User());
        return "user/sert";
    }

    @RequestMapping("detail/{id}")
    public String detail (ModelMap modelMap, @PathVariable("id") String id){
        Session session = getcurrentsession();
        User user = (User) session.get(User.class,id);
        modelMap.addAttribute("user",user);
        return "user/detail";
    }
    @RequestMapping("delete{id}")
    public String delete(ModelMap modelMap, @PathVariable("id") String id){
        Session session= getcurrentsession();
        User user = (User) session.get(User.class,id);
        session.delete(user);
        return "user/delete";
    }
}
