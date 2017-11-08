package br.com.ufpb.poo.projeto.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SobreView extends JDialog {

	private static final long serialVersionUID = -3725225983739226592L;
	private final JPanel contentPanel = new JPanel();
	private final JLabel label = new JLabel(
			new ImageIcon(SobreView.class.getResource("/br/com/ufpb/poo/projeto/images/ufpb.png")));

	/**
	 * Código gerado pelo eclipse (Plugin WindowBuilder).
	 */
	public SobreView() {
		setResizable(false);
		setModal(true);
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Sobre os Desenvolvedores");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(SobreView.class.getResource("/br/com/ufpb/poo/projeto/images/ufpb.png")));
		setBounds(100, 100, 450, 341);
		setLocationRelativeTo(null);//centralizar na tela
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 302);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			contentPanel.setLayout(null);
		}
		label.setBounds(151, 11, 147, 165);
		contentPanel.add(label);

		JLabel lbluniversidadeFederalDa = new JLabel(
				"<html><center> <b>Universidade Federal da Paraíba<b><p>Disciplina: Programação Orientado a Objetos<p>Desenvolvedores: Alexandre de Santana, Kyn Kannato</center></html>");
		lbluniversidadeFederalDa.setFont(new Font("Dialog", Font.BOLD, 13));
		lbluniversidadeFederalDa.setBounds(43, 168, 356, 69);
		contentPanel.add(lbluniversidadeFederalDa);
		JButton okButton = new JButton("Fechar");
		okButton.setFocusPainted(false);
		okButton.setContentAreaFilled(false);
		okButton.setBackground(new Color(255, 0, 0));
		okButton.setForeground(new Color(255, 255, 255));
		okButton.setOpaque(true);
		okButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		okButton.setBounds(158, 257, 107, 34);
		contentPanel.add(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		okButton.setActionCommand("Voltar");
		getRootPane().setDefaultButton(okButton);
	}
}
