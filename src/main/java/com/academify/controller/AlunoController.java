package com.academify.controller;

import com.academify.dominio.Aluno;

// Um aluno não pode ter nome vazio
// O nome do aluno tem que ter pelo menos 3 caracteres
public class AlunoController {

    // Este método vai centralizar todas as validações da classe aluno.
    public boolean isAlunoValido(Aluno aluno) {
        return isNomeValido(aluno);
    }

    private boolean isNomeValido(Aluno aluno) {
        if ((aluno.getNome().isEmpty()) || aluno.getNome().length() < 3) {
            return false;
        }

        return true;
    }

}
