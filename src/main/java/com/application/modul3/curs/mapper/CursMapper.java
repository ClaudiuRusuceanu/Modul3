package com.application.modul3.curs.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.modul3.curs.Curs;
import com.application.modul3.curs.dto.CursCreateDTO;
import com.application.modul3.curs.dto.CursDTO;

@Service
public class CursMapper {

	public Curs cursCreateDTO2Curs(CursCreateDTO cursCreateDTO) {
		Curs curs = new Curs();
		curs.setNume(cursCreateDTO.getNume());
		return curs;
	}

	public CursDTO curs2CursDTO(Curs curs) {
		CursDTO cursDTO = new CursDTO();
		cursDTO.setNume(curs.getNume());
		return cursDTO;
	}

	public List<CursDTO> cursList2CursListDTO(List<Curs> allCursuri) {
		return allCursuri.stream().map(curs -> curs2CursDTO(curs)).collect(Collectors.toList());
	}

}
