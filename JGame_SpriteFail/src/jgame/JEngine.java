package jgame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JEngine extends JPanel implements KeyListener {
    private int[] Size = new int[2];
    private JGrid grid;
    private JPlayer player;
    public JEngine(int width, int height){
        JFrame frame = new JFrame("JGrid");
        frame.setSize(width+6, height+25);
        frame.setLocationRelativeTo(null);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);//desabilita maximizar janela
        frame.add(this); // adiciona o JPanel na janela
        
        this.setBackground( Color.white ); // muda cor de fundo do JPanel
        this.addKeyListener(this); // registra o JPanel na lista de eventos a serem repassados
        setFocusable(true); // permite o JPanel receber o os eventos

        this.player = new JPlayer(frame);
        frame.setVisible(true);
        
        Size[0] = this.getWidth();
        Size[1] = this.getHeight();
        
        this.grid = new JGrid(25,25, Size);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        grid.Draw(g2d);
        player.draw(g2d);

    }
    /*
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
    */
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                player.teste1();
                System.out.println("esquerda");
            }

            if (key == KeyEvent.VK_RIGHT) {
                player.teste2();
                System.out.println("direita");
            }

            if (key == KeyEvent.VK_UP) {
                System.out.println("cima");
            }

            if (key == KeyEvent.VK_DOWN) {
                System.out.println("baixo");
            }

    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    
    
}
