package regroupe;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.awt.event.KeyEvent;

/** communication balle et raquette*/

public class Fenetrejeu extends JPanel implements ActionListener, KeyListener {

    Balle balle1 = new Balle(Pong.WINDOW_WIDTH / 2,Pong.WINDOW_HEIGHT / 2,20);
    Balle balle2 = new Balle(Pong.WINDOW_WIDTH / 2,Pong.WINDOW_HEIGHT+20 / 2,20);
    joueur joueur = new joueur(20,100);
    joueur joueur2 = new joueur(200,100);
    joueur joueur3 = new joueur(Pong.WINDOW_WIDTH-200,300);
    joueur joueur4 = new joueur(Pong.WINDOW_WIDTH-50,300);


    public Fenetrejeu()
    {
        //temps en mille seconde actualisation
        Timer timer = new Timer(20,this);
        timer.start();

        this.addKeyListener(this);
        this.setFocusable(true);
    }

    /*****************************actualisations des classes dans la fenêtre de jeu********************************/
    public void update()
    {
        joueur.update();
        joueur2.update();

        joueur3.update();
        joueur4.update();

        balle1.update();
        balle2.update();


        balle1.collisionDetection(joueur);
        balle1.collisionDetection(joueur2);
        balle1.collisionDetection(joueur3);
        balle1.collisionDetection(joueur4);

        balle2.collisionDetection(joueur);
        balle2.collisionDetection(joueur2);
        balle2.collisionDetection(joueur3);
        balle2.collisionDetection(joueur4);



    }



    /***************l'écouteur d'action et appelle la méthode update*******************/
    public void actionPerformed(ActionEvent e)
    {
        update();
        repaint();


    }

    public void paintComponent(Graphics g)
    {

        g.setColor(Color.BLACK);

        //fenêtre de jeux
        g.fillRect(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT);
        balle2.paint(g,2);
        balle1.paint(g,1);
        joueur.paint(g,1);
        joueur2.paint(g,2);
        joueur3.paint(g,3);
        joueur4.paint(g,4);


        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.PLAIN, 10));
        g.drawString("projet L2 abdellah", 5,Pong.WINDOW_HEIGHT-580);

        g.setColor(Color.GREEN);
        g.setFont(new Font("arial", Font.PLAIN, 10));
        g.drawString("Joueur 1 : Z : UP , S : DOWN ", 25,Pong.WINDOW_HEIGHT-50);
        g.setColor(Color.RED);
        g.setFont(new Font("arial", Font.PLAIN, 10));
        g.drawString("Joueur 2 : Y : UP , H : DOWN ", 340,Pong.WINDOW_HEIGHT-50);
        g.setColor(Color.BLUE);
        g.setFont(new Font("arial", Font.PLAIN, 10));
        g.drawString("Joueur 3 : ↑ : UP , ↓ : DOWN ", 530,Pong.WINDOW_HEIGHT-50);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("arial", Font.PLAIN, 10));
        g.drawString("Joueur 4 : P : UP , M : DOWN ", 830,Pong.WINDOW_HEIGHT-50);


        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.BOLD, 20));
        g.drawString("équipe A: "  + (balle1.equipe1+balle2.equipe1), Pong.WINDOW_WIDTH/4,20);


        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.BOLD, 20));
        g.drawString("équipe B: "  + (balle1.equipe2+balle2.equipe2), (Pong.WINDOW_WIDTH/2)+(Pong.WINDOW_WIDTH/4),20);

        //build a court
        g.setColor(Color.blue);
        g.drawLine(0, 30 , Pong.WINDOW_WIDTH, 30);
        g.drawLine(Pong.WINDOW_WIDTH/2, 30 , Pong.WINDOW_WIDTH/2, Pong.WINDOW_HEIGHT);
        g.drawOval(Pong.WINDOW_WIDTH/2 - 50, Pong.WINDOW_HEIGHT/2 -50, 100, 100);
    }

    /******************************************commandes joueurs*********************************************/
    public void keyPressed(KeyEvent k)
    {
        int keyCode = k.getKeyCode();
        //go up when up arrow is pressed
        if(keyCode == KeyEvent.VK_Z)
        {
            joueur.setYVelocity(-15);

        }
        if(keyCode == KeyEvent.VK_Y)
        {

            joueur2.setYVelocity(-15);
        }
        if(keyCode == KeyEvent.VK_H)
        {

            joueur2.setYVelocity(15);
        }

        if(keyCode == KeyEvent.VK_S)
        {
            joueur.setYVelocity(15);

        }


        if(keyCode == KeyEvent.VK_UP)
        {
            joueur3.setYVelocity(-15);

        }
        if(keyCode == KeyEvent.VK_P)
        {

            joueur4.setYVelocity(-15);
        }
        if(keyCode == KeyEvent.VK_DOWN)
        {

            joueur3.setYVelocity(15);
        }

        else if(keyCode == KeyEvent.VK_M)
        {
            joueur4.setYVelocity(15);

        }




    }

    public void keyReleased(KeyEvent k)
    {
        int keyCode = k.getKeyCode();

        if(keyCode == KeyEvent.VK_Z)
        {
            joueur.setYVelocity(0);

        }
        if(keyCode == KeyEvent.VK_Y)
        {

            joueur2.setYVelocity(0);
        }
        if(keyCode == KeyEvent.VK_H)
        {

            joueur2.setYVelocity(0);
        }

        if(keyCode == KeyEvent.VK_S)
        {
            joueur.setYVelocity(0);

        }


        if(keyCode == KeyEvent.VK_UP)
        {
            joueur3.setYVelocity(0);

        }
        if(keyCode == KeyEvent.VK_P)
        {

            joueur4.setYVelocity(0);
        }
        if(keyCode == KeyEvent.VK_DOWN)
        {

            joueur3.setYVelocity(0);
        }

        else if(keyCode == KeyEvent.VK_M)
        {
            joueur4.setYVelocity(0);

        }
    }

    public void  keyTyped(KeyEvent k)
    {

    }


}