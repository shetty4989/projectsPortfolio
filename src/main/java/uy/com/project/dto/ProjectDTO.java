package uy.com.project.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import uy.com.project.model.ProjectType;

@Entity
@Table(name="project")
@XmlRootElement(name="project")
public class ProjectDTO implements Serializable
{

   /**
	 * 
	 */
   private static final long serialVersionUID = 134535332323362L;
   private int id;
   private Date dRequested;
   private Date dRequired;
   private int estimates;
   private boolean isCritical;
   private ProjectDetailsDTO projectDetails;
   private ProjectType type;  
   private ProjectKeyContactsDTO contacts;

   public Date getdRequested() {
	return dRequested;
}

public void setdRequested(Date dRequested) {
	this.dRequested = dRequested;
}

public Date getdRequired() {
	return dRequired;
}

public void setdRequired(Date dRequired) {
	this.dRequired = dRequired;
}

public int getEstimates() {
	return estimates;
}

public void setEstimates(int estimates) {
	this.estimates = estimates;
}

public boolean isCritical() {
	return isCritical;
}

public void setCritical(boolean isCritical) {
	this.isCritical = isCritical;
}

public ProjectDetailsDTO getProjectDetails() {
	return projectDetails;
}

public void setProjectDetails(ProjectDetailsDTO projectDetails) {
	this.projectDetails = projectDetails;
}

public ProjectType getType() {
	return type;
}

public void setType(ProjectType type) {
	this.type = type;
}

   public ProjectKeyContactsDTO getContacts() {
	return contacts;
}

public void setContacts(ProjectKeyContactsDTO contacts) {
	this.contacts = contacts;
}

public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }
   
  public ProjectDTO()
   {
	   
   }
}
