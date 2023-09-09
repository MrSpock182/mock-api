package io.github.mrspock182.mockapi.repository;

import io.github.mrspock182.mockapi.entity.RegisterMock;
import io.github.mrspock182.mockapi.exception.ApplicationErrorException;
import io.github.mrspock182.mockapi.exception.NotFoundException;
import io.github.mrspock182.mockapi.repository.adapter.RegisterMockRepositoryAdapter;
import io.github.mrspock182.mockapi.repository.client.RegisterMockRepositoryWithMongodb;
import io.github.mrspock182.mockapi.repository.orm.RegisterMockOrm;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RegisterMockRepositoryImpl implements RegisterMockRepository {
    private final RegisterMockRepositoryWithMongodb repository;

    public RegisterMockRepositoryImpl(RegisterMockRepositoryWithMongodb repository) {
        this.repository = repository;
    }

    @Override
    public RegisterMock save(final RegisterMock mock) {
        try {
            RegisterMockOrm orm = repository.save(RegisterMockRepositoryAdapter.cast(mock));
            return RegisterMockRepositoryAdapter.cast(orm);
        } catch (Exception ex) {
            throw new ApplicationErrorException(ex);
        }
    }

    @Override
    public RegisterMock findById(final String id) {
        try {
            Optional<RegisterMockOrm> optional = repository.findById(id);
            if (optional.isEmpty()) {
                throw new NotFoundException("This is not registered");
            }
            return RegisterMockRepositoryAdapter.cast(optional.get());
        } catch (NotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ApplicationErrorException(ex);
        }
    }
}
