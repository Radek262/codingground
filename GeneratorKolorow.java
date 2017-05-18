/*
 * Nazwa: GeneratorKolorow.java
   
Autor: Radosław Dunin-Wąsowicz  (c) 2016
   
Album: 192663
   Grupa: KrDZIs2012
   
Opis: 
   Program przedstawia generatow kolorow w systemie szesnastkowym, wartosci ustawia sie za pomoca suwakow.
   Wykorzystano elementy graficznego interfejsu oraz proste metody obliczeniowe.
   
Kompilacja: javac GeneratorKolorow.java
    
Uruchomienie: java GeneratorKolorow
 */


import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class GeneratorKolorow extends JFrame {
	private JSlider slider1,slider2,slider3;
	private JLabel code,sliders,number;
	private JPanel body,footer;
	
	public GeneratorKolorow()
	{
		super("Generator kolorow");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//deklaracja komponentow
		slider1 = new JSlider(JSlider.HORIZONTAL,0,250,0);
		slider2 = new JSlider(JSlider.HORIZONTAL,0,250,0);
		slider3 = new JSlider(JSlider.HORIZONTAL,0,250,0);
		//ustawienie odleglosci zmiany wartosci
		slider1.setMajorTickSpacing(50);
		slider2.setMajorTickSpacing(50);
		slider3.setMajorTickSpacing(50);
		
		//ustawienie przestrzeni na podzialce
		slider1.setMinorTickSpacing(5);
		slider2.setMinorTickSpacing(5);
		slider3.setMinorTickSpacing(5);

		//ustawienie widocznosci suwaka
		slider1.setPaintTicks(true);
		slider2.setPaintTicks(true);
		slider3.setPaintTicks(true);
		
		//ustawienie widocznosci podzialki liniowej
		slider1.setPaintLabels(true);
		slider2.setPaintLabels(true);
		slider3.setPaintLabels(true);
		//zdefiniowanie etykiet
		code = new JLabel("Kod koloru");
		sliders = new JLabel("Suwaki R-G-B (0-250)");
		number = new JLabel();

		//zdefinowoanie "pojemnika,ciala" 
		body = new JPanel();
		footer = new JPanel();
		
		//menadzer rozkladu
		add(sliders,BorderLayout.NORTH);
		add(body,BorderLayout.CENTER);
		body.setLayout(new GridLayout(5,1,2,2));
		//dodanie suwakow
		body.add(slider1);
		body.add(slider2);
		body.add(slider3);
		body.add(code);
		footer.add(number);
		body.add(footer);
	

		
		//zdefinowanie obiektu zmiany 
		Operating change = new Operating();
		slider1.addChangeListener(change);
		slider2.addChangeListener(change);
		slider3.addChangeListener(change);
	}

	public class Operating implements ChangeListener
	{
		//obsluga zdarzen
		public void stateChanged(ChangeEvent change) {
			//wczytanie wartosci z suwakow
			int value1 = slider1.getValue();
			int value2 = slider2.getValue();
			int value3 = slider3.getValue();
			int sum = value1+value2+value3;
			//konwersja na szesnastkowy i wydrukowanie
			number.setText(Integer.toHexString(sum));
		}
	}
	public static void main(String[] args)
	{
		//ustawienie widocznosci okna
		GeneratorKolorow window = new GeneratorKolorow();
		window.setVisible(true);
	}
}
