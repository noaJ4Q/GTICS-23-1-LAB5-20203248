package com.example.gtics231lab520203248.Controller;

import com.example.gtics231lab520203248.Entity.Employee;
import com.example.gtics231lab520203248.Repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/Empleados", method = RequestMethod.GET)
public class EmpleadoController {
    final EmployeeRepository employeeRepository;

    public EmpleadoController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @GetMapping(value = {"", "/", "index"})
    public String empleados(Model model){
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employeeList", employeeList);
        return "empleados";
    }
}
