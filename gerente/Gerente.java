package br.com.ufpb.poo.projeto.gerente;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.poo.projeto.model.Aluno;
import br.com.ufpb.poo.projeto.model.Disciplina;
import br.com.ufpb.poo.projeto.model.Professor;
import br.com.ufpb.poo.projeto.model.Turma;

public class Gerente {

	private static List<Aluno> alunos = new ArrayList<>();
	private static List<Professor> professores = new ArrayList<>();
	private static List<Disciplina> disciplinas = new ArrayList<>();
	private static List<Turma> turmas = new ArrayList<>();

	public Gerente() {

	}

	public static List<Aluno> getAlunos() {
		return alunos;
	}

	public static void setAlunos(List<Aluno> alunos) {
		Gerente.alunos = alunos;
	}

	public static List<Professor> getProfessores() {
		return professores;
	}

	public static void setProfessores(List<Professor> professores) {
		Gerente.professores = professores;
	}

	public static List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public static void setDisciplinas(List<Disciplina> disciplinas) {
		Gerente.disciplinas = disciplinas;
	}

	public static List<Turma> getTurmas() {
		return turmas;
	}

	public static void setTurmas(List<Turma> turmas) {
		Gerente.turmas = turmas;
	}

	// =================CADASTRO===================
	// Cadastra um aluno
	// Adiciona uma aluno na arrayList de alunos
	public void cadastrarAluno(Aluno a) {
		Gerente.alunos.add(a);

	}

	// Cadastra um professor
	// Adiciona uma professor na arrayList de professores
	public void cadastrarProfessor(Professor p) {
		Gerente.professores.add(p);
	}

	// Cadastra uma disciplina
	// Adiciona uma disciplina na arrayList de disciplinas
	public void cadastrarDisciplina(Disciplina d) {
		Gerente.disciplinas.add(d);
	}

	// Cadastra uma turma
	// Adiciona uma turma na arrayList de turmas
	public void cadastrarTurma(Turma t) {
		Gerente.turmas.add(t);
	}

	// ===============FIM CADASTRO=================

	// ===============VERIFICAÇÕES/BUSCAS=================

	// Verifica se a matricula do aluno existe
	// Como pode ter um aluno com nomes iguais, o controle é será feito por
	// matricula. Se existir retorna true, caso contrario, false.
	public boolean verificaSeExisteAluno(String matricula) {
		for (Aluno a : Gerente.alunos) {
			if (a.getMatricula().equals(matricula)) {
				return true;
			}
		}
		return false;

	}

	// Verifica se a matricula do aluno existe e remove a posição do array passado
	// Esse metódo foi implementado para verificar antes de realizar a alteração do
	// aluno, cria uma lista temporaria, remove a posição do array da lista
	// e faz a verificação se existe outra matricula sem ser a do array removido,
	// pois, é possivel, alterar somente o email e o nome, sem alterar a matricula.
	// Como pode ter um aluno com nomes iguais, o controle é será feito por
	// matricula. Se existir retorna true, caso contrario, false.
	public boolean verificaSeExisteAluno(int id, String matricula) {
		List<Aluno> list = Gerente.getAlunos();
		list.remove(id);
		for (Aluno a : list) {
			if (a.getMatricula().equals(matricula)) {
				return true;
			}
		}
		return false;

	}

	// Verifica se um aluno existe pela sua matricula
	// Como pode ter um aluno com nomes iguais, o controle é será feito por
	// matricula. Caso o aluno não seja encontrado, é lançada uma exceção!
	public Aluno buscaAlunoPorMatricula(String mat) throws Exception {
		for (Aluno a : Gerente.alunos) {
			if (a.getMatricula().equals(mat)) {
				return a;
			}
		}
		throw new Exception("Matricula do aluno inexistente!");
	}

	// Verifica se o nome do aluno existe
	// Caso o aluno não seja encontrado, é lançada uma exceção!
	// OBS: falta verificar se existem dois alunos ou mais com o mesmo nome
	public Aluno buscaAlunoPorNome(String nome) throws Exception {
		for (Aluno a : Gerente.alunos) {
			if (a.getNome().equals(nome)) {
				return a;
			}
		}
		throw new Exception("Aluno inexistente!");
	}

