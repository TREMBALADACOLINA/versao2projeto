package br.com.ufpb.poo.projeto.model;

public class Aluno {

	private String matricula;
	private String nome;
	private String email;

	public Aluno(String matricula, String nome, String email) {
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
	}

	
	public Aluno() {
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "O nome:" + nome + ", Matricula: " + matricula + " e seu e-mail é: " + email;
	}

	
}
