package br.com.zup.Squad.Disciplina;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;


    @PostMapping
     public ResponseEntity<DisciplinaResponseDTO> save(@RequestBody @Valid DisciplinaRequestDTO requestDTO){
        Disciplina disciplina = requestDTO.converter();
        return ResponseEntity.ok().body(new DisciplinaResponseDTO(disciplinaRepository.save(disciplina)));
    }

}
