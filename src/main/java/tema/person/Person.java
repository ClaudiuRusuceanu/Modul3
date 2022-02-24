package tema.person;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import tema.curs.Curs;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "person", schema = "administration")
public class Person {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nume")
	private String nume;

	@Column(name = "prenume")
	private String prenume;

	@Column(name = "varsta")
	private Integer varsta;

	@ManyToMany()
	@JoinTable(name = "curs_person", schema = "administration", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "curs_id"))
	List<Curs> cursuri = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public Integer getVarsta() {
		return varsta;
	}

	public void setVarsta(Integer varsta) {
		this.varsta = varsta;
	}

	public void addCurs(Curs curs) {
		this.cursuri.add(curs);
		curs.getPersons().add(this);
	}

}
