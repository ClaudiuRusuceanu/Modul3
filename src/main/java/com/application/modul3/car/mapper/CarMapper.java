package com.application.modul3.car.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.modul3.car.Car;
import com.application.modul3.car.dto.CarCreateDTO;
import com.application.modul3.car.dto.CarDTO;

@Service
public class CarMapper {

	public CarDTO car2carDTO(Car car) {
		CarDTO carDTO = new CarDTO();
		carDTO.setId(car.getId());
		carDTO.setCaiPutere(car.getCaiPutere());
		carDTO.setDataFabricatie(car.getDataFabricate());
		carDTO.setMarca(car.getMarca());
		carDTO.setModel(car.getModel());
		return carDTO;

	}

	public Car carDTO2car(CarDTO carDTO) {
		Car car = new Car();
		car.setId(carDTO.getId());
		car.setCaiPutere(carDTO.getCaiPutere());
		car.setDataFabricate(carDTO.getDataFabricatie());
		car.setMarca(carDTO.getMarca());
		car.setModel(carDTO.getModel());
		return car;
	}
	
	public Car carCreateDTO2Car(CarCreateDTO carDTO) {
		Car car = new Car();
		car.setCaiPutere(carDTO.getCaiPutere());
		car.setDataFabricate(carDTO.getDataFabricatie());
		car.setId(carDTO.getId());
		car.setMarca(carDTO.getMarca());
		car.setModel(carDTO.getModel());
		return car;
	}

	public List<CarDTO> carList2CarListDTO(List<Car> cars) {
		return cars.stream().map(car -> car2carDTO(car)).collect(Collectors.toList());
	}
}
