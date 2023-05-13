package kz.bitlab.springboot.techboot.controller;

import kz.bitlab.springboot.techboot.db.DBmanager;
import kz.bitlab.springboot.techboot.db.Items;
import kz.bitlab.springboot.techboot.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/s")
    public String indexPage(Model model){
        ArrayList<Items> itemsArrayList = DBmanager.getItems();
        model.addAttribute("tovary",itemsArrayList);
        return "index";
    }
    @PostMapping(value = "/add-item")
    public String addItem(Items item){
        DBmanager.addItem(item);
        return "redirect:/";
    }
    @GetMapping(value = "/addStudent")
    public String addStudenti(Student student){
        return "addStudent";
    }
    @GetMapping(value ="/details/{itemId}")
    public String detailsPage(@PathVariable(name = "itemId") int id, Model model){
        Items item = DBmanager.getItem(id);
        model.addAttribute("tovar",item);
        return "details";
    }
    @GetMapping(value = "/")
    public String sprintTask(Model model){
        ArrayList<Student> studentArrayList=DBmanager.getStudents();
        model.addAttribute("ctudent", studentArrayList);
        return "sprint";
    }
    @PostMapping(value = "/add-student")
    public String addStudent(Student student){
        DBmanager.addStudent(student);
        return "redirect:/";
    }
}
