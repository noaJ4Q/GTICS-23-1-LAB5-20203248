package com.example.gtics231lab520203248.Controller;

import com.example.gtics231lab520203248.Entity.Department;
import com.example.gtics231lab520203248.Entity.Employee;
import com.example.gtics231lab520203248.Entity.Job;
import com.example.gtics231lab520203248.Repository.DepartmentRepository;
import com.example.gtics231lab520203248.Repository.EmployeeRepository;
import com.example.gtics231lab520203248.Repository.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/Buscar")
    public String buscarEmpleado(@RequestParam(name = "busqueda") String busqueda,
                                 Model model){
        List<Employee> employeeList = employeeRepository.buscarPorVarios(busqueda);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("busqueda", busqueda);
        return "empleados";
    }

    @GetMapping("/NuevoEmpleado")
    public String nuevo(Model model){
        List<Job> jobList = jobRepository.findAll();
        List<Department> departmentList = departmentRepository.findAll();
        List<Employee> bossList = employeeRepository.buscarJefes();
        model.addAttribute("jobList", jobList);
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("bossList", bossList);
        return "nuevoEmpleado";
    }

    @PostMapping("/Guardar")
    public String guardar(Employee employee,
                          RedirectAttributes attributes){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        employee.setHire_date(format.format(date));
        employeeRepository.save(employee);
        attributes.addFlashAttribute("msgGuardado", "Empleado creado exitosamente");

        return "redirect:/Empleados";
    }

    @GetMapping("/Borrar")
    public String borrar(@RequestParam(name = "employee_id") int employee_id,
                         RedirectAttributes attributes){
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee_id);
        if (optionalEmployee.isPresent()){

            employeeRepository.deleteById(employee_id);
            attributes.addFlashAttribute("msgBorrado", "Empleado borrado exitosamente");
        }
        return "redirect:/Empleados";
    }
}
