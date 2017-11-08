package br.com.ufpb.poo.projeto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

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
import br.com.ufpb.poo.projeto.model.Aluno;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlunoAlteraView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8737839010622308167L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	private JTextField textFieldMatricula;
	private JTextField textFieldEmail;
	private static Gerente gerente = new Gerente();;// Instanciando um Gerente estatico para permanecer dados na memoria
	private Aluno aluno;
	private int posArray;

	/**
	 * Código gerado pelo eclipse (Plugin WindowBuilder)
	 */

	public AlunoAlteraView(int posicaoArray, Aluno aluno) {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.posArray = posicaoArray;
		this.aluno = aluno;
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AlunoAlteraView.class.getResource("/br/com/ufpb/poo/projeto/images/ufpb.png")));
		setModal(true);
		setTitle("Alterar Aluno");
		setBounds(100, 100, 473, 272);
		setLocationRelativeTo(null);// centralizar na tela
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Confirmar");
			okButton.setForeground(new Color(255, 255, 255));
			okButton.setContentAreaFilled(false);
			okButton.setBackground(new Color(0, 191, 255));
			okButton.setOpaque(true);
			okButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					alterar();

				}
			});
			okButton.setBounds(83, 183, 123, 29);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancelar");
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
			cancelButton.setBounds(241, 183, 123, 29);
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

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(83, 140, 364, 28);
		contentPanel.add(textFieldEmail);

		// setar jTxtField com os valores do aluno
		textFieldNome.setText(this.aluno.getNome());
		textFieldMatricula.setText(this.aluno.getMatricula());
		textFieldEmail.setText(this.aluno.getEmail());

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

		JLabel label_2 = new JLabel("E-mail:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		label_2.setBounds(10, 140, 73, 28);
		contentPanel.add(label_2);

		JLabel lblAlterarAluno = new JLabel("Alterar Aluno");
		lblAlterarAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarAluno.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAlterarAluno.setBounds(0, 11, 457, 28);
		contentPanel.add(lblAlterarAluno);
	}

	private void alterar() {
		Aluno aluno = new Aluno(textFieldMatricula.getText().trim().toUpperCase(),
				textFieldNome.getText().trim().toUpperCase(), textFieldEmail.getText().trim().toUpperCase());
		// validar campos
		if (aluno.getNome().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, digite o nome do aluno!");
			textFieldNome.requestFocus(); // Seta o foco para o componente
		} else if (aluno.getMatricula().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, digite a matrícula do aluno!");
			textFieldMatricula.requestFocus(); // Seta o foco para o componente
		} else if (gerente.verificaSeExisteAluno(this.posArray, aluno.getMatricula())) {
			String mensagem = "A matrícula do aluno já está sendo usada!\n";
			// buscar o aluno para ter uma referencia
			try {
				mensagem = mensagem + "ALUNO :" + gerente.buscaAlunoPorMatricula(aluno.getMatricula()).getNome();
				JOptionPane.showMessageDialog(this,mensagem);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Erro ao buscar aluno!\n" + e1.getMessage());
			}
			textFieldMatricula.requestFocus(); // Seta o foco para o componente
		} else {
			gerente.editarAluno(this.aluno.getMatricula(), aluno);
			JOptionPane.showMessageDialog(this,"Aluno alterado com sucesso!");
			this.dispose();
		}

	
	}
}
