package org.example.hotel.controller;

import org.example.hotel.entity.Employee;
import org.example.hotel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@PreAuthorize("hasAuthority('MANAGER') or hasAuthority('ADMIN')")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/manager")
    public String viewManagerPage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "th_manager";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "th_new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/manager";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "th_update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id){
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/manager";
    }
}
