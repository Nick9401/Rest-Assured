package Cydeo.com.POJO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Links {

    @Getter
    @Setter
    @ToString
    public class Link {

        private String rel;
        private String href;
    }
    }
