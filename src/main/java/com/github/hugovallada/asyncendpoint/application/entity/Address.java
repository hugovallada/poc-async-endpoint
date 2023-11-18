package com.github.hugovallada.asyncendpoint.application.entity;

public class Address {
    public final String cep;
    public final String street;
    public final String city;
    public final String state;

    public Address(String cep, String street, String city, String state) {
        this.cep = cep;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String cep;
        private String street;
        private String city;
        private String state;

        public Builder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Address build() {
            return new Address(cep, street, city, state);
        }
    }
}
