package br.com.zup.Squad.disciplina;


import br.com.zup.Squad.planoestudo.PlanoEstudo;
import br.com.zup.Squad.planoestudo.PlanoEstudoRepository;
import br.com.zup.Squad.validation.ExistIdValid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class DisciplinaController {

    private final DisciplinaRepository disciplinaRepository;
    private final PlanoEstudoRepository planoEstudoRepository;


    public DisciplinaController(DisciplinaRepository disciplinaRepository, PlanoEstudoRepository planoEstudoRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.planoEstudoRepository = planoEstudoRepository;
    }

    @GetMapping("/disciplinas")
    public ResponseEntity<List<DisciplinaResponseDTO>> listaDisciplinas() {
        List<Disciplina> todasDisciplinas = disciplinaRepository.findAll();

        return ResponseEntity.ok(
                todasDisciplinas.stream().map(DisciplinaResponseDTO::new).collect(Collectors.toList())
        );
    }

    @GetMapping("/disciplinas/{id}")
    public ResponseEntity<?> detalhaDisciplina(@PathVariable Long id) {

        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);

        if(disciplina.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não existe");
        }

        return ResponseEntity.ok(new DetalharDisciplinaResponseDTO(disciplina.get()));
    }

    @PostMapping("/disciplinas")
     public ResponseEntity<DisciplinaResponseDTO> save(@RequestBody @Valid DisciplinaRequestDTO requestDTO){
        Disciplina disciplina = requestDTO.converter();
        return ResponseEntity.ok().body(new DisciplinaResponseDTO(disciplinaRepository.save(disciplina)));
    }

    @PatchMapping("/{idPlanoDeEstudo}/disciplinas")
    @Transactional
    public ResponseEntity<?> inserirDisciplinaEmPlanoEstudo(@RequestBody  @Valid List<DisciplinaPlanoEstudoRequestDTO> disciplinasRequest, @PathVariable Long idPlanoDeEstudo){
        Optional<PlanoEstudo> planoEstudo=planoEstudoRepository.findById(idPlanoDeEstudo);
        if(planoEstudo.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        List<Disciplina> disciplinas=disciplinasRequest.stream().map(DisciplinaPlanoEstudoRequestDTO::converter).collect(Collectors.toList());
        planoEstudo.get().getDisciplinas().addAll(disciplinas);
        return ResponseEntity.ok("Disciplinas inseridas no plano de estudo: "+planoEstudo.get().getTitulo());
    }

}
