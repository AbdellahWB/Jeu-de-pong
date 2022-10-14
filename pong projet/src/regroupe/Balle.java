package regroupe;

import java.awt.Graphics;
import java.awt.Color;



public class Balle {
    public int x_pos , y_pos ;
    public int reset;

    private final int ball_diam;

    private int x_velocity = 6, y_velocity = -6;
    private int reverse_dir = x_velocity;

    public int equipe2 = 0;
    public int equipe1 = 0;

    public Balle(int x_pos, int y_pos, int ball_diam){
        this.x_pos=x_pos;
        this.y_pos=y_pos;
        this.ball_diam=ball_diam;
        this.reset=x_pos;
    }




    public void update() {
        // update ball's position
        x_pos += x_velocity;
        y_pos += y_velocity;

        if (x_pos + ball_diam > Pong.WINDOW_WIDTH - 7) {


            equipe1 = equipe1 + 1;



            x_pos = reset;
            x_velocity = -reverse_dir;
        }
        if (x_pos < 0) {

            equipe2 = equipe2 + 1;


            x_pos = reset;

            x_velocity = reverse_dir;
        }

        if (y_pos + ball_diam > Pong.WINDOW_HEIGHT - 33) {
            y_velocity = -reverse_dir;
        }

        if (y_pos < 0) {
            y_velocity = reverse_dir;
        }
    }

    public void paint(Graphics g,int i) {

        if (i==1) {
            g.setColor(Color.yellow);
            g.fillOval(x_pos, y_pos, ball_diam, ball_diam);
        }

        if (i==2) {
            g.setColor(Color.pink);
            g.fillOval(x_pos, y_pos, ball_diam, ball_diam);
        }
    }

    /************************************** recupere x, y, width and height*************************/

    public int getX()
    {
        return x_pos;
    }
    public int getY()
    {
        return y_pos;
    }


    private void reverseDirection()
    {
        x_velocity = -x_velocity;
    }

    public void collisionDetection(joueur joueur)
    {
        if(this.x_pos > joueur.getX() && this.x_pos < joueur.getX() + joueur.getWidth() )
        {
            if(this.y_pos > joueur.getY() && this.y_pos < joueur.getY() + joueur.getHeight())
            {
                reverseDirection();
            }
        }
    }





    }


