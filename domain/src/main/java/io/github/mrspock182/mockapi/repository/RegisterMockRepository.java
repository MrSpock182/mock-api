package io.github.mrspock182.mockapi.repository;

import io.github.mrspock182.mockapi.entity.RegisterMock;

public interface RegisterMockRepository {
    RegisterMock save(RegisterMock mock);

    RegisterMock findById(String id);
}
