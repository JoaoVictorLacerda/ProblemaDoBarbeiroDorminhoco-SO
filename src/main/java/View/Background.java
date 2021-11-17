package View;

import DynamicLayout.DynamicLayout;

import javax.swing.*;
import java.awt.*;




public class Background extends JPanel {
    private ImageIcon img;

    public Background(){
        img = new ImageIcon(Background.class.getResource("/barbearia.png"));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);

    }

    public void setImg(ImageIcon img){
        this.img = img;
    }

    public ImageIcon getImg(){
        return this.img;
    }

}

