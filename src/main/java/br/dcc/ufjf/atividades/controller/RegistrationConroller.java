package br.dcc.ufjf.atividades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.dcc.ufjf.atividades.controller_service.RegistrationService;
import br.dcc.ufjf.atividades.controller_service.StudentService;
import br.dcc.ufjf.atividades.controller_service.SubjectService;
import br.dcc.ufjf.atividades.model.Registration;
import br.dcc.ufjf.atividades.model.Student;
import br.dcc.ufjf.atividades.model.Subject;

@Controller
public class RegistrationConroller {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    @RequestMapping(value="/saveRegistration", method = RequestMethod.POST)
    public String saveRegistration(@ModelAttribute("registration")Registration registration){
        registrationService.saveRegistration(registration);
        return "redirect:/";
    }

    @RequestMapping("/registration")
    public String viewRegistrationPage(Model model){

        List<Registration> listRegistration = registrationService.getRegistration();
        model.addAttribute("listRegistration", listRegistration); 

        List<Student> listStudent = studentService.getStudents();
        model.addAttribute("listStudent", listStudent);

        List<Subject> listSubjects = subjectService.getSubjects();
        model.addAttribute("listSubjects", listSubjects);

        return "registration";
    }
   
}