package com.abhishek.fakestore.api.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoService {

	private RestTemplate restTemplate;

	public DemoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	private static final String BASE_URI = "http://localhost:8080/api/resource";

	public void getForObject() {
		// getForObject() Usage: Retrieve a representation by doing a GET on the
		// specified URL, The response (body) is converted and returned as an
		// object

		restTemplate.getForObject(BASE_URI, DemoObject.class);
	}

	public void getForEntity() {
		// getForEntity() Usage : Retrieve a representation by doing a GET on the
		// specified URL, The response (body, headers, and status code) is wrapped
		// in a ResponseEntity

		restTemplate.getForEntity(BASE_URI, DemoObject.class);
	}
	
	public void exchange(DemoObject demoObject) {
		// exchange() Execute a specified HTTP method, such as GET, POST, PUT, DELETE,
		// etc, The response is wrapped in a ResponseEntity
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<DemoObject> requestEntity = new HttpEntity<>(demoObject, headers);
		restTemplate.exchange(BASE_URI, HttpMethod.GET, requestEntity, DemoObject.class);

	}

	public void postForObject() {
		// postForObject() Usage: Create a new resource by posting to the specified
		// URL, The response (body) is converted and returned as an object

		DemoObject postObjectRequest = new DemoObject();
		postObjectRequest.setName("Post Name");
		postObjectRequest.setValue(100);

		restTemplate.postForObject(BASE_URI, postObjectRequest, DemoObject.class);
	}

	public void postForEntity() {
		// postForEntity() Usage: Create a new resource by posting to the specified URL
		// The response (body, headers, and status code) is wrapped in a ResponseEntity

		DemoObject postEntityRequest = new DemoObject();
		postEntityRequest.setName("Post Entity Name");
		postEntityRequest.setValue(100);

		restTemplate.postForEntity(BASE_URI, postEntityRequest, DemoObject.class);
	}

	public DemoObject put() {
		// put() Usage: Update an existing resource by putting the given object to the
		// specified URL

		DemoObject putRequest = new DemoObject();
		putRequest.setName("Put Name");
		putRequest.setValue(200);
		restTemplate.put(BASE_URI, putRequest);
		System.out.println("put: Completed");

		return putRequest;
	}

	public void patchForObject() {
		// patchForObject() : Partially update an existing resource by applying HTTP PATCH
		// to the specified URL

		DemoObject patchRequest = new DemoObject();
		patchRequest.setName("Patch Name");
		patchRequest.setValue(300);
		restTemplate.patchForObject(BASE_URI, patchRequest, DemoObject.class);
	}

	public void delete() {
		// delete() : Delete the resource at the specified URL

		restTemplate.delete(BASE_URI);
	}


	public void execute() {
		// execute() : Execute a generic HTTP method (like GET, POST, PUT, DELETE)
		// with a request and response extractor.

		restTemplate.execute(BASE_URI, HttpMethod.GET, null, response -> {
			return new DemoObject();
		});
	}
}
