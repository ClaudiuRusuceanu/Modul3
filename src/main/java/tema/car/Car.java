package tema.car;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import tema.person.Person;

@Entity
@Table(name = "car", schema = "administration")
public class Car {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "marca")
	private String marca;

	@Column(name = "model")
	private String model;

	@Column(name = "data_fabricatie")
	private LocalDate dataFabricate;

	@Column(name = "cai_putere")
	private Integer caiPutere;
	
	@OneToMany(mappedBy = "car", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, orphanRemoval = true)
	private Set<Person> persons;
	
	

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

	public LocalDate getDataFabricate() {
		return dataFabricate;
	}

	public void setDataFabricate(LocalDate dataFabricate) {
		this.dataFabricate = dataFabricate;
	}

	public Integer getCaiPutere() {
		return caiPutere;
	}

	public void setCaiPutere(Integer caiPutere) {
		this.caiPutere = caiPutere;
	}

	
	
}
