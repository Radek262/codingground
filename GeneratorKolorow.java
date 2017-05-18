/*
* Nazwa: GeneratorKolorow.java
* Autor: Tomasz Reczynski (c) 2016
* Album: 194496
* Grupa: KrDZIs2014
*
* Opis: Program ktory generuje kolor na podstawie R G B
*
*
* Kompilacja: javac GeneratorKolorow.java
* Uruchomienie: java GeneratorKolorow
*
*/

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GeneratorKolorow extends JFrame implements ChangeListener{

    private JLabel kodKoloru; // etykieta odpowiadajaca za wyswietlanie kodu koloru
    private JLabel kod;
    private JSlider sCzerwony, sZielony, sNiebieski; // Suwaki odpowiadajace za kolory
    private JPanel panelKoloru; // Panel odpowiadajacy za wyswietlanie koloru
    private int czerwony;
    private int zielony;
    private int niebieski;

    public GeneratorKolorow(){

        super("Generator Kolorow");
        setSize(300,500);

        sCzerwony = new JSlider(0,255,0); // tworzy nowy suwak
        sCzerwony.setMajorTickSpacing(50); // wyznacza co ile maja byc ustawione glowne znaczniki w podzia�ce
        sCzerwony.setMinorTickSpacing(5); // wyznacza co ile maja byc ustawione mniejsze znaczniki w podzialce
        sCzerwony.setPaintTicks(true); // wartosc true oznacza ze znaczniki sa widoczne
        sCzerwony.setPaintLabels(false); // wartosc true oznacza ze wartosci dla glownych znacznikow sa widoczne
        sCzerwony.addChangeListener(this);


        sZielony = new JSlider(0,255,0);
        sZielony.setMajorTickSpacing(50);
        sZielony.setMinorTickSpacing(5);
        sZielony.setPaintTicks(true);
        sZielony.setPaintLabels(true);
        sZielony.addChangeListener(this);

        sNiebieski = new JSlider(0,255,0);
        sNiebieski.setMajorTickSpacing(50);
        sNiebieski.setMinorTickSpacing(5);
        sNiebieski.setPaintTicks(true);
        sNiebieski.setPaintLabels(true);
        sNiebieski.addChangeListener(this);


        panelKoloru = new JPanel(); // panel odpowiadajcy za wyswietlanie koloru
        panelKoloru.setBackground(Color.BLACK);
        JPanel panel1 = new JPanel(); // panel odpowiadajacy za suwaki oraz etykiety
        panel1.setLayout(new GridLayout(7,1));
        JLabel nRGB = new JLabel("Suwaki R-G-B (0-255)");
        nRGB.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(nRGB);
        panel1.add(sCzerwony);
        panel1.add(sZielony);
        panel1.add(sNiebieski);
        kod = new JLabel("Kod Koloru: ");
        kod.setHorizontalAlignment(JLabel.CENTER);
        kodKoloru = new JLabel();
        kodKoloru.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(kod);
        panel1.add(kodKoloru);
        add(panel1, BorderLayout.NORTH);
        add(panelKoloru, BorderLayout.CENTER);


    }

    public void stateChanged(ChangeEvent e) {

        czerwony = sCzerwony.getValue(); // getValue pobiera wartosci typu calkowitego z suwakow i przypisuje do zmiennej
        zielony = sZielony.getValue();
        niebieski = sNiebieski.getValue();
        Color kolor = new Color(czerwony, zielony, niebieski);
        String kolorSzesnastkowo = Integer.toHexString(kolor.getRGB() & 0xffffff); //ge
        kodKoloru.setText("#"+kolorSzesnastkowo); // wyswietla kod koloru
        panelKoloru.setBackground(kolor); // zmienia t�o na wygenerowany przez suwaki kolor
    }


    public static void main(String [] args){
        GeneratorKolorow kolory = new GeneratorKolorow();
        kolory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kolory.setVisible(true);
        kolory.setResizable(false);
        kolory.setLocationRelativeTo(null);
    }



}

