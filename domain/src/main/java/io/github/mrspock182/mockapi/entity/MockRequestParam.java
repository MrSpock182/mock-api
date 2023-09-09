package io.github.mrspock182.mockapi.entity;

public record MockRequestParam(
        String param,
        Boolean isRequired
) {
}