package uy.com.project.controller;

import java.io.IOException;


import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uy.com.project.model.Project;
import uy.com.project.model.ProjectDetails;
import uy.com.project.model.ProjectKeyContacts;
import uy.com.project.service.ProjectService;
import uy.com.project.validator.ProjectValidator;

@RestController
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectValidator projectValidator;
	
	//Save project Details
	@RequestMapping(value = "/project", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> saveUpdateCustomer(@RequestBody String input) throws Exception{
		Map<Boolean,String> res=new HashMap<Boolean,String>();
		ObjectMapper mapper=new ObjectMapper();
		Project resultProject=new Project();
		Project inputProject=mapper.readValue(input,Project.class);
		res=projectValidator.validate(inputProject);
		if(res!=null)
		{
			return new ResponseEntity<>(res.get(true), HttpStatus.BAD_REQUEST);
		}
		resultProject=dtoToModel(inputProject);
		
		Project poo= projectService.save(resultProject);
				String result=mapper.writeValueAsString(poo);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//Update project Details
	@RequestMapping(value = "/project/Update", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> UpdateCustomer(@RequestBody String input) throws Exception{	
		Map<Boolean,String> res=new HashMap<Boolean,String>();
		ObjectMapper mapper=new ObjectMapper();
		Project resultProject=new Project();
		Project inputProject=mapper.readValue(input,Project.class);
		res=projectValidator.validate(inputProject);
		if(res!=null)
		{
			return new ResponseEntity<>(res.get(true), HttpStatus.BAD_REQUEST);
		}
		resultProject=dtoToModel(inputProject);
		resultProject.setId(inputProject.getId());
		Project poo= projectService.update(resultProject);
		String result=mapper.writeValueAsString(poo);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//Fetch project details
	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?>  getProject(@PathVariable int id) throws JsonGenerationException, JsonMappingException, IOException{		
		Project project= projectService.findObject(id);
		ObjectMapper o=new ObjectMapper();
		String result=o.writeValueAsString(project);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	//Delete Project
	@RequestMapping(value = "/project/{id}", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteProject(@PathVariable int id) throws JsonGenerationException, JsonMappingException, IOException{				
	projectService.delete(id);
	}
	
	public Project dtoToModel(Project input)
	{
		Project newProject=new Project();
		ProjectDetails details=new ProjectDetails();
		ProjectKeyContacts contacts=new ProjectKeyContacts();
		if(input.getProjectDetails().getDescription()!= null) details.setDescription(input.getProjectDetails().getDescription());
		if(input.getProjectDetails().getName()!=null) details.setName(input.getProjectDetails().getName());
		if(input.getProjectDetails().getSummary()!=null) details.setSummary(input.getProjectDetails().getSummary());
		if(input.getContacts().getEmail()!=null)contacts.setEmail(input.getContacts().getEmail());
		if(input.getContacts().getFname()!=null)contacts.setFname(input.getContacts().getFname());
		if(input.getContacts().getLname()!=null)contacts.setLname(input.getContacts().getLname());
		newProject.setContacts(contacts);
		newProject.setProjectDetails(details);
		newProject.setCritical(input.isCritical());
		if(input.getdRequested()!=null)newProject.setdRequested(input.getdRequested());
	    newProject.setEstimates(input.getEstimates());
		if(input.getdRequired()!=null)newProject.setdRequired(input.getdRequired());
		
		return newProject;
	}

}
