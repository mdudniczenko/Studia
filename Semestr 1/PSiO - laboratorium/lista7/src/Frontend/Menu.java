package Frontend;

import Backend.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Menu {
    public JFrame frame;
    public Menu() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new JFrame("Menu");
                frame.add(new PrzyciskiMenu());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
    }
    public class PrzyciskiMenu extends JPanel{
        public PrzyciskiMenu(){
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            JLabel naglowek = new JLabel("MENU");
            naglowek.setFont(new Font("a", Font.PLAIN, 30));
            naglowek.setForeground(new Color(88, 38, 189));
            add(naglowek, gbc);
            add(new JLabel(" "), gbc);

            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            JPanel buttons = new JPanel(new GridBagLayout());
            JButton button1 = new JButton("Dodaj studenta");buttons.add(button1, gbc);
            button1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskDodajStudenta();
                }
            });
            JButton button1_1 = new JButton("Dodaj pracownika administracji");buttons.add(button1_1, gbc);
            button1_1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskDodajPracownikaAdministracji();
                }
            });
            JButton button1_2 = new JButton("Dodaj pracownika badawczo-dydaktycznego");buttons.add(button1_2, gbc);
            button1_2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskDodajPracownikaBD();
                }
            });
            JButton button2 = new JButton("Dodaj kurs");buttons.add(button2, gbc);
            button2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskDodajKurs();
                }
            });
            JButton button3 = new JButton("Wyszukaj pracownika");buttons.add(button3, gbc);
            button3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskWyszukajPracownikow();
                }
            });
            JButton button4 = new JButton("Wyszukaj studenta");buttons.add(button4, gbc);
            button4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskWyszukajStudentow();
                }
            });
            JButton button5 = new JButton("Wyszukaj kurs");buttons.add(button5, gbc);
            button5.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskWyszukajKursy();
                }
            });
            JButton button6 = new JButton("Wy??wietl wszystkich pracownik??w");buttons.add(button6, gbc);
            button6.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskWyswietlPracownikow();
                }
            });
            JButton button7 = new JButton("Wy??wietl wszystkich student??w");buttons.add(button7, gbc);
            button7.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskWyswietlStudentow();
                }
            });
            JButton button8 = new JButton("Wy??wietl wszystkie kursy");buttons.add(button8, gbc);
            button8.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskWyswietlKursy();
                }
            });
            JButton button9 = new JButton("Sortuj list?? os??b");buttons.add(button9, gbc);
            button9.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskSortujOsoby();
                }
            });
            JButton button10 = new JButton("Sortuj list?? kurs??w");buttons.add(button10, gbc);
            button10.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Main.setKursy(Funkcje.sortujKursy(Main.getKursy()));
                    new PrzyciskKontynuuj("Pomy??lnie posortowano list?? kurs??w.");
                }
            });
            JButton button11 = new JButton("Usu?? pracownik??w");buttons.add(button11, gbc);
            button11.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskUsunPracownika();
                }
            });
            JButton button12 = new JButton("Usu?? student??w");buttons.add(button12, gbc);
            button12.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskUsunStudenta();
                }
            });
            JButton button13 = new JButton("Usu?? kursy");buttons.add(button13, gbc);
            button13.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskUsunKurs();
                }
            });
            JButton button14 = new JButton("Wyczy???? list?? student??w");buttons.add(button14, gbc);
            button14.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskCzyszczenie();
                }
            });
            JButton button15 = new JButton("Dodaj og??oszenie");buttons.add(button15, gbc);
            button15.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new PrzyciskOgloszenie();
                }
            });
            JButton button16 = new JButton("Usu?? duplikaty");buttons.add(button16, gbc);
            button16.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Main.setOsoby(Funkcje.usunDuplikaty(Main.getOsoby()));
                    new PrzyciskKontynuuj("Pomy??lnie usuni??to duplikaty z listy os??b.");
                }
            });
            JButton button0 = new JButton("Zako??cz i zapisz");buttons.add(button0, gbc);
            //serializacja i zamkni??cie
            button0.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("osoby.txt"));
                        oos.writeObject(Main.getOsoby());
                        oos = new ObjectOutputStream(new FileOutputStream("kursy.txt"));
                        oos.writeObject(Main.getKursy());
                        oos.close();
                    }catch(IOException ioe){
                        ioe.printStackTrace();
                    }
                    frame.dispose();
                }
            });

            gbc.weighty = 1;
            add(buttons, gbc);
        }
    }
}
