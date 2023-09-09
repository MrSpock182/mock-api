package io.github.mrspock182.mockapi.resource.adapter;

import io.github.mrspock182.mockapi.entity.RegisterMock;
import io.github.mrspock182.mockapi.resource.dto.RegisterMockRequest;

import java.util.UUID;

public class RegisterMockResourceAdapter {
    public static RegisterMock cast(final RegisterMockRequest request) {
        return new RegisterMock(
                UUID.randomUUID().toString(),
                request.method(),
                request.requestParam(),
                request.response());
    }
}