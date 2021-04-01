package br.com.zup.Squad.planoestudo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/planoestudos")
public class PlanoEstudoController {

    private final PlanoEstudoRepository planoEstudoRepository;

    public PlanoEstudoController(PlanoEstudoRepository planoEstudoRepository) {
        this.planoEstudoRepository = planoEstudoRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarPlanoDeEstudo(@RequestBody @Valid PlanoEstudoRequestDTO planoEstudoRequestDTO){
        PlanoEstudo planoEstudo= planoEstudoRequestDTO.converter();
        return ResponseEntity.ok(new PlanoEstudoResponseDTO(planoEstudoRepository.save(planoEstudo)));
    }
}
