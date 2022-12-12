package Cydeo.com.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

public class Student {
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class student {

        private String firstName;
        private int batch;
        private String major;
        private Contact contact;
        private Company company;
    }
}