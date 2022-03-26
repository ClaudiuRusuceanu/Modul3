package com.application.modul3.curs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.application.modul3.person.Person;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "curs", schema = "administration")
public class Curs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nume")
	private String nume;

	@ManyToMany( mappedBy = "cursuri", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	List<Person> persons = new ArrayList<>();

	public List<Person> getPersons() {
		return persons;
	}

	public void setStudenti(List<Person> studenti) {
		this.persons = studenti;
	}

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

}
