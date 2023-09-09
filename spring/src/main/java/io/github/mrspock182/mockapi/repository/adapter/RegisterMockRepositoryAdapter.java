package io.github.mrspock182.mockapi.repository.adapter;

import io.github.mrspock182.mockapi.entity.RegisterMock;
import io.github.mrspock182.mockapi.repository.orm.RegisterMockOrm;

public class RegisterMockRepositoryAdapter {

    public static RegisterMock cast(final RegisterMockOrm orm) {
        return new RegisterMock(orm.id(), orm.method(), orm.requestParam(), orm.response());
    }

    public static RegisterMockOrm cast(final RegisterMock dto) {
        return new RegisterMockOrm(dto.id(), dto.method(), dto.requestParam(), dto.response());
    }

}
