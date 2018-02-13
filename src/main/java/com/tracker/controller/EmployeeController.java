package com.tracker.controller;

import com.tracker.entity.Employee;
import com.tracker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping({"", "/"})
    public String list(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "list";
    }

    @GetMapping("/{id}")
    public String showDetail(@PathVariable(value = "id") int id, Model model) {
        System.out.println(id);
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "show";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "new";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable(value = "id") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping(value = "")
    public String save(@Valid @ModelAttribute("employee") Employee employee,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";
        employeeService.saveEmployee(employee);
        return "redirect:/employees/";
    }

    @PutMapping(value = "/{id}")
    public String update(@Valid @ModelAttribute("employee") Employee employee,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "edit";
        employeeService.saveEmployee(employee);
        return "redirect:/employees/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees/";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("searchName") String searchName,
                                  Model model) {

        List<Employee> employees = employeeService.searchEmployees(searchName);
        model.addAttribute("employees", employees);

        return "list";
    }
}
