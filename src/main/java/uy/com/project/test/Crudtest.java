package uy.com.project.test;

import java.io.IOException;



import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before; 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;


@ContextConfiguration(classes={TestConfiguration.class})
public class Crudtest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//Fetch projectDetails
	@Test
	public  void testFetchProject() throws ClientProtocolException, IOException

	{
	HttpUriRequest request = new HttpGet("http://localhost:8080/orders-backend/project/1");
	HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
	Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
	}
	

	@Test
	public  void saveProject() throws ClientProtocolException, IOException

	{
    String c="{\"dRequested\":\"2018-01-01\",\"dRequired\":\"2018-01-01\",\"estimates\":3,\"projectDetails\":{\"name\":\"asdd\",\"description\":\"sdd\",\"summary\":\"sdsd\"},\"type\":\"DOCSMANAGE\",\"contacts\":{\"fname\":\"sd\",\"lname\":\"sds\",\"phone\":324,\"email\":\"sd\",\"role\":\"sd\",\"team\":\"sd\"},\"critical\":true}";
	HttpPost p= new HttpPost("http://localhost:8080/orders-backend/project/");
	p.setHeader("Content-Type","application/json");
    StringEntity s=new StringEntity(c);
    p.setEntity(s);
	HttpResponse httpResponse = HttpClientBuilder.create().build().execute(p);
	Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
	}
	
	//update estimates
	@Test
	public  void updateProject() throws ClientProtocolException, IOException
	{
	String c="{\"id\":2,\"dRequested\":\"2018-01-01\",\"dRequired\":\"2018-01-01\",\"estimates\":5,\"projectDetails\":{\"id\":1,\"name\":\"asdd\",\"description\":\"sdd\",\"summary\":\"sdsd\"},\"type\":\"DOCSMANAGE\",\"contacts\":{\"id\":1,\"fname\":\"sd\",\"lname\":\"sds\",\"phone\":324,\"email\":\"sd\",\"role\":\"sd\",\"team\":\"sd\"},\"critical\":true}";
	HttpPost p= new HttpPost("http://localhost:8080/orders-backend/project/Update");
	p.setHeader("Content-Type","application/json");
	StringEntity s=new StringEntity(c);
	p.setEntity(s);
	HttpResponse httpResponse = HttpClientBuilder.create().build().execute(p);
	Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
		} 
	
	@Test
	public  void deleteFetchProject() throws ClientProtocolException, IOException

	{
	HttpPost p= new HttpPost("http://localhost:8080/orders-backend/project/1");
	p.setHeader("Content-Type","application/json");
	HttpResponse httpResponse = HttpClientBuilder.create().build().execute(p);
	Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
	}
	
	//save estimates greater than 21
	@Test
	public  void saveProjectInvalid() throws ClientProtocolException, IOException

	{
    String c="{\"dRequested\":\"2018-01-01\",\"dRequired\":\"2018-01-01\",\"estimates\":100,\"projectDetails\":{\"name\":\"asdd\",\"description\":\"sdd\",\"summary\":\"sdsd\"},\"type\":\"DOCSMANAGE\",\"contacts\":{\"fname\":\"sd\",\"lname\":\"sds\",\"phone\":324,\"email\":\"sd\",\"role\":\"sd\",\"team\":\"sd\"},\"critical\":true}";
	HttpPost p= new HttpPost("http://localhost:8080/orders-backend/project/");
	p.setHeader("Content-Type","application/json");
    StringEntity s=new StringEntity(c);
    p.setEntity(s);
	HttpResponse httpResponse = HttpClientBuilder.create().build().execute(p);
	Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_BAD_REQUEST);
	}

	//save estimates greater than not in fibonacci series
	@Test
	public  void saveProjectInvalidEstimates() throws ClientProtocolException, IOException

	{
    String c="{\"dRequested\":\"2018-01-01\",\"dRequired\":\"2018-01-01\",\"estimates\":10,\"projectDetails\":{\"name\":\"asdd\",\"description\":\"sdd\",\"summary\":\"sdsd\"},\"type\":\"DOCSMANAGE\",\"contacts\":{\"fname\":\"sd\",\"lname\":\"sds\",\"phone\":324,\"email\":\"sd\",\"role\":\"sd\",\"team\":\"sd\"},\"critical\":true}";
	HttpPost p= new HttpPost("http://localhost:8080/orders-backend/project/");
	p.setHeader("Content-Type","application/json");
    StringEntity s=new StringEntity(c);
    p.setEntity(s);
	HttpResponse httpResponse = HttpClientBuilder.create().build().execute(p);
	Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_BAD_REQUEST);
	}
	
}
