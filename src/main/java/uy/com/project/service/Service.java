package uy.com.project.service;

import java.util.List;


public interface Service<T extends Object> {
	
	public T save(T object);
	
	public T update(T object);
	
	public T findObject(int id);
	
	public void delete(int code);
	
	public List<T> listObjects();

}
