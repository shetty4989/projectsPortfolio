package uy.com.project.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.*;
import org.springframework.stereotype.Service;

import uy.com.project.dao.ProjectDao;
import uy.com.project.model.Project;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Service
@Transactional
public class ProjectServiceImp implements ProjectService {
	
	@Inject
	@Autowired
	private ProjectDao projectDao;

	@Override
	public Project save(Project c) {
		return projectDao.save(c);			
	}

	@Override
	public Project update(Project c) {
		return projectDao.update(c);			
	}
	@Override
	public Project findObject(int id) {		
		return projectDao.findObject(id);
	}

	@Override
	public void delete(int id) {
		projectDao.delete(id);		
	}

	@Override
	public List<Project> listObjects() {
		return projectDao.listObjects();
	}

	
	

}
