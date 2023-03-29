package com.academify.resource;

import com.academify.dominio.Aluno;
import com.academify.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/aluno")
public class AlunoResource {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping(value = "/list")
    public List<Aluno> list() {
        return alunoRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
        aluno.setDataHoraCadastro(new Date());
        aluno = alunoRepository.save(aluno);

        return new ResponseEntity(aluno, HttpStatus.OK);
    }

}
