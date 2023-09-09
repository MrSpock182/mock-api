package io.github.mrspock182.mockapi.resource;

import io.github.mrspock182.mockapi.entity.enumerable.Method;
import io.github.mrspock182.mockapi.service.MockValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MockResource {
    private final MockValidationService mockValidationService;

    public MockResource(MockValidationService mockValidationService) {
        this.mockValidationService = mockValidationService;
    }

    @GetMapping(
            value = "/mock/{id}/{status}",
            produces = "application/json")
    public ResponseEntity<Object> mockGet(
            @PathVariable(name = "id") final String id,
            @PathVariable(name = "status") final Integer status,
            @RequestParam Map<String, Object> params
    ) {
        return new ResponseEntity<>(
                mockValidationService.validateRequest(id, params, Method.GET), null, status);
    }

    @PostMapping(
            value = "/mock/{id}/{status}",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<Object> mockPost(
            @PathVariable(name = "id") final String id,
            @PathVariable(name = "status") final Integer status,
            @RequestParam Map<String, Object> params,
            @RequestBody Object body
    ) {
        return new ResponseEntity<>(
                mockValidationService.validateRequest(id, params, Method.POST), null, status);
    }

    @PutMapping(
            value = "/mock/{id}/{status}",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<Object> mockPut(
            @PathVariable(name = "id") final String id,
            @PathVariable(name = "status") final Integer status,
            @RequestParam Map<String, Object> params,
            @RequestBody Object body
    ) {
        return new ResponseEntity<>(
                mockValidationService.validateRequest(id, params, Method.PUT), null, status);
    }

    @DeleteMapping(
            value = "/mock/{id}/{status}",
            produces = "application/json",
            consumes = "application/json")
    public Object mockDelete(
            @PathVariable(name = "id") final String id,
            @PathVariable(name = "status") final Integer status,
            @RequestParam Map<String, Object> params,
            @RequestBody Object body
    ) {
        return new ResponseEntity<>(
                mockValidationService.validateRequest(id, params, Method.DELETE), null, status);
    }

}