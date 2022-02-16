package tema.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tema.car.dto.CarCreateDTO;
import tema.car.dto.CarDTO;
import tema.car.mapper.CarMapper;

@RestController
@RequestMapping("/Car")
public class CarController {

	@Autowired
	private CarService carService;
	@Autowired
	private CarMapper carMapper;

	@PostMapping
	public CarDTO createCar(@RequestBody CarDTO carDTO) {
		Car createdCar = carService.createCar(carMapper.carDTO2car(carDTO));
		return carMapper.car2carDTO(createdCar);
	}

	@PostMapping("/cars")
	public CarDTO createCarDTO(@RequestBody CarCreateDTO carCreateDTO) {
		Car createCar = carService.createCar(carMapper.carCreateDTO2Car(carCreateDTO));
		return carMapper.car2carDTO(createCar);
	}

	@GetMapping("/list")
	public List<CarDTO> getAllCars() {
		return carMapper.carList2CarListDTO(carService.findAllCars());
	}

}
