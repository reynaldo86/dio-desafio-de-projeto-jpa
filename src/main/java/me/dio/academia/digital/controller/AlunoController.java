package me.dio.academia.digital.controller;

import lombok.AllArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rhacademia")
@AllArgsConstructor
public class AlunoController {

  private AlunoServiceImpl service;
  private AlunoRepository alunoRepository;


  @PostMapping("/aluno")
  public ResponseEntity<Aluno> create(@Valid @RequestBody AlunoForm form) {
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(service.create(form));
  }

  @GetMapping("aluno/{id}/avaliacoes")
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
    return service.getAllAvaliacaoFisicaId(id);
  }

  @GetMapping("/aluno/nascimento")
  public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataDeNascimento){
    return service.getAll(dataDeNascimento);
  }

  @GetMapping("alunos")
  public ResponseEntity<List<Aluno>> getAllAlunos(){
    return ResponseEntity.status(HttpStatus.OK).body(service.getAllAlunos());
  }

  @PutMapping("aluno/{id}")
  public ResponseEntity<Object> update(@PathVariable ("id") Long id, @RequestBody @Valid AlunoUpdateForm updateForm){
    Optional<Aluno> alunoOptional = service.findById(id);
    if(!alunoOptional.isPresent()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
    }
    var alunoModel = alunoOptional.get();
    alunoModel.setNome(updateForm.getNome());
    alunoModel.setBairro(updateForm.getBairro());
    alunoModel.setDataDeNascimento(updateForm.getDataDeNascimento());
    return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.save(alunoModel));
  }

}
