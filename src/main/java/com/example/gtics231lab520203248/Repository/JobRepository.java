package com.example.gtics231lab520203248.Repository;

import com.example.gtics231lab520203248.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
}
