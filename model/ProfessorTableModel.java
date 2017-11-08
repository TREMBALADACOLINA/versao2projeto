package br.com.ufpb.poo.projeto.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProfessorTableModel extends AbstractTableModel {

	/**
	 * Código gerado pelo eclipse
	 */
	private static final long serialVersionUID = -1172506578566273400L;

	private final String[] coluna = new String[] { "MAT", "NOME" };
	private final List<Professor> linhas;

	public ProfessorTableModel(List<Professor> list) {
		this.linhas = list;
	}

	// Implementa a lógica que retorne a quantidade de colunas do modelo
	// Ou seja, retorna a quantidade de COLUNAS
	// No caso, é só ler o tamnho do array de String

	@Override
	public int getColumnCount() {
		return this.coluna.length;
	}

	// Implementa a lógica que retorne a quantidade de linhas do modelo
	// Retorna a quantidade de LINHAS
	// No caso, é só ler o tamamnho da lista de Objetos, no caso, a lista de
	// professores.
	@Override
	public int getRowCount() {
		return this.linhas.size();
	}

	// Retorna o nome da coluna a partir do array de String(colunas).
	@Override
	public String getColumnName(int coluna) {
		return this.coluna[coluna];
	}

	// Preencher os dados
	// Implementação da lógica que irá retornar o valor em determinada célula,
	// dado os argumentos de posição de linha e coluna
	// Ex: Todos da coluna 0, deverá ser preenchido com a matricula

	@Override
	public Object getValueAt(int linha, int coluna) {
		Professor professor = linhas.get(linha);
		switch (coluna) {
		case 0:
			return professor.getMatricula();
		case 1:
			return professor.getNome();
		default:
			throw new IndexOutOfBoundsException("Erro ao preencher a tabelas");
		}

	}

}
