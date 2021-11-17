package Controller;



import View.Barbeiro;
import View.Cliente;

import javax.swing.*;
import java.util.ArrayList;

public class WindowController {
    private static int position[][] ={
            {100,330},
            {235, 330},
            {365, 330},
            {500, 330},
            {650, 330},
            {10, 100},
    };
    private boolean ocupacaoCadeiras[]={false,false,false,false,false};

    private JPanel background;
    private JFrame window;
    private Barbeiro barbeiro;
    private ArrayList<Thread> threads;
    private ArrayList<Cliente> cadeiras;
    private ArrayList<Cliente> clientesFora;
    private int qtdCadeiras;


    public WindowController(JPanel background, JFrame window) {
        this.barbeiro = new Barbeiro();
        this.threads = new ArrayList<Thread>();
        this.cadeiras = new ArrayList<Cliente>();
        this.clientesFora = new ArrayList<Cliente>();
        this.background = background;
        this.window = window;
        this.qtdCadeiras = 5;

        this.colocandoBarbeiro();

    }

    public void colocandoBarbeiro(){
        barbeiro.setBounds(260,30,150,150);
        this.background.add(barbeiro);
        this.atualizaWindow();
    }

    private int retornaCadeiraVazia(){

        if(!ocupacaoCadeiras[0]){
            return 0;
        }else if(!ocupacaoCadeiras[1]){
            return 1;
        }else if(!ocupacaoCadeiras[2]){
            return 2;
        }else if(!ocupacaoCadeiras[3]){
            return 3;
        }else if(!ocupacaoCadeiras[4]){
            return 4;
        }
        return -1;
    }

    public void initAllThreds(){
        threads.forEach(thread -> {
            thread.start();
        });
    }

    public void addClientes(Thread cliente){

        this.threads.add(cliente);
    }


    public synchronized void sentar(Cliente c){

        this.waitThread(500);


        if(qtdCadeiras != 0){
            int cadeiraDisponivel = this.retornaCadeiraVazia();
            this.ocupacaoCadeiras[cadeiraDisponivel] =true;
            cadeiras.add(c);
            c.setBounds(position[cadeiraDisponivel][0],position[cadeiraDisponivel][1],100,100);
            System.out.println("O cliente "+c.getText()+" sentou na cadeira "+ cadeiraDisponivel+ " e está aguardando\n");
            qtdCadeiras--;
        }else{
            c.setBounds(position[5][0],position[5][1],100,100);
            System.out.println("O cliente "+c.getText()+" não encontrou cadeira vaga, ele voltará mais tarde\n");
            clientesFora.add(c);
        }
        this.background.add(c);
        this.atualizaWindow();
    }

    public synchronized void cortar(){
        this.waitThread(1000);
        Cliente c = this.cadeiras.remove(0);
        int  x = c.getX();
        int y = c.getY();

        c.setBounds(380,45,100,100);
        this.background.add(c);
        barbeiro.acordar();
        this.atualizaWindow();
        System.out.println("O barbeiro está cortando o cabelo do cliente "+c.getText()+"\n");
        this.waitThread(1200);
        this.sair(c);
        if(clientesFora.size()!=0){
            sentar(clientesFora.remove(0));
        }
        if(cadeiras.size()==0 && clientesFora.size()==0){
            barbeiro.dormir();
            this.atualizaWindow();
        }
        System.out.println("O cliente "+ c.getText()+" saiu da barbearia\n");
    }

    private int cadeiraDaVez =0;
    public void sair(Cliente c ){

        this.background.remove(c);
        this.atualizaWindow();
        if(cadeiraDaVez ==5){
            cadeiraDaVez=0;
        }
        ocupacaoCadeiras[cadeiraDaVez]=false;
        cadeiraDaVez++;
        qtdCadeiras++;
        this.waitThread(300);
    }

    public void waitThread(long nanoTime ){
        try {
            Thread.sleep(nanoTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void atualizaWindow(){
        this.background.validate();
        this.background.repaint();
        this.window.validate();
        this.window.repaint();
    }
}
