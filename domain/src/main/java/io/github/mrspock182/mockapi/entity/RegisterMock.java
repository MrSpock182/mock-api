package io.github.mrspock182.mockapi.entity;

import io.github.mrspock182.mockapi.entity.enumerable.Method;

import java.util.List;

public record RegisterMock(
        String id,
        Method method,
        List<MockRequestParam> requestParam,
        String response
) {

    public RegisterMock {
        if (method == null) {
            throw new IllegalArgumentException("Method is required");
        }
    }
}