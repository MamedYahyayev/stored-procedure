package az.maqa.spring.response;

import lombok.Data;

@Data
public class ResponseCars {

    private String carName;

    private String carBrand;

    private Double price;

    private Integer carYear;
}
