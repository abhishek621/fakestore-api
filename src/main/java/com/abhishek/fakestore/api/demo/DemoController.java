package com.abhishek.fakestore.api.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {

	private final DemoService demoService;

	@Autowired
	public DemoController(DemoService demoService) {
		this.demoService = demoService;
	}

	@GetMapping("/getForObject")
	public ResponseEntity<DemoObject> getForObject() {
		DemoObject result = demoService.getForObject();
		return ResponseEntity.ok(result);
	}

	@GetMapping("/getForEntity")
	public ResponseEntity<DemoObject> getForEntity() {
		return demoService.getForEntity();
	}

	@GetMapping("/exchange")
	public ResponseEntity<DemoObject> getForExchange(DemoObject demoObject) {
		return demoService.exchange(demoObject);
	}

	@PostMapping("/postForObject")
	public ResponseEntity<DemoObject> postForObject() {
		DemoObject postForObject = demoService.postForObject();
		return ResponseEntity.ok(postForObject);
	}

	@PostMapping("/postForEntity")
	public ResponseEntity<DemoObject> postForEntity() {
		return demoService.postForEntity();
	}

	@PutMapping("/put")
	public ResponseEntity<DemoObject> put() {
		DemoObject result = demoService.put();
		return ResponseEntity.ok(result);
	}

	@PatchMapping("/patchForObject")
	public ResponseEntity<DemoObject> patchForObject() {
		DemoObject patchForObject = demoService.patchForObject();
		return ResponseEntity.ok(patchForObject);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete() {
		demoService.delete();
		return ResponseEntity.ok("delete called");
	}

	@GetMapping("/execute")
	public ResponseEntity<String> execute() {
		demoService.execute();
		return ResponseEntity.ok("execute called");
	}

}
