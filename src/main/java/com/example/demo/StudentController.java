package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String index(Model model){

//        model.addAttribute("rows", studentService.getAll());

        model.addAttribute("rows", studentService.getAll());
        model.addAttribute("new_student", new Student());


        return "index";
    }

    @PostMapping("/add")
    String add(@ModelAttribute Student new_student){
        studentService.save(new_student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    String delete(@PathVariable("id") int id){
        studentService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") int id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        return "edit"; // Переход на страницу редактирования
    }

    @PostMapping("/update")
    String update(@ModelAttribute Student updatedStudent) {
        studentService.update(updatedStudent);
        return "redirect:/";
    }
}
