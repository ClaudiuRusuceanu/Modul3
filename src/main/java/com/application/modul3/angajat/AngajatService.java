package com.application.modul3.angajat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AngajatService {
	
	@Autowired
	private AngajatRepository angajatRepository;

	
	public Angajat createAngajat(Angajat angajat) {
		return angajatRepository.saveAndFlush(angajat);
	}
	
	public void deleteAngajat(Integer id) {
		angajatRepository.deleteById(id);
	}
	

}
