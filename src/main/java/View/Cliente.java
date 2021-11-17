package View;

import javax.swing.*;

public class Cliente extends JLabel {




    public Cliente(String num) {

        this.setText(num);

        ImageIcon img = new ImageIcon(Cliente.class.getResource("/cliente60px.png"));
        this.setIcon(img);
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    public Cliente prototypeClient(){
        return this;
    }
}
