package View;

import DynamicLayout.DynamicLayout;

import javax.swing.*;
import java.awt.*;


public class Barbearia {


    private JFrame window;
    private JPanel background;



    public Barbearia( ) {


        this.window = new JFrame("Barbearia");
        this.initWindow();
        this.addPainel();
        this.window.setVisible(true);

    }

    private void initWindow(){
        Container div = this.window.getContentPane();
        div.setBackground(new Color(179, 179, 179));
        this.window.setSize(900,500);
        this.window.setLayout(new DynamicLayout(900,500));
        this.window.setResizable(true);
        this.window.setMinimumSize(new Dimension(650,350));
        this.window.setLocationRelativeTo(null);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addPainel(){
        this.background = new Background();
        this.background.setBounds(0,0,900,500);
        this.background.setLayout(new DynamicLayout(900,500));
        this.window.add(background);
    }

    public JFrame getWindow() {
        return window;
    }

    public JPanel getBackground() {
        return background;
    }
}
