package com.kollu.springbootfiledata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kollu.springbootfiledata.model.Project;

public interface TestRepository extends JpaRepository<Project, Long>{

}
