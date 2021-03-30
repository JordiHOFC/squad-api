package br.com.zup.Squad.Disciplina;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    private DisciplinaRepository disciplinaRepository;

    public DisciplinaController(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaResponseDTO>> listaDisciplinas() {
        List<Disciplina> todasDisciplinas = disciplinaRepository.findAll();

        return ResponseEntity.ok(
                todasDisciplinas.stream().map(DisciplinaResponseDTO::new).collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhaDisciplina(@PathVariable Long id) {

        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);

        if(disciplina.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não existe");
        }

        return ResponseEntity.ok(new DetalhaDisciplinaResponseDTO(disciplina.get()));
    }

    @PostMapping
     public ResponseEntity<DisciplinaResponseDTO> save(@RequestBody @Valid DisciplinaRequestDTO requestDTO){
        Disciplina disciplina = requestDTO.converter();
        return ResponseEntity.ok().body(new DisciplinaResponseDTO(disciplinaRepository.save(disciplina)));
    }

}
