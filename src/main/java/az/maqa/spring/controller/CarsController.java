package az.maqa.spring.controller;

import az.maqa.spring.dto.CarsDTO;
import az.maqa.spring.request.RequestAdvancedSearch;
import az.maqa.spring.response.ResponseCars;
import az.maqa.spring.service.CarsService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/cars")
@Log4j2
public class CarsController {

    @Autowired
    private CarsService carsService;


    @GetMapping
    public List<ResponseCars> getAllCars() {
        List<CarsDTO> cars = carsService.findAllCars();

        Type listType = new TypeToken<List<ResponseCars>>() {
        }.getType();

        ModelMapper modelMapper = new ModelMapper();

        List<ResponseCars> response = modelMapper.map(cars, listType);

        return response;
    }


    @GetMapping(value = "/search")
    public List<ResponseCars> advancedSearch(@RequestBody RequestAdvancedSearch advancedSearch) {
        List<CarsDTO> cars = carsService.findAllCarsByAdvancedSearch(advancedSearch);

        Type listType = new TypeToken<List<ResponseCars>>() {
        }.getType();

        ModelMapper modelMapper = new ModelMapper();

        List<ResponseCars> response = modelMapper.map(cars, listType);

        return response;
    }


}
