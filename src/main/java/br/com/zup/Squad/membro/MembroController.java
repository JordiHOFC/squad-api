package br.com.zup.Squad.membro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/membros")
public class MembroController {

    private MembroRepository membroRepository;

    public MembroController(MembroRepository membroRepository) {
        this.membroRepository = membroRepository;
    }

    @PostMapping
    public ResponseEntity<MembroResponseDTO> insertMembro(@RequestBody @Valid MembroRequestDTO requestDTO ){
        Membro membro = requestDTO.converteDTOParaEntidade();
        return ResponseEntity.ok().body(new MembroResponseDTO(membroRepository.save(membro)));
    }




}
