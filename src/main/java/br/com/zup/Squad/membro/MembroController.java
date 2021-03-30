package br.com.zup.Squad.membro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/membros")
public class MembroController {

    private MembroRepository membroRepository;

    public MembroController(MembroRepository membroRepository) {
        this.membroRepository = membroRepository;
    }

    @GetMapping
    public ResponseEntity<List<MembroResponseDTO>> listaMembros() {
        List<Membro> membroList = membroRepository.findAll();

        return ResponseEntity.ok(
                membroList.stream().map(MembroResponseDTO::new).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<MembroResponseDTO> insertMembro(@RequestBody @Valid MembroRequestDTO requestDTO ){
        Membro membro = requestDTO.converteDTOParaEntidade();
        return ResponseEntity.ok().body(new MembroResponseDTO(membroRepository.save(membro)));
    }




}
