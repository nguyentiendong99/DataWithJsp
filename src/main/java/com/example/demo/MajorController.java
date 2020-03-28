package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
@RequestMapping("/major/")
public class MajorController {
    @Autowired
    EntityManagerFactory factory;
    private Session getcurrentsession(){
        return  factory.unwrap(SessionFactory.class).openSession();
    }
    @ModelAttribute("listmajor")
    public List<Major> list(){
        Session session = getcurrentsession();
        String hql = " FROM Major";
        List<Major> list = session.createQuery(hql).list();
        return list;
    }
    @RequestMapping("index")
    public String index(ModelMap model){
        model.addAttribute("major" , new Major());
        list();
        return "major/index";
    }
    @RequestMapping(value = "index", params = "btnInsert")
    public String insert(ModelMap model , @ModelAttribute("major") Major major){
        Session session = getcurrentsession();
        Transaction t = session.beginTransaction();
        try {
            session.save(major);
            t.commit();
            model.addAttribute("message", "Them Major Thanh Cong");
        }catch (Exception e){
            t.rollback();
            model.addAttribute("message","Them major That Bai");
        }
        return "major/index";
    }
    @RequestMapping(value = "index/delete/{id}", method = RequestMethod.GET)
    public String Delete(ModelMap map, @PathVariable("id") int id)
    {
        Session session = getcurrentsession();
        Major major = (Major)session.get(Major.class,id);
        Transaction t = session.beginTransaction();
        try {
            session.delete(major);
            t.commit();
            map.addAttribute("message","Xoa Thanh Cong");
            session.close();
        }catch (Exception e){
            t.rollback();
            map.addAttribute("message","Xoa that bai");
        }
        finally {
            session.close();
        }
        return "redirect:/major/index";
    }
    @RequestMapping(value = "index/edit/{id}", method = RequestMethod.GET)
    public String Edit(ModelMap map, @PathVariable("id") int id)
    {
        Session session = getcurrentsession();
        Major major = (Major) session.get(Major.class,id);
        map.addAttribute("major",major);
        return "major/index";
    }
    @RequestMapping(value = "index/edit/{id}", params = "btnUpdate", method = RequestMethod.POST)
    public String Update(ModelMap model , @ModelAttribute("major") Major major){
        Session session = getcurrentsession();
        Transaction t = session.beginTransaction();
        try {
            session.update(major);
            t.commit();
            model.addAttribute("message", "Update Major Thanh Cong");
            session.clear();
            session.close();
        }catch (Exception e){
            t.rollback();
            model.addAttribute("message","Update major That Bai");
        }
        return "redirect:/major/index";
    }
}
