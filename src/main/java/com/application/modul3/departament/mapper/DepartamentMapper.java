package com.application.modul3.departament.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.modul3.departament.Departament;
import com.application.modul3.departament.dto.DepartamentCreateDTO;
import com.application.modul3.departament.dto.DepartamentDTO;

@Component
public class DepartamentMapper {
	
	public DepartamentDTO departament2DepartamentDTO(Departament departament) {
		DepartamentDTO departamentDTO = new DepartamentDTO();
		departamentDTO.setId(departament.getId());
		departamentDTO.setNume(departament.getNume());
		return departamentDTO;
		
		
	}
	
	public Departament departamentDTO2Departament(DepartamentDTO departamentDTO) {
		Departament departament = new Departament();
		departament.setId(departamentDTO.getId());
		departament.setNume(departamentDTO.getNume());
		return departament;
		
	}
	
	public Departament departamentCreateDTO2Departament(DepartamentCreateDTO departamentDTO) {
		Departament departament = new Departament();
		departament.setNume(departamentDTO.getNume());
		return departament;
	}
	
	public List<DepartamentDTO> departamentList2DepartamentListDTO(List<Departament> departaments){
		return departaments.stream().map(departament -> departament2DepartamentDTO(departament)).collect(Collectors.toList());
	}

}
