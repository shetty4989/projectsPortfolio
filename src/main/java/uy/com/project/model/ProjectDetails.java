package uy.com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ProjectDetails")
public class ProjectDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="proj_det_id")
	private int id;
	
	@Column(name="proj_name")
	private String name;
	
	@Column(name="proj_desc")
	private String description;
	
	@Column(name="proj_summ")
	private String summary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
}
