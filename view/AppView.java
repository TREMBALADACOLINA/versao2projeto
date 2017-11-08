package br.com.ufpb.poo.projeto.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class AppView extends JFrame {

	private static final long serialVersionUID = -9118146612005540268L;
	private JPanel contentPane;

	/**
	 * Código gerado pelo eclipse (Plugin WindowBuilder)
	 */
	public AppView() {
		setBackground(Color.WHITE);
		setResizable(false);		
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AppView.class.getResource("/br/com/ufpb/poo/projeto/images/ufpb.png")));
		setTitle("Sistema de Gerenciamento Escolar - Projeto de POO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 578);
		setLocationRelativeTo(null);//centralizar na tela
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Cadastro");
		mnNewMenu.setBackground(Color.WHITE);
		mnNewMenu.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);

		JMenuItem mntmAluno = new JMenuItem("Aluno");
		mntmAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AlunoCadastraView().setVisible(true);
			}
		});
		mntmAluno.setBackground(Color.WHITE);
		mnNewMenu.add(mntmAluno);

		JMenuItem mntmProfessor = new JMenuItem("Professor");
		mntmProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProfessorCadastraView().setVisible(true);
			}
		});
		mntmProfessor.setBackground(Color.WHITE);
		mnNewMenu.add(mntmProfessor);

		JMenuItem mntmTurma = new JMenuItem("Turma");
		mntmTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new TurmaCadastraView().setVisible(true);
			}
		});
		
				JMenuItem mntmNewMenuItem = new JMenuItem("Disciplina");
				mntmNewMenuItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new DisciplinaCadastraView().setVisible(true);
					}
				});
				mntmNewMenuItem.setBackground(Color.WHITE);
				mnNewMenu.add(mntmNewMenuItem);
		mntmTurma.setBackground(Color.WHITE);
		mnNewMenu.add(mntmTurma);

		JMenu mnPesquisa = new JMenu("Gerenciar");
		mnPesquisa.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		menuBar.add(mnPesquisa);
		
		JMenuItem menuItem = new JMenuItem("Aluno");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TabelaView().exibirAlunos();
			}
		});
		menuItem.setBackground(Color.WHITE);
		mnPesquisa.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Professor");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TabelaView().exibirProfessores();
			}
		});
		menuItem_1.setBackground(Color.WHITE);
		mnPesquisa.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Turma");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TabelaView().exibirTurmas();
			}
		});
		
		JMenuItem menuItem_3 = new JMenuItem("Disciplina");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TabelaView().exibirDisciplinas();
			}
		});
		menuItem_3.setBackground(Color.WHITE);
		mnPesquisa.add(menuItem_3);
		menuItem_2.setBackground(Color.WHITE);
		mnPesquisa.add(menuItem_2);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new SobreView().setVisible(true);
			}
		});
		mnSobre.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		menuBar.add(mnSobre);
		JMenu mnSair = new JMenu("Sair");		
		mnSair.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null,"Deseja realmente encerrar o programa?","Encerrar Sistema",0)== JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});
		menuBar.add(mnSair);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(new ImageIcon(AppView.class.getResource("/br/com/ufpb/poo/projeto/images/logo.png")));
		label.setBounds(5, 5, 817, 512);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 497, 827, 16);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRodape = new JLabel("<html>\r\nUniversidade Federal da Paraíba - <b>Departamento de Ciências Exatas</b> - Projeto de POO - <b>Alexandre de Santana | Kyn Kannato</b>\r\n - Versão 1.2\r\n</html>");
		lblRodape.setOpaque(true);
		lblRodape.setBackground(UIManager.getColor("Button.light"));
		lblRodape.setHorizontalAlignment(SwingConstants.CENTER);
		lblRodape.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRodape.setBounds(0, 0, 827, 16);
		panel.add(lblRodape);
	}
}
