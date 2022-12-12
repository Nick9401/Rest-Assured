package Cydeo.com.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

public class Contact {

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class contact {

        private String emailAddress;

    }
    }
