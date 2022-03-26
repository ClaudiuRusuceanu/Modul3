package com.application.modul3.curs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.curs.dto.CursCreateDTO;
import com.application.modul3.curs.dto.CursDTO;
import com.application.modul3.curs.mapper.CursMapper;

@RestController
@RequestMapping("/cursuri")
public class CursController {

	@Autowired
	private CursService cursService;

	@Autowired
	private CursMapper cursMapper;

	@PostMapping()
	public CursDTO createCurs(@RequestBody CursCreateDTO cursCreateDTO) {
		Curs curs = cursService.createCurs(cursMapper.cursCreateDTO2Curs(cursCreateDTO));
		return cursMapper.curs2CursDTO(curs);
	}

	@GetMapping("/list")
	public List<CursDTO> getAllCursuri() {
		return cursMapper.cursList2CursListDTO(cursService.getAllCursuri());
	}

	@GetMapping("/{cursId}")
	public CursDTO getCursById(@PathVariable Integer cursId) {
		return cursMapper.curs2CursDTO(cursService.findCursById(cursId));
	}

	@PutMapping("/{cursId}")
	public CursDTO updateCurs(@RequestBody Curs curs, @PathVariable Integer cursId) {
		return cursMapper.curs2CursDTO(cursService.updateCurs(curs, cursId));
	}

	@DeleteMapping("/{cursId}")
	public void deleteCurs(@PathVariable Integer cursId) {
		cursService.deleteCursById(cursId);
	}
}
