package com.example.gtics231lab520203248.Repository;

import com.example.gtics231lab520203248.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(nativeQuery = true, value = "select e.* from employees e " +
            "inner join jobs j on (e.job_id = j.job_id) " +
            "inner join departments d on (e.department_id = d.department_id) " +
            "inner join locations l on (d.location_id = l.location_id) " +
            "where e.first_name = ?1 or e.last_name = ?1 or j.job_title = ?1 or l.city = ?1")
    List<Employee> buscarPorVarios (String busqueda);
    @Query(nativeQuery = true, value = "select distinct m.* from employees e \n" +
            "inner join employees m on (e.manager_id = m.employee_id)")
    List<Employee> buscarJefes ();
}
