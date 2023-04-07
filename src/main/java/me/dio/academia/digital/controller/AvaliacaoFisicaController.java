package me.dio.academia.digital.controller;

import lombok.AllArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/rhacademia")
public class AvaliacaoFisicaController {

  private AvaliacaoFisicaServiceImpl service;

  @PostMapping("/avaliacoes")
  public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
    return service.create(form);
  }

  @GetMapping("/avaliacoes")
  public List<AvaliacaoFisica> getAll(){
    return service.getAll();
  }

  @GetMapping("/avaliacoes/{id}")
  public List<AvaliacaoFisica> findById(@PathVariable ("id") Long id){
    return Collections.singletonList(service.findById(id));
  }


}
