package az.maqa.spring.repository;

import az.maqa.spring.entity.Cars;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CarsRepository extends CrudRepository<Cars, Long> {

    List<Cars> findAll();

    @Transactional
    @Query(nativeQuery = true , value = "call car_management.advanced_search(:p_car_name,:p_car_brand,:p_min_price,:p_max_price,:p_start_year,:p_end_year)")
    List<Cars> getCarsForAdvancedSearch(@Param("p_car_name") String carName, @Param("p_car_brand") String carBrand, @Param("p_min_price") Double minPrice,
                                    @Param("p_max_price") Double maxPrice, @Param("p_start_year") Integer startYear, @Param("p_end_year") Integer endYear);

    @Transactional
    @Query(nativeQuery = true , value = "call car_management.car_list")
    List<Cars> getAllCars();

}
