package uy.com.project.model;

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

@Entity
@Table(name="project")
@XmlRootElement(name="project")
public class Project {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name="project_id")
   private int id;
   
   
   @Column(name="requested_date")
   private Date dRequested;
   
   @Column(name="required_date")
   private Date dRequired;
   
   @Column(name="estimates")
   private int estimates;
   
   @Column(name="isCritical")
   private boolean isCritical;
   
   @OneToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="proj_det_id")
   private ProjectDetails projectDetails;
   
   @Enumerated(EnumType.STRING)
   @Column(name="type")
   private ProjectType type;
   
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="key_cont_id")
   private ProjectKeyContacts contacts;

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

public ProjectDetails getProjectDetails() {
	return projectDetails;
}

public void setProjectDetails(ProjectDetails projectDetails) {
	this.projectDetails = projectDetails;
}

public ProjectType getType() {
	return type;
}

public void setType(ProjectType type) {
	this.type = type;
}

   public ProjectKeyContacts getContacts() {
	return contacts;
}

public void setContacts(ProjectKeyContacts contacts) {
	this.contacts = contacts;
}

public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }
}
