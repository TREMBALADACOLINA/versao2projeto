package br.com.ufpb.poo.projeto.util;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Tema {
	/**
	 * O tema padrao do java é o Nimbus! Este metodo irá alterar o tema padrão para
	 * o Windows. O UIManager gerencia o visual! *
	 * 
	 * @throws ClassNotFoundException
	 *             É lançado se a classe não existe no pacote.
	 * @throws InstantiationException
	 *             É lançado se o objeto não for instanciado corretamente.
	 * 
	 * @throws IllegalAccessException
	 *             É lançado quando um aplicativo tenta acessar ou invocar um
	 *             método,mas o método atualmente em execução não tem acesso à
	 *             definição da classe especificada
	 * @throws UnsupportedLookAndFeelException
	 *             Uma exceção que indica que as classes de gerenciamento de
	 *             aparência e sensação solicitadas não estão presentes no sistema
	 *             do usuário.
	 */

	public static void changeWindows() {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

	}

}
