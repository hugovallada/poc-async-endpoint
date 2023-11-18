package com.github.hugovallada.asyncendpoint.application.dto;

import java.util.Objects;

public record Result<T, E extends RuntimeException>(
        T sucesso,
        E error
) {
    public static <T, E extends RuntimeException> Result<T, E> of(T sucesso, E error) {
        return new Result<>(sucesso, error);
    }

    public static <T, E extends RuntimeException> Builder<T, E> builder() {
        return new Builder<>();
    }

    public T getOrThrow() {
        if (!Objects.isNull(error)) {
            throw new IllegalStateException("Dado inválido");
        }
        return sucesso;
    }

    public boolean isSuccess() {
        return Objects.isNull(error);
    }

    public boolean isError() {
        return !Objects.isNull(error);
    }

    public static class Builder<T, E extends RuntimeException> {
        private T sucesso;
        private E error;

        public Builder<T, E> sucesso(T sucesso) {
            this.sucesso = sucesso;
            return this;
        }

        public Builder<T, E> error(E error) {
            this.error = error;
            return this;
        }

        public Result<T, E> build() {
            return new Result<>(this.sucesso, this.error);
        }
    }
}
