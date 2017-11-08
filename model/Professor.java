package br.com.ufpb.poo.projeto.model;


public class Professor {
	

	private String matricula;
	private String nome;
	
	public Professor(String matricula, String nome) {
		this.matricula = matricula;
		this.nome = nome;
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
	@Override
	public String toString (){
    	return "O nome:"+nome+", Matricula: "+matricula;
    }
}



