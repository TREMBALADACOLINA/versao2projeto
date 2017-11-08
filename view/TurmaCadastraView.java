package br.com.ufpb.poo.projeto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.ufpb.poo.projeto.gerente.Gerente;
import br.com.ufpb.poo.projeto.model.Turma;

public class TurmaCadastraView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8737839010622308167L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMatriculaProfessor;
	private JTextField textFieldCodigoDisciplina;
	private static Gerente gerente = new Gerente();
	private JTextField textFieldIdentificacaoDisciplina;;// Instanciando um Gerente estatico para permanecer dados na
															// memoria

	/**
	 * Código gerado pelo eclipse (Plugin WindowBuilder)
	 */
	public TurmaCadastraView() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TurmaCadastraView.class.getResource("/br/com/ufpb/poo/projeto/images/ufpb.png")));
		setTitle("Turma");
		setBounds(100, 100, 473, 282);
		setLocationRelativeTo(null);// centralizar na tela
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Confirmar");
			okButton.setFocusPainted(false);
			okButton.setContentAreaFilled(false);
			okButton.setForeground(new Color(255, 255, 255));
			okButton.setBackground(new Color(0, 191, 255));
			okButton.setOpaque(true);
			okButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// .trim() remove os ultimos espaço do campo de texto
					// .upperCase() deixa os textos todos maiusculos
					String mensagem = ""; // String para exibir mensagem
					// validar campos
					if (textFieldMatriculaProfessor.getText().isEmpty()) {
						mensagem = "Por favor, digite a matricula do professor!";
						textFieldMatriculaProfessor.requestFocus(); // Seta o foco para o componente
					} else if (textFieldCodigoDisciplina.getText().isEmpty()) {
						mensagem = "Por favor, digite o código da disciplina!";
						textFieldCodigoDisciplina.requestFocus(); // Seta o foco para o componente
					} else if (textFieldIdentificacaoDisciplina.getText().isEmpty()) {
						mensagem = "Por favor, digite o identificação da disciplina!";
						textFieldIdentificacaoDisciplina.requestFocus(); // Seta o foco para o componente
					} else if (gerente
							.verificaSeExisteProfessor(textFieldMatriculaProfessor.getText().trim().toUpperCase())) {
						mensagem = "Matrícula do professor inexistente!";
						textFieldMatriculaProfessor.requestFocus(); // Seta o foco para o componente
					} else if (gerente.verificaSeExisteDisciplina(textFieldCodigoDisciplina.getText().trim().toUpperCase())) {
						mensagem = "Código da disciplina inexistente!";
						textFieldCodigoDisciplina.requestFocus(); // Seta o foco para o componente
					} else if (gerente.verificaSeExisteIdentificacaoTurma(
							textFieldIdentificacaoDisciplina.getText().trim().toUpperCase())) { // .trim() remove espaço
																								// da caixa de texto
						mensagem = "Identificação da turma já está sendo usada!";
						textFieldIdentificacaoDisciplina.requestFocus(); // Seta o foco para o componente
					} else {
						try {
							Turma turma = new Turma(textFieldIdentificacaoDisciplina.getText().trim().toUpperCase(),
									gerente.buscaProfessor(textFieldMatriculaProfessor.getText().trim().toUpperCase()),
									gerente.buscaDisciplina(textFieldCodigoDisciplina.getText().trim().toUpperCase()));
							gerente.cadastrarTurma(turma);
							mensagem = "Turma cadastrada com sucesso!";
							// Seta Valores como nulos
							textFieldCodigoDisciplina.setText(null);
							textFieldMatriculaProfessor.setText(null);
							textFieldIdentificacaoDisciplina.setText(null);
							textFieldMatriculaProfessor.requestFocus(); // Seta o foco para o componente

						} catch (Exception e1) {
							mensagem = "Erro ao cadastrar a turma!\n" + e1.getMessage();
						}

					}

					JOptionPane.showMessageDialog(null, mensagem); // Exibe mensagem

				}
			});
			okButton.setBounds(10, 191, 134, 29);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setFocusPainted(false);
			cancelButton.setContentAreaFilled(false);
			cancelButton.setForeground(new Color(255, 255, 255));
			cancelButton.setBackground(new Color(255, 0, 0));
			cancelButton.setOpaque(true);
			cancelButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setBounds(162, 191, 134, 29);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}

		textFieldMatriculaProfessor = new JTextField();
		textFieldMatriculaProfessor.setColumns(10);
		textFieldMatriculaProfessor.setBounds(173, 60, 123, 28);
		contentPanel.add(textFieldMatriculaProfessor);

		textFieldCodigoDisciplina = new JTextField();
		textFieldCodigoDisciplina.setColumns(10);
		textFieldCodigoDisciplina.setBounds(173, 100, 123, 28);
		contentPanel.add(textFieldCodigoDisciplina);

		JLabel lblMatrculaDoProfessor = new JLabel("Matrícula do Professor:");
		lblMatrculaDoProfessor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMatrculaDoProfessor.setPreferredSize(new Dimension(20, 14));
		lblMatrculaDoProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatrculaDoProfessor.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblMatrculaDoProfessor.setBounds(10, 60, 163, 28);
		contentPanel.add(lblMatrculaDoProfessor);

		JLabel lblMatrcula = new JLabel("Código da Disciplina :");
		lblMatrcula.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMatrcula.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatrcula.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblMatrcula.setBounds(10, 100, 163, 28);
		contentPanel.add(lblMatrcula);

		JLabel lblCadastroDeProfessores = new JLabel("Cadastro de turmas");
		lblCadastroDeProfessores.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProfessores.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCadastroDeProfessores.setBounds(0, 11, 457, 28);
		contentPanel.add(lblCadastroDeProfessores);

		JButton btnExibirProfessores = new JButton("Exibir Professores");
		btnExibirProfessores.setContentAreaFilled(false);
		btnExibirProfessores.setForeground(new Color(255, 255, 255));
		btnExibirProfessores.setBackground(new Color(192, 192, 192));
		btnExibirProfessores.setOpaque(true);
		btnExibirProfessores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TabelaView().exibirProfessores();
			}
		});
		btnExibirProfessores.setBounds(306, 60, 141, 28);
		contentPanel.add(btnExibirProfessores);

		JLabel lblIdentificaoDaDisciplina = new JLabel("Identificação da Disciplina :");
		lblIdentificaoDaDisciplina.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdentificaoDaDisciplina.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdentificaoDaDisciplina.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblIdentificaoDaDisciplina.setBounds(10, 139, 163, 28);
		contentPanel.add(lblIdentificaoDaDisciplina);

		textFieldIdentificacaoDisciplina = new JTextField();
		textFieldIdentificacaoDisciplina.setColumns(10);
		textFieldIdentificacaoDisciplina.setBounds(173, 139, 123, 28);
		contentPanel.add(textFieldIdentificacaoDisciplina);

		JButton btnExibirDisciplinas = new JButton("Exibir Disciplinas");
		btnExibirDisciplinas.setContentAreaFilled(false);
		btnExibirDisciplinas.setForeground(new Color(255, 255, 255));
		btnExibirDisciplinas.setBackground(new Color(192, 192, 192));
		btnExibirDisciplinas.setOpaque(true);
		btnExibirDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TabelaView().exibirDisciplinas();
			}
		});
		btnExibirDisciplinas.setBounds(306, 100, 141, 28);
		contentPanel.add(btnExibirDisciplinas);

		JButton btnExibirTurmas = new JButton("Exibir Turmas");
		btnExibirTurmas.setFocusPainted(false);
		btnExibirTurmas.setContentAreaFilled(false);
		btnExibirTurmas.setForeground(new Color(255, 255, 255));
		btnExibirTurmas.setBackground(new Color(32, 178, 170));
		btnExibirTurmas.setOpaque(true);
		btnExibirTurmas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnExibirTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TabelaView().exibirTurmas();
			}
		});
		btnExibirTurmas.setActionCommand("Cancel");
		btnExibirTurmas.setBounds(313, 191, 134, 29);
		contentPanel.add(btnExibirTurmas);
	}
}
