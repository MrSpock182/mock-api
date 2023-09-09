package io.github.mrspock182.mockapi.resource;

import io.github.mrspock182.mockapi.entity.MockRequestParam;
import io.github.mrspock182.mockapi.entity.RegisterMock;
import io.github.mrspock182.mockapi.repository.RegisterMockRepository;
import io.github.mrspock182.mockapi.resource.adapter.RegisterMockResourceAdapter;
import io.github.mrspock182.mockapi.resource.dto.RegisterMockRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class RegisterMockResource {
    private final RegisterMockRepository repository;

    public RegisterMockResource(RegisterMockRepository repository) {
        this.repository = repository;
    }

    @PostMapping(
            value = "/register-mock",
            produces = "application/json",
            consumes = "application/json")
    public String registerMock(@RequestBody final RegisterMockRequest request) {
        RegisterMock registerMock = repository.save(RegisterMockResourceAdapter.cast(request));
        return "localhost:8080/mock/"
                + registerMock.id() + "/{status}"
                + getUrlParam(registerMock.requestParam());
    }

    private String getUrlParam(List<MockRequestParam> requestParam) {
        if (!requestParam.isEmpty()) {
            AtomicReference<String> urlParam = new AtomicReference<>("?");
            requestParam.forEach(v -> urlParam.set(urlParam.get() + v.param() + "={value}&"));
            return urlParam.get().substring(0, urlParam.get().length() - 1);
        }
        return null;
    }

}