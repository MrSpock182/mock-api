package io.github.mrspock182.mockapi.repository.client;

import io.github.mrspock182.mockapi.repository.orm.RegisterMockOrm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterMockRepositoryWithMongodb extends MongoRepository<RegisterMockOrm, String> {
}
