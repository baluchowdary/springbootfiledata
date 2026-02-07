package com.kollu.springbootfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kollu.springbootfile.model.Project;

public interface TestRepository extends JpaRepository<Project, Long>{

}
