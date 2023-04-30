package com.example.gtics231lab520203248.Controller;

import com.example.gtics231lab520203248.Dto.PuestoInfoDto;
import com.example.gtics231lab520203248.Repository.EmployeeRepository;
import com.example.gtics231lab520203248.Repository.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/Reportes", method = RequestMethod.GET)
public class ReportesController {
    final JobRepository jobRepository;
    public ReportesController(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }
    @GetMapping(value = {"", "/", "/index"})
    public String reportes(){
        return "reportes";
    }

    @GetMapping("/Salarios")
    public String salarios(Model model){
        List<PuestoInfoDto> puestoInfoDtoList = jobRepository.obtenerPuestoInfo();
        model.addAttribute("puestoInfoList", puestoInfoDtoList);
        return "salarios";
    }

    @GetMapping("/Tentativa")
    public String tentativa(){
        return "tentativa";
    }
}
