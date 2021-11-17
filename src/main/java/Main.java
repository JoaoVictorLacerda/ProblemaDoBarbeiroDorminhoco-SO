import Controller.WindowController;
import View.Barbearia;
import View.Cliente;

import javax.swing.*;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
//        BarbeariaEx barbearia = new BarbeariaEx(5);
//        barbearia.acordarBarbeiro();
//
//        Thread cliente1 = new Thread(()->{
//
//           Cliente c = new Cliente(1);
//           barbearia.sentar(c);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            barbearia.cortar();
//            //barbearia.sairDaBarbearia(c);
//        });
//        Thread cliente2 = new Thread(()->{
//            Cliente c = new Cliente(2);
//            barbearia.sentar(c);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            barbearia.cortar();
//            //barbearia.sairDaBarbearia(c);
//        });
//        Thread cliente3 = new Thread(()->{
//            Cliente c = new Cliente(3);
//            barbearia.sentar(c);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            barbearia.cortar();
//            //barbearia.sairDaBarbearia(c);
//        });
//        Thread cliente4 = new Thread(()->{
//            Cliente c = new Cliente(4);
//            barbearia.sentar(c);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            barbearia.cortar();
//            //barbearia.sairDaBarbearia(c);
//        });
//        Thread cliente5 = new Thread(()->{
//            Cliente c = new Cliente(5);
//            barbearia.sentar(c);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            barbearia.cortar();
//            //barbearia.sairDaBarbearia(c);
//        });
//        Thread cliente6 = new Thread(()->{
//            Cliente c = new Cliente(6);
//            barbearia.sentar(c);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            barbearia.cortar();
//            //barbearia.sairDaBarbearia(c);
//        });
//
//        barbearia.addClientes(cliente1);
//        barbearia.addClientes(cliente2);
//        barbearia.addClientes(cliente3);
//        barbearia.addClientes(cliente4);
//        barbearia.addClientes(cliente5);
//        barbearia.addClientes(cliente6);
//
//        barbearia.initAllThreds();
        view();
    }

    public static void view(){
        Barbearia barbearia = new Barbearia();

        WindowController controller = new WindowController(
                barbearia.getBackground(), barbearia.getWindow());

        Random random = new Random();

            JOptionPane.showMessageDialog(barbearia.getWindow(),"Iniciar");
            int qtd=random.nextInt(20);
            System.out.println(qtd);
            for (int i = 0; i < qtd; i++) {
                Cliente c = new Cliente(String.valueOf(i));
                Thread cliente = new Thread(()->{
                    controller.sentar(c);
                    controller.waitThread(1000);
                    controller.cortar();
                });
                controller.addClientes(cliente);
            }

            controller.initAllThreds();




    }

}
