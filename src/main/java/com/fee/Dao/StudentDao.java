package com.fee.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fee.Entity.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

}
