package az.maqa.spring.service.impl;

import az.maqa.spring.dto.CarsDTO;
import az.maqa.spring.entity.Cars;
import az.maqa.spring.repository.CarsRepository;
import az.maqa.spring.request.RequestAdvancedSearch;
import az.maqa.spring.service.CarsService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@Log4j2
public class CarsServiceImpl implements CarsService {

    private final CarsRepository carsRepository;

    @Autowired
    public CarsServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<CarsDTO> findAllCars() {
        List<Cars> cars = carsRepository.getAllCars();

        Type listType = new TypeToken<List<CarsDTO>>() {
        }.getType();

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(cars, listType);
    }

    @Override
    public List<CarsDTO> findAllCarsByAdvancedSearch(RequestAdvancedSearch car) {
        List<Cars> cars = advancedSearchCarsList(car);

        Type listType = new TypeToken<List<CarsDTO>>() {
        }.getType();

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(cars, listType);
    }

    private List<Cars> advancedSearchCarsList(RequestAdvancedSearch car) {
        return carsRepository.getCarsForAdvancedSearch(car.getCarName(), car.getCarBrand(),
                car.getMinPrice(), car.getMaxPrice(),
                car.getStartYear(), car.getEndYear());
    }
}
