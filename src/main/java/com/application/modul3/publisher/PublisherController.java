package com.application.modul3.publisher;

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

import com.application.modul3.publisher.dto.PublisherDTO;
import com.application.modul3.publisher.mapper.PublisherMapper;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
	@Autowired
	private PublisherService publisherService;


	@Autowired
	private PublisherMapper publisherMapper;

	@PostMapping
	public PublisherDTO createPublisher(@RequestBody PublisherDTO publisherDTO) {
		Publisher createdPublisher = publisherService
				.createPublisher(publisherMapper.publisherDTO2Publisher(publisherDTO));
		return publisherMapper.publisher2PublisherDTO(createdPublisher);
	}

	@GetMapping("/list")
	public List<PublisherDTO> getAllPublishers() {
		return publisherMapper.publisherList2PublisherListDTO(publisherService.getAllPublishers());
	}

	@GetMapping("/id")
	public Publisher getPublisherById(Integer id) {
		return publisherService.getPublisherById(id);
	}

	@PutMapping("/{id}")
	public Publisher updatePublisher(@RequestBody Publisher publisher, @PathVariable Integer id) {
		return publisherService.updatePulbisherById(publisher, id);
	}

	@DeleteMapping("/{id}")
	public void deletePublisher(Integer id) {
		publisherService.deletePublisherById(id);
	}

}
