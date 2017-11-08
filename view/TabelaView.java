package br.com.ufpb.poo.projeto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.com.ufpb.poo.projeto.gerente.Gerente;
import br.com.ufpb.poo.projeto.model.AlunoTableModel;
import br.com.ufpb.poo.projeto.model.DisciplinaTableModel;
import br.com.ufpb.poo.projeto.model.ProfessorTableModel;
import br.com.ufpb.poo.projeto.model.TurmaTableModel;

public class TabelaView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7798677511221758672L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JLabel lblTabelas;

	private static final Gerente gerente = new Gerente();

	/**
	 * Código gerado pelo eclipse (Plugin WindowBuilder)
	 */
	public TabelaView() {
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Tabela");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TabelaView.class.getResource("/br/com/ufpb/poo/projeto/images/ufpb.png")));
		setBounds(100, 100, 536, 435);
		setLocationRelativeTo(null);// Centralizar Tela
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 35, 500, 301);
		contentPanel.add(scrollPane);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.BOLD, 12));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.setBounds(191, 347, 141, 27);
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setOpaque(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));

		contentPanel.add(btnNewButton);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(10, 347, 141, 27);
		btnAlterar.setBackground(new Color(0, 153, 255));
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setOpaque(true);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterar();
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));

		contentPanel.add(btnAlterar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setForeground(Color.WHITE);
		btnFechar.setContentAreaFilled(false);
		btnFechar.setBounds(369, 347, 141, 27);
		btnFechar.setOpaque(true);
		btnFechar.setBackground(Color.RED);
		btnFechar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		contentPanel.add(btnFechar);

		lblTabelas = new JLabel("Tabelas");
		lblTabelas.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblTabelas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabelas.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTabelas.setBounds(10, 11, 500, 21);
		contentPanel.add(lblTabelas);

	}

	/**
	 * Atribuir DefautTableModel O DefaultTableModel serve para colocar os dados
	 * (colunas e linhas) de uma tabela, separado do objeto tabela (JTable).
	 */

	// Passo o Gerente.getAlunos()
	public void exibirAlunos() {
		// iniciar o jdialog sem precisar passar o setVisible(true)

		setTitle("Exibindo Alunos");
		lblTabelas.setText(this.getTitle());
		// - Atribuimos o modelo a tabela
		this.preencherTabela('A');
		this.setVisible(true);
	}

	// Passo o Gerente.getDisciplinas()
	public void exibirDisciplinas() {		
		setTitle("Exibindo Disciplinas"); // Altero o titulo
		lblTabelas.setText(this.getTitle());// Pego o titulo e atibuo ao texto do label
		this.preencherTabela('D');
		this.setVisible(true);
	}

	// Passo o Gerente.getProfessores()
	public void exibirProfessores() {
		setTitle("Exibindo Professores");
		lblTabelas.setText(this.getTitle());		
		this.preencherTabela('B');
		this.setVisible(true);
	}

	// Passo o Gerente.getTurmas()
	public void exibirTurmas() {		
		setTitle("Exibindo Turmas");
		lblTabelas.setText(this.getTitle());
		this.preencherTabela('C');
		this.setVisible(true);
	}

	// Esse metodo seta o model da tabela
	// passa um char para setar o model especifico
	// 'A' para ALUNO
	// 'B' para PROFESSOR
	// 'C' para TURMA
	// 'D' para DISCIPLINA
	private void preencherTabela(char c) {
		switch (c) {
		case 'A':
			table.setModel(new AlunoTableModel(Gerente.getAlunos()));
			break;
		case 'B':
			table.setModel(new ProfessorTableModel(Gerente.getProfessores()));
			break;
		case 'C':
			table.setModel(new TurmaTableModel(Gerente.getTurmas()));
			break;
		case 'D':
			table.setModel(new DisciplinaTableModel(Gerente.getDisciplinas()));
			break;
		default:
			break;
		}

	}

	// O Java oferece o operador instanceof como um mecanismo para determinar em
	// runtime, a clase à qual um objeto pertence (Isso normalmente é chamado tipo
	// de runtime de objeto).
	// Nesse caso, eu pego o model da tabela e verifico a qual classe ela pertence
	private void excluir() {
		if (this.validaSelecaoJtable()) {
			if (table.getModel() instanceof AlunoTableModel) {
				if (JOptionPane.showConfirmDialog(this,
						"DESEJA REMOVER O ALUNO SELECIONADO?") == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(this, "ALUNO REMOVIDO COM SUCESSO");
					Integer linhaSelecionada = this.getRow();
					gerente.excluirAluno(String.valueOf(table.getValueAt(linhaSelecionada, 0)));
					this.preencherTabela('A');
				}

			} else if (table.getModel() instanceof ProfessorTableModel) {
				if (JOptionPane.showConfirmDialog(this,
						"DESEJA REMOVER O PROFESSOR SELECIONADO?") == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(this, "PROFESSOR REMOVIDO COM SUCESSO");
					Integer linhaSelecionada = this.getRow();
					gerente.excluirProfessor(String.valueOf(table.getValueAt(linhaSelecionada, 0)));
					this.preencherTabela('B');
				}

			} else if (table.getModel() instanceof DisciplinaTableModel) {
				if (JOptionPane.showConfirmDialog(this,
						"DESEJA REMOVER A DISCIPLINA SELECIONADA?") == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(this, "DISCIPLINA REMOVIDA COM SUCESSO");
					Integer linhaSelecionada = this.getRow();
					gerente.excluirDisciplina(String.valueOf(table.getValueAt(linhaSelecionada, 0)));
					this.preencherTabela('D');
				}

			} else if (table.getModel() instanceof TurmaTableModel) {
				if (JOptionPane.showConfirmDialog(this,
						"DESEJA REMOVER A TURMA SELECIONADA?") == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(this, "TURMA REMOVIDA COM SUCESSO");
					Integer linhaSelecionada = this.getRow();
					gerente.excluirDisciplina(String.valueOf(table.getValueAt(linhaSelecionada, 0)));
					this.preencherTabela('C');
				}

			}
		}
	}

	private void alterar() {
		if (this.validaSelecaoJtable()) {
			if (table.getModel() instanceof AlunoTableModel) {
				new AlunoAlteraView(this.getRow(), Gerente.getAlunos().get(this.getRow())).setVisible(true);
				this.preencherTabela('A');
			} else if (table.getModel() instanceof ProfessorTableModel) {
				new ProfessorAlteraView(this.getRow(), Gerente.getProfessores().get(this.getRow())).setVisible(true);
				this.preencherTabela('B');
			} else if (table.getModel() instanceof DisciplinaTableModel) {
				new DisciplinaAlteraView(this.getRow(), Gerente.getDisciplinas().get(this.getRow())).setVisible(true);
				this.preencherTabela('D');
			} else if (table.getModel() instanceof TurmaTableModel) {
				new TurmaAlteraView(this.getRow(), Gerente.getTurmas().get(this.getRow())).setVisible(true);
				this.preencherTabela('C');
			}
		}
	}

	// Implementação para alterar e excluir
	private boolean validaSelecaoJtable() {
		if (table.getRowCount() > 0) {
			if (table.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "POR FAVOR, SELECIONE UM ITEM DA TABELA!");
				return false;
			} else {
				return true;
			}

		}
		return false;

	}

	// Retorna linha selecionada
	private Integer getRow() {
		return Integer.parseInt(String.valueOf(table.getSelectedRow()));
	}

}
