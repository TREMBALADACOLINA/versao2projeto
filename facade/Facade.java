package br.com.ufpb.poo.projeto.facade;

import br.com.ufpb.poo.projeto.util.Tema;
import br.com.ufpb.poo.projeto.view.AppView;

public class Facade {
	// Abstrair/esconde o código por tras da interface grafica e aplicar o tema
	public void app() {
		Tema.changeWindows();
		new AppView().setVisible(true);
	}
	
	
}
