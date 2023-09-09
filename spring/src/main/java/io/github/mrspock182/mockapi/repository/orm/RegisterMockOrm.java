package io.github.mrspock182.mockapi.repository.orm;

import io.github.mrspock182.mockapi.entity.MockRequestParam;
import io.github.mrspock182.mockapi.entity.enumerable.Method;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collation = "register-mock")
public record RegisterMockOrm(
        @Id
        String id,
        Method method,
        List<MockRequestParam> requestParam,
        String response
) {
}
