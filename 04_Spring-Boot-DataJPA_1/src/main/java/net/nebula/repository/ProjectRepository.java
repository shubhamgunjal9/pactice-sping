package net.nebula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.nebula.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

	public List<Project> findByProjectNameAndStartDate(String projectName,String startDate);
}
