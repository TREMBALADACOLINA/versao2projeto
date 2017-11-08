package br.com.ufpb.poo.projeto.model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	
	private String codigo;
	private Professor professor;
	private Disciplina disciplina;
	private List<Aluno> alunos;
	
	public Turma(String codigo, Professor professor, Disciplina disciplina) {
		this.codigo = codigo;
		this.professor = professor;
		this.disciplina = disciplina;
		this.alunos = new ArrayList<Aluno>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void removerAluno(String matricula) {
		for(Aluno a: this.alunos){
			if(a.getMatricula().equals(matricula)){
				this.alunos.remove(a);
				break;
			}
		}
	}

	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	


}

