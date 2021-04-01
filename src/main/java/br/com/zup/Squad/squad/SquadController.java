package br.com.zup.Squad.squad;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/squad")
public class SquadController {
	
	@Autowired
	private SquadRepository squadRepository;
	
	public SquadController(SquadRepository squadRepository) {
		this.squadRepository = squadRepository;
	}

	@PostMapping
	public ResponseEntity<SquadResponse> SquadController(@RequestBody @Valid SquadRequest squadRequest) {
		Squad squad = squadRequest.converter();
		squadRepository.save(squad);
		
		return  ResponseEntity.ok(new SquadResponse(squad));
	}
	
	
}