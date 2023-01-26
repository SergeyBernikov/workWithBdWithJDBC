package ru.bsa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bsa.service.PersonMethods;
import ru.bsa.models.Person;
import java.sql.*;

@Controller
public class MainControllers {
    @Autowired
    private PersonMethods personMethods;

    @GetMapping("/")
    public String main() {
        return "redirect:/workWithBD";
    }
    @GetMapping("/workWithBD")
    public String workWithBD() {
        return "workWithBD";
    }
    @GetMapping("/showBDPerson")
    public String showBDPersonEndpoint(Model model) throws SQLException {
        model.addAttribute("persons", personMethods.showPersons());
        return "showBDPerson";
    }
    @GetMapping("/addBDPerson")
    public String addBDPerson(@RequestParam(value = "name") String name,
                              @RequestParam(value = "email") String email,
                              Model model) throws SQLException {
        Person person = new Person(name, email);
        personMethods.createPerson(person);
        return "addBDPerson";
    }
    @GetMapping("/deleteBDPerson")
    public String deleteBDPerson(@RequestParam(value = "id") Long id, Model model) throws SQLException {
        personMethods.removePerson(id);
        return "deleteBDPerson";
    }
}
