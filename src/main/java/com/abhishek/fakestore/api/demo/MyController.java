package com.abhishek.fakestore.api.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/resource")
    public ResponseEntity<DemoObject> getResource() {
        DemoObject obj = new DemoObject();
        obj.setName("TestName");
        obj.setValue(42);
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/resource")
    public ResponseEntity<DemoObject> createResource(@RequestBody DemoObject demoObject) {
    	demoObject.setName("Created: " + demoObject.getName());
        return ResponseEntity.ok(demoObject);
    }

    @PutMapping("/resource")
    public void updateResource(@RequestBody DemoObject demoObject) {
        // Update logic
    }

    @PatchMapping("/resource")
    public ResponseEntity<DemoObject> patchResource(@RequestBody DemoObject demoObject) {
    	demoObject.setName("Patched: " + demoObject.getName());
        return ResponseEntity.ok(demoObject);
    }

    @DeleteMapping("/resource")
    public void deleteResource() {
        // Delete logic
    }
}
