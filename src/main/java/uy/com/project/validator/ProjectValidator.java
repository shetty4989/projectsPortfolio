package uy.com.project.validator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import uy.com.project.model.Project;
import uy.com.project.model.ProjectType;

@Component
public class ProjectValidator {

	private static boolean isPerfectSquare(int x) {
		int s = (int) Math.sqrt(x);
		return (s * s == x);
	}

	public Map<Boolean,String> validate(Object target) {
		Project project = (Project) target;
		int n = project.getEstimates();
		Map<Boolean,String> message = null;
		if (n < 1 || n > 21){
			message=new HashMap<Boolean,String>();
			message.put(true, "estimates should be between 1 and 21");}
		boolean result = isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
		if (!result){
		message=new HashMap<Boolean,String>();
		message.put(true, "estimates not in fibonacci series");}
		if (!(project.getType().equals(ProjectType.DOCSMANAGE)) && !(project.getType().equals(ProjectType.SECURITIES)))
		{
			message=new HashMap<Boolean,String>(); 
			message.put(true, "Project type not in allowed values");
		}		return message;
	}

}
