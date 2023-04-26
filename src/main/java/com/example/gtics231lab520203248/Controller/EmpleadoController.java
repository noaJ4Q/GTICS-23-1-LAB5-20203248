package com.example.gtics231lab520203248.Controller;

import com.example.gtics231lab520203248.Entity.Department;
import com.example.gtics231lab520203248.Entity.Employee;
import com.example.gtics231lab520203248.Entity.Job;
import com.example.gtics231lab520203248.Repository.DepartmentRepository;
import com.example.gtics231lab520203248.Repository.EmployeeRepository;
import com.example.gtics231lab520203248.Repository.JobRepository;
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
    final JobRepository jobRepository;
    final DepartmentRepository departmentRepository;

    public EmpleadoController(EmployeeRepository employeeRepository, JobRepository jobRepository, DepartmentRepository departmentRepository){
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
        this.departmentRepository = departmentRepository;
    }
    @GetMapping(value = {"", "/", "index"})
    public String empleados(Model model){
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employeeList", employeeList);
        return "empleados";
    }

    @GetMapping("/Nuevo")
    public String nuevo(Model model){
        List<Job> jobList = jobRepository.findAll();
        List<Department> departmentList = departmentRepository.findAll();
        model.addAttribute("jobList", jobList);
        return "nuevoEmpleado";
    }
}