	// Verifica se a matricula do professor existe
	// O controle é será feito por matricula.
	// Se existir retorna true, caso contrario, false.
	public boolean verificaSeExisteProfessor(String matricula) {
		for (Professor p : Gerente.professores) {
			if (p.getMatricula().equals(matricula)) {
				return true;
			}
		}
		return false;

	}

	// Verifica se a matricula do professor existe e remove a posição do array
	// passado
	// Esse metódo foi implementado para verificar antes de realizar a alteração do
	// professor, cria uma lista temporaria, remove a posição do array da lista
	// e faz a verificação se existe outra matricula sem ser a do array removido,
	// pois, é possivel, alterar somente nome, sem alterar a matricula.
	// Como pode ter um professor com nomes iguais, o controle é será feito por
	// matricula. Se existir retorna true, caso contrario, false.
	public boolean verificaSeExisteProfessor(int id, String matricula) {
		List<Professor> list = Gerente.getProfessores();
		list.remove(id);
		for (Professor a : list) {
			if (a.getMatricula().equals(matricula)) {
				return true;
			}
		}
		return false;

	}

	// Verifica se um professor existe pela sua matricula
	// caso o professor não seja encontrado, é lançada uma exceção!
	public Professor buscaProfessor(String mat) throws Exception {
		for (Professor p : Gerente.professores) {
			if (p.getMatricula().equals(mat)) {
				return p;
			}
		}
		throw new Exception("Matricula Inexistente");
	}

	// Verifica se uma disciplina existe pelo codigo
	// caso nao seja encontrado, é lançada uma exceção!
	public Disciplina buscaDisciplina(String cod) throws Exception {
		for (Disciplina p : Gerente.disciplinas) {
			if (p.getCodigo().equals(cod)) {
				return p;
			}
		}
		throw new Exception("Código Inexistente!");
	}

	// Verifica se uma disciplina existee remove a posição do array passado
	// Esse metódo foi implementado para verificar antes de realizar a alteração da
	// disciplina, cria uma lista temporaria, remove a posição do array da lista
	// e faz a verificação se existe outro código sem ser a do array removido,
	// pois, é possivel, alterar somente a area e o nome, sem alterar o codigo.
	public boolean verificaSeExisteDisciplina(int id, Disciplina disciplina) {
		List<Disciplina> list = Gerente.getDisciplinas();
		list.remove(id);
		for (Disciplina a : list) {
			if (a.equals(disciplina)) { // verifica com a implementeção do equals da classe de modelo
				return true;
			}
		}
		return false;

	}

	// Verifica se uma disciplina existe pelo codigo ou pela descricao
	// caso não seja encontrado, é lançada uma exceção!
	public Disciplina buscaDisciplina(Disciplina disciplina) throws Exception {
		for (Disciplina d : Gerente.disciplinas) {
			if (d.getCodigo().equals(disciplina.getCodigo()) || d.getNome().equals(disciplina.getNome())) {
				return d;
			}
		}
		throw new Exception("Disciplina Inexistente!");
	}

	// Verifica se o codigo ou o nome da disciplina existe
	// O controle é será feito por codigo e nome da disciplina.
	// Se existir retorna true, caso contrario, false.
	public boolean verificaSeExisteDisciplina(Disciplina disciplina) {
		for (Disciplina d : Gerente.disciplinas) {
			if (d.equals(disciplina)) { // verifica com a implementeção do equals da classe de modelo
				return true;
			}
		}
		return false;

	}

