package com.example.gtics231lab520203248.Repository;

import com.example.gtics231lab520203248.Dto.PuestoInfoDto;
import com.example.gtics231lab520203248.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
    @Query(nativeQuery = true, value = "select j.job_title as jobtitle, j.max_salary as maxsalary, j.min_salary as minsalary, sum(e.salary) as totalsalary, round(avg(e.salary), 2) as averagesalary from jobs j \n" +
            "inner join employees e on (e.job_id = j.job_id)\n" +
            "group by e.job_id")
    List<PuestoInfoDto> obtenerPuestoInfo();

}
