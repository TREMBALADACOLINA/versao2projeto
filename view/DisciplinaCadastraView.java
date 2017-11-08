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
import br.com.ufpb.poo.projeto.model.Disciplina;

public class DisciplinaCadastraView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8737839010622308167L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	private JTextField textFieldCodigo;
	private JTextField textFieldArea;
	private static Gerente gerente = new Gerente(); ;// Instanciando um Gerente estatico para permanecer dados na memoria

	/**
	 * Código gerado pelo eclipse (Plugin WindowBuilder)
	 */
	public DisciplinaCadastraView() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DisciplinaCadastraView.class.getResource("/br/com/ufpb/poo/projeto/images/ufpb.png")));
		setTitle("Disciplina");
		setBounds(100, 100, 473, 271);
		setLocationRelativeTo(null);//centralizar na tela		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Confirmar");
			okButton.setFocusPainted(false);
			okButton.setForeground(new Color(255, 255, 255));
			okButton.setBackground(new Color(0, 191, 255));
			okButton.setContentAreaFilled(false);
			okButton.setOpaque(true);
			okButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Disciplina disciplina = new Disciplina(textFieldCodigo.getText().trim().toUpperCase(),
							textFieldNome.getText().trim().toUpperCase(),
							textFieldArea.getText().trim().toUpperCase());					
					String mensagem = ""; //String para exibir mensagem 
					// validar campos 
					if (disciplina.getNome().isEmpty()) {
						mensagem = "Por favor, digite o nome da disciplina!";
						textFieldNome.requestFocus(); // Seta o foco para o componente
					} else if (disciplina.getCodigo().isEmpty()) {
						mensagem = "Por favor, digite o código da disciplina!";
						textFieldCodigo.requestFocus(); // Seta o foco para o componente
					}else if (disciplina.getArea().isEmpty()) {
							mensagem = "Por favor, digite a área da disciplina!";
							textFieldCodigo.requestFocus(); // Seta o foco para o componente							
					} else if (gerente.verificaSeExisteDisciplina(disciplina)) {
						mensagem = "Já existe disciplinas com esses dados!\n";
						// buscar a disciplina para ter uma referencia
						try {
							
							Disciplina d2 = gerente.buscaDisciplina(disciplina);
							mensagem = mensagem + "Disciplina: "
									+ d2.getNome()+" - Cod: "+d2.getCodigo()   ;
						} catch (Exception e1) {
							mensagem = "Erro ao buscar Disciplina!\n" + e1.getMessage();
						}
						textFieldNome.requestFocus(); // Seta o foco para o componente
					} else {
						gerente.cadastrarDisciplina(disciplina);
						mensagem = "Disciplina Cadastrado com sucesso!";
						// Seta Valores como nulos
						textFieldCodigo.setText(null);
						textFieldNome.setText(null);
						textFieldArea.setText(null);
						textFieldNome.requestFocus(); // Seta o foco para o componente
					}

					JOptionPane.showMessageDialog(null, mensagem); // Exibe mensagem

				}
			});
			okButton.setBounds(10, 179, 132, 31);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setFocusPainted(false);
			cancelButton.setForeground(new Color(255, 255, 255));
			cancelButton.setBackground(new Color(255, 0, 0));
			cancelButton.setContentAreaFilled(false);
			cancelButton.setOpaque(true);
			cancelButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setBounds(166, 179, 132, 31);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}

		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(83, 60, 364, 28);
		contentPanel.add(textFieldNome);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(83, 100, 364, 28);
		contentPanel.add(textFieldCodigo);

		textFieldArea = new JTextField();
		textFieldArea.setColumns(10);
		textFieldArea.setBounds(83, 140, 364, 28);
		contentPanel.add(textFieldArea);

		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setPreferredSize(new Dimension(20, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(new LineBorder(Color.LIGHT_GRAY));
		label.setBounds(10, 60, 73, 28);
		contentPanel.add(label);

		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigo.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblCdigo.setBounds(10, 100, 73, 28);
		contentPanel.add(lblCdigo);

		JLabel lblrea = new JLabel("Área:");
		lblrea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblrea.setHorizontalAlignment(SwingConstants.CENTER);
		lblrea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblrea.setBounds(10, 140, 73, 28);
		contentPanel.add(lblrea);

		JLabel lblCadastroDeDisciplinas = new JLabel("Cadastro de disciplinas");
		lblCadastroDeDisciplinas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeDisciplinas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCadastroDeDisciplinas.setBounds(0, 11, 457, 28);
		contentPanel.add(lblCadastroDeDisciplinas);
		
		JButton btnNewButton = new JButton("Exibir Disciplinas");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(32, 178, 170));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(true);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TabelaView().exibirDisciplinas();
			}
		});
		btnNewButton.setBounds(315, 179, 132, 31);
		contentPanel.add(btnNewButton);
	}
}
