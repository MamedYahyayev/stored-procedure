package az.maqa.spring.request;

import lombok.Data;

@Data
public class RequestAdvancedSearch {

    private String carName;

    private String carBrand;

    private Double minPrice;

    private Double maxPrice;

    private int startYear;

    private int endYear;

}
