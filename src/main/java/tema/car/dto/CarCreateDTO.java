package tema.car.dto;

import java.time.LocalDate;
import java.util.Set;

public class CarCreateDTO {
	private Integer id;
	private String marca;
	private String model;
	private LocalDate dataFabricatie;
	private Integer caiPutere;
	private Set<Integer> personIds;

	public Set<Integer> getPersonIds() {
		return personIds;
	}

	public void setPersonIds(Set<Integer> personIds) {
		this.personIds = personIds;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public LocalDate getDataFabricatie() {
		return dataFabricatie;
	}

	public void setDataFabricatie(LocalDate dataFabricatie) {
		this.dataFabricatie = dataFabricatie;
	}

	public Integer getCaiPutere() {
		return caiPutere;
	}

	public void setCaiPutere(Integer caiPutere) {
		this.caiPutere = caiPutere;
	}

}
