package br.com.ufpb.poo.projeto.model;

public class Disciplina {

	private String codigo;
	private String nome;
	private String area;

	public Disciplina(String codigo, String nome, String area) {
		this.codigo = codigo;
		this.nome = nome;
		this.area = area;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " Código: " + codigo + " Area: " + area;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Disciplina)) {
			return false;
		}
		Disciplina other = (Disciplina) obj;

		if (codigo == null && other.codigo != null) {
			return false;

		}
		return (nome.equals(other.nome) || codigo.equals(other.codigo));
	}

}
