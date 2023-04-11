package com.academify.controller;

import com.academify.dominio.Aluno;

// Um aluno não pode ter nome vazio
// O nome do aluno tem que ter pelo menos 3 caracteres
public class AlunoController {

    // Este método vai centralizar todas as validações da classe aluno.
    public boolean isAlunoValido(Aluno aluno) {
        return isNomeValido(aluno) && isMatriculaValida(aluno);
    }

    private boolean isNomeValido(Aluno aluno) {
        if ((aluno.getNome().isEmpty()) || aluno.getNome().length() < 3) {
            return false;
        }

        return true;
    }

    public boolean isMatriculaValida(Aluno aluno) {
        if (aluno.getMatricula().isEmpty()) return false;
        if (aluno.getMatricula().length() < 8) return false;
        if (!aluno.getMatricula().matches("[0-9]+")) return false;

        return true;

    }

}