	// Verifica se o codigo da disciplina existe
	// Se existir retorna true, caso contrario, false.
	public boolean verificaSeExisteDisciplina(String codigo) {
		for (Disciplina d : Gerente.disciplinas) {
			if (d.getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;

	}

	// Verifica se a identificação da disciplina existe
	// Se existir retorna true, caso contrario, false.
	public boolean verificaSeExisteIdentificacaoTurma(String identificacao) {
		for (Turma d : Gerente.getTurmas()) {
			if (d.getCodigo().equals(identificacao)) {
				return true;
			}
		}
		return false;

	}

	// Verifica se a identifição da turma existe e remove a posição do array
	// passado.Esse metódo foi implementado para verificar antes de realizar a
	// alteração da turma, cria uma lista temporaria, remove a posição do array da
	// lista
	// e faz a verificação se existe outra matricula sem ser a do array removido.
	// Se existir retorna true, caso contrario, false.
	public boolean verificaSeExisteIdentificacaoTurma(int id, String identificacao) {
		List<Turma> list = Gerente.getTurmas();
		list.remove(id);
		for (Turma a : list) {
			if (a.getCodigo().equals(identificacao)) {
				return true;
			}
		}
		return false;

	}

	// =============== FIM VERIFICAÇÕES/BUSCAS=================

	// ==================== EXCLUSÕES =========================

	// Excluir Aluno
	public void excluirAluno(String mat) {
		for (Aluno a : Gerente.alunos) {
			if (a.getMatricula().equals(mat)) {
				Gerente.alunos.remove(a);
				break;
			}
		}
	}

	// Excluir Professor
	public void excluirProfessor(String mat) {
		for (Professor a : Gerente.professores) {
			if (a.getMatricula().equals(mat)) {
				Gerente.professores.remove(a);
				break;
			}
		}
	}

	// Excluir Turma
	public void excluirTurma(String identificacao) {
		for (Turma a : Gerente.turmas) {
			if (a.getCodigo().equals(identificacao)) {
				Gerente.turmas.remove(a);
				break;
			}
		}
	}

	// Excluir Disciplina
	public void excluirDisciplina(String codigo) {
		for (Disciplina a : Gerente.disciplinas) {
			if (a.getCodigo().equals(codigo)) {
				Gerente.disciplinas.remove(a);
				break;
			}
		}
	}

	// ====================FIM EXCLUSÕES =========================

	// Metodo para alterar aluno (SUBSTITUIR)
	// Esse metódo é varrido com o for comum para que seja possivel
	// guardar a posição do array e assim O ALUNO SER SUBSTITUIDO
	public void editarAluno(String mat, Aluno aluno) {
		int posArray = 0;
		for (int i = 0; i < Gerente.alunos.size(); i++) {
			if (Gerente.alunos.get(i).getMatricula().equals(mat)) {
				Gerente.alunos.remove(i);
				posArray = i;
				break;
			}
		}
		Gerente.alunos.add(posArray, aluno);
	}

	// Metodo para alterar disciplina (SUBSTITUIR)
	// Esse metódo é varrido com o for comum para que seja possivel
	// guardar a posição do array e assim A DISCIPLINA SERA SUBSTITUIDO
	public void editarDisciplina(String codigo, Disciplina disciplina) {
		int posArray = 0;
		for (int i = 0; i < Gerente.disciplinas.size(); i++) {
			if (Gerente.disciplinas.get(i).getCodigo().equals(codigo)) {
				Gerente.alunos.remove(i);
				posArray = i;
				break;
			}
		}
		Gerente.disciplinas.add(posArray, disciplina);
	}

	// Metodo para alterar o professor (SUBSTITUIR)
	// Esse metódo é varrido com o for comum para que seja possivel
	// guardar a posição do array e assim O PROFESSOR SER SUBSTITUIDO
	public void editarProfessor(String mat, Professor professor) {
		int posArray = 0;
		for (int i = 0; i < Gerente.professores.size(); i++) {
			if (Gerente.professores.get(i).getMatricula().equals(mat)) {
				Gerente.professores.remove(i);
				posArray = i;
				break;
			}
		}
		Gerente.professores.add(posArray, professor);
	}

	// Metodo para alterar turma (SUBSTITUIR)
	// Esse metódo é varrido com o for comum para que seja possivel
	// guardar a posição do array e assim A TURMA SER SUBSTITUIDA
	public void editarTurma(String identificacao, Turma turma) {
		int posArray = 0;
		for (int i = 0; i < Gerente.alunos.size(); i++) {
			if (Gerente.turmas.get(i).getCodigo().equals(identificacao)) {
				Gerente.turmas.remove(i);
				posArray = i;
				break;
			}
		}
		Gerente.turmas.add(posArray, turma);
	}

}
