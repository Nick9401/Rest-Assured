package Cydeo.com.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

public class Address {


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class address {

        private String street;
        private int zipCode;
}}
