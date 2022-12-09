package Cydeo.com.POJO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class Region {

    @Getter
    @Setter
    @ToString
    public class region {

        private int region_id;
        private String region_name;
        private List<Links.Link> links;
    }
}
