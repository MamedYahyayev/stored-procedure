package az.maqa.spring.service;

import az.maqa.spring.dto.CarsDTO;
import az.maqa.spring.request.RequestAdvancedSearch;

import java.util.List;

public interface CarsService {

    List<CarsDTO> findAllCars();

    List<CarsDTO> findAllCarsByAdvancedSearch(RequestAdvancedSearch advancedSearch);

}

