package me.dio.academia.digital.controller;

import lombok.AllArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rhacademia/matricula")
@AllArgsConstructor
public class MatriculaController {

  private MatriculaServiceImpl service;

  @PostMapping
  public Matricula create(@RequestBody @Valid MatriculaForm form) {
    return service.create(form);
  }

  @GetMapping("bairro")
  public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
    return service.getAll(bairro);
  }

  @GetMapping("/{id}")
  public List<Matricula> findById(@PathVariable("id") Long id) {
    return Collections.singletonList(service.findById(id));

  }

}
