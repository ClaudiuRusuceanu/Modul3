package tema.car;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	public Car createCar(Car car) {
		return carRepository.saveAndFlush(car);
	}

	public List<Car> findAllCars() {
		return carRepository.findAll();
	}

	public Car findCarById(Integer id) {
		Optional<Car> carOpt = carRepository.findById(id);
		if (carOpt.isPresent()) {
			return carOpt.get();
		}
		return null;

	}

	public void deleteCarById(Integer id) {
		carRepository.deleteById(id);
	}
	
	
}
