package uy.com.project.dao;

import java.util.List;

import uy.com.project.model.Project;

public interface Dao<T extends Object> {
	
	public T save(T object);
	
	public T update(T object);
	
	public Project findObject(int code);
	
	public void delete(int code);
	
	public List<T> listObjects();

}
