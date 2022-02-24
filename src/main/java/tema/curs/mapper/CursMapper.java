package tema.curs.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tema.curs.Curs;
import tema.curs.dto.CursCreateDTO;
import tema.curs.dto.CursDTO;

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
