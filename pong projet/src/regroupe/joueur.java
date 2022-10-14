package regroupe;

import java.awt.Color;
import java.awt.Graphics;

public class joueur
{
    public joueur(int x_pos, int y_pos){
        this.x_pos=x_pos;
        this.y_pos=y_pos;



    }


    public int width = 20, height = 80,x_pos , y_pos , y_velocity  = 0, reverse_dir = y_velocity;

    public void update()
    {
        y_pos += y_velocity;
    }

    public void paint(Graphics g,int i)
    {


        if (i==1) {
            g.setColor(Color.GREEN);
            g.fillRect(x_pos, y_pos, width, height);

        }

        if (i==2) {
            g.setColor(Color.red);
            g.fillRect(x_pos, y_pos, width, height);
        }

        if (i==3) {
            g.setColor(Color.blue);
            g.fillRect(x_pos, y_pos, width, height);
        }

        if (i==4) {
            g.setColor(Color.orange);
            g.fillRect(x_pos, y_pos, width, height);
        }

    }

    public void setYVelocity(int speed)
    {
        y_velocity = speed;
    }

    /**************************************recuperes  x, y, width and height*************************/
    public int getX()
    {
        return x_pos;
    }
    public int getY()
    {
        return y_pos;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }

}