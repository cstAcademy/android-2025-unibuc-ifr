package com.cst.unibucifr2025.models;

public class Address {
    private String street;
    private int streetNumber;
    private String postCode;
    private String city;
    private String country;

    public Address(String street, int streetNumber, String postCode, String city, String country) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        if (streetNumber != address.streetNumber) return false;
        if (!street.equals(address.street)) return false;
        if (!postCode.equals(address.postCode)) return false;
        if (!city.equals(address.city)) return false;
        return country == address.country;
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();
        result = 31 * result + streetNumber;
        result = 31 * result + postCode.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ",     streetNumber=" + streetNumber +
                ",     postCode='" + postCode + '\'' +
                ",     city='" + city + '\'' +
                ",     country=" + country +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

