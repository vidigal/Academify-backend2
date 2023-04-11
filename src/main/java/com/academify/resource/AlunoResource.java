package com.academify.resource;

import com.academify.controller.AlunoController;
import com.academify.dominio.Aluno;
import com.academify.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        AlunoController alunoController = new AlunoController();
        if (!alunoController.isAlunoValido(aluno)) {
            return new ResponseEntity("Dados do aluno inválido", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        aluno.setDataHoraCadastro(new Date());
        aluno = alunoRepository.save(aluno);
        return new ResponseEntity(aluno, HttpStatus.OK);

    }

    @GetMapping("getById/{id}")
    public Optional<Aluno> getById(@PathVariable(value = "id") int id) {
        return alunoRepository.findById(id);
    }

    @PutMapping("/edit")
    public ResponseEntity<Aluno> editar(@RequestBody Aluno aluno) {
        AlunoController alunoController = new AlunoController();
        if (!alunoController.isAlunoValido(aluno)) {
            return new ResponseEntity("Nome do aluno é inválido", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        aluno = alunoRepository.save(aluno);
        return new ResponseEntity(aluno, HttpStatus.OK);
    }

    @GetMapping("/total")
    public long getTotal() {
        return alunoRepository.count();
    }

    @DeleteMapping("/remove/{id}")
    public Aluno remove(@PathVariable(value = "id") int id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        alunoRepository.delete(optionalAluno.get());
        return optionalAluno.get();
    }



}
