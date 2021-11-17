package View;

import javax.swing.*;

public class Barbeiro extends JLabel {


    public Barbeiro() {
        this.setHorizontalAlignment(JLabel.CENTER);
        this.dormir();
    }
    public void acordar(){
        ImageIcon img = new ImageIcon(Cliente.class.getResource("/barbeiroacordado.png"));
        this.setIcon(img);
    }
    public void dormir(){
        ImageIcon img = new ImageIcon(Cliente.class.getResource("/barbeirodormindo.png"));
        this.setIcon(img);
    }
}
