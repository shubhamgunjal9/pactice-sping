package net.nebula.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import net.nebula.entity.Project;
import net.nebula.repository.ProjectRepository;
@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	public String save(Project project) {
		projectRepository.save(project);
		return "saved";
	}
	public List<Project> getAll() {
		return (List<Project>) projectRepository.findAll();
	}
	public List<Project> pagination(int pageNo , int pageSize) {
	    PageRequest pageRequest = PageRequest.of(pageNo-1, pageSize);
		Page<Project> page = projectRepository.findAll(pageRequest);
		List<Project> list = page.toList();
		return list;
	}	
}
