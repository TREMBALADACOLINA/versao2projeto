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
import br.com.ufpb.poo.projeto.model.Professor;

public class ProfessorAlteraView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8737839010622308167L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	private JTextField textFieldMatricula;
	private static Gerente gerente = new Gerente();;// Instanciando um Gerente estatico para permanecer dados na memoria

	private Professor professor;
	private int posArray;

	/**
	 * Código gerado pelo eclipse (Plugin WindowBuilder)
	 */
	public ProfessorAlteraView(int posicaoArray, Professor professor) {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.posArray = posicaoArray;
		this.professor = professor;
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ProfessorAlteraView.class.getResource("/br/com/ufpb/poo/projeto/images/ufpb.png")));
		setTitle("Alterar Professor");
		setModal(true);
		setBounds(100, 100, 473, 241);
		setLocationRelativeTo(null);// centralizar na tela
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Confirmar");
			okButton.setFocusPainted(false);
			okButton.setForeground(new Color(255, 255, 255));
			okButton.setContentAreaFilled(false);
			okButton.setBackground(new Color(0, 191, 255));
			okButton.setOpaque(true);
			okButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					altera();

				}
			});
			okButton.setBounds(10, 152, 137, 31);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setFocusPainted(false);
			cancelButton.setForeground(new Color(255, 255, 255));
			cancelButton.setContentAreaFilled(false);
			cancelButton.setBackground(new Color(255, 0, 0));
			cancelButton.setOpaque(true);
			cancelButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setBounds(161, 152, 137, 31);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}

		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(83, 60, 364, 28);
		contentPanel.add(textFieldNome);

		textFieldMatricula = new JTextField();
		textFieldMatricula.setColumns(10);
		textFieldMatricula.setBounds(83, 100, 364, 28);
		contentPanel.add(textFieldMatricula);

		// setar jTxtField com os valores do professor
		textFieldNome.setText(this.professor.getNome());
		textFieldMatricula.setText(this.professor.getMatricula());

		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setPreferredSize(new Dimension(20, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(new LineBorder(Color.LIGHT_GRAY));
		label.setBounds(10, 60, 73, 28);
		contentPanel.add(label);

		JLabel label_1 = new JLabel("Matricula:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		label_1.setBounds(10, 100, 73, 28);
		contentPanel.add(label_1);

		JLabel lblCadastroDeProfessores = new JLabel("Alterar professor");
		lblCadastroDeProfessores.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProfessores.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCadastroDeProfessores.setBounds(0, 11, 457, 28);
		contentPanel.add(lblCadastroDeProfessores);

		JButton btnNewButton = new JButton("Exibir Professores");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBackground(new Color(32, 178, 170));
		btnNewButton.setOpaque(true);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TabelaView().exibirProfessores();
			}
		});
		btnNewButton.setBounds(311, 152, 136, 31);
		contentPanel.add(btnNewButton);
	}

	private void altera() {
		Professor professor = new Professor(textFieldMatricula.getText().trim().toUpperCase(),
				textFieldNome.getText().trim().toUpperCase());
		// validar campos
		if (professor.getNome().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor, digite o nome do professor!");
			textFieldNome.requestFocus(); // Seta o foco para o componente
		} else if (professor.getMatricula().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor, digite a matrícula do professor!");
			textFieldMatricula.requestFocus(); // Seta o foco para o componente
		} else if (gerente.verificaSeExisteProfessor(this.posArray,	professor.getMatricula())) {
			String mensagem = "A matrícula do professor já está sendo usada!\n";
			// buscar o professor para ter uma referencia
			try {
				mensagem = mensagem + "Professor :" + gerente.buscaProfessor(professor.getMatricula()).getNome();
			} catch (Exception e1) {
				mensagem = "Erro ao buscar aluno!\n" + e1.getMessage();
			}
			textFieldMatricula.requestFocus(); // Seta o foco para o componente
		} else {
			gerente.editarProfessor(this.professor.getMatricula(), professor);
			JOptionPane.showMessageDialog(null, "Professor Cadastrado com sucesso!");
			this.dispose();
		}
	}
}
