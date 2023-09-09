package io.github.mrspock182.mockapi.resource.dto;

import io.github.mrspock182.mockapi.entity.MockRequestParam;
import io.github.mrspock182.mockapi.entity.enumerable.Method;

import java.util.List;

public record RegisterMockRequest(
        Method method,
        List<MockRequestParam> requestParam,
        String response
) {
}