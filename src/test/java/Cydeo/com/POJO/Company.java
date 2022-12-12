package Cydeo.com.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

public class Company {
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class company {

        private String companyName;
        private Address address;
    }
}