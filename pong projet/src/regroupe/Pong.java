package regroupe;

import javax.swing.JFrame;

public class Pong extends JFrame{

    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 600;


    public Pong()
    {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new Fenetrejeu());
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Pong();
    }

}
