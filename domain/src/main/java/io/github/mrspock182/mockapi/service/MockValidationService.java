package io.github.mrspock182.mockapi.service;

import io.github.mrspock182.mockapi.entity.MockRequestParam;
import io.github.mrspock182.mockapi.entity.RegisterMock;
import io.github.mrspock182.mockapi.entity.enumerable.Method;
import io.github.mrspock182.mockapi.repository.RegisterMockRepository;

import java.util.List;
import java.util.Map;

public class MockValidationService {
    private final RegisterMockRepository repository;

    public MockValidationService(RegisterMockRepository repository) {
        this.repository = repository;
    }

    public String validateRequest(
            final String id,
            Map<String, Object> params,
            Method method) {
        RegisterMock registerMock = repository.findById(id);
        if (registerMock.method() == method) {
            validateParam(registerMock.requestParam(), params);
            return registerMock.response();
        } else {
            throw new IllegalArgumentException("This mock is " + registerMock.method() + " method");
        }
    }

    private void validateParam(List<MockRequestParam> requestParam, Map<String, Object> params) {
        for (MockRequestParam v : requestParam) {
            if (v.isRequired()) {
                if (!params.containsKey(v.param())) {
                    throw new IllegalArgumentException("Param " + v.param() + " is required");
                }
            }
        }
    }
}