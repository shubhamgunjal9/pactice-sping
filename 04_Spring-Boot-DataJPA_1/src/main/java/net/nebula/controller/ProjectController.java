package net.nebula.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.nebula.entity.Project;
import net.nebula.repository.ProjectRepository;
import net.nebula.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	@PostMapping("/project")
	public ResponseEntity<String> save(@RequestBody Project project) {
		String save = projectService.save(project);
		return new ResponseEntity<>(save,HttpStatus.OK);
		
	}
	
	@GetMapping("/project")
	public ResponseEntity<List<Project>> getall() {
		return new ResponseEntity<>(projectService.getAll(),HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/project/{id}") 
	public ResponseEntity<Optional<Project>> getybyid(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(projectRepository.findById(id),HttpStatus.OK);
	}
	
	
	@PutMapping("/project")
	public ResponseEntity<String> update(@RequestBody Project project) {
		projectRepository.save(project);
		return new ResponseEntity<>("updated",HttpStatus.OK);
	}
	
	@GetMapping("/project/{date}/getby/{name}")
	public ResponseEntity<List<Project>> getbyname(@PathVariable("name") String name, 
			@PathVariable("date") String date
			) {
		List<Project> list = projectRepository.findByProjectNameAndStartDate(name,date);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PostMapping("/projectlist")
	public ResponseEntity<String> update(@RequestBody List<Project> project) {
		
		for(Project p : project) {
			projectRepository.save(p);
		}
		
		return new ResponseEntity<>("updated",HttpStatus.OK);
	}
	
	
	@GetMapping("/projectpage/{pgno}/{pgs}")
	public ResponseEntity<List<Project>> getPages(
			@PathVariable("pgno") int pageNo, 
			@PathVariable("pgs") int pageSize) {
		List<Project> pagination = projectService.pagination(pageNo, pageSize);
		return new ResponseEntity<>(pagination,HttpStatus.OK);
	}
	
	
	

}
