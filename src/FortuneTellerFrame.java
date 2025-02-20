import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;


public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl, topPnl, middlePnl, bottomPnl;
    JLabel fortuneLbl;
    ImageIcon fortuneImg;
    JScrollPane fortuneScroller;
    JTextArea fortuneArea;
    JButton quitBtn, fortuneBtn;
    String fortunes[] = new String[15];
    int curFortuneDex = -1;
    Random rnd = new Random();

    public FortuneTellerFrame()
    {
        loadFortunes();
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);
        createTopPanel();
        createMiddlePanel();
        createBottomPanel();

        setTitle("Fortune Teller");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void loadFortunes()
    {
        fortunes[0] = "Your pet rock will learn to fetch";
        fortunes[1] = "You will become rich... oh wait, that was the last guy";
        fortunes[2] = "You will learn a great skill, when you start studying";
        fortunes[3] = "Your code will work... April fools!";
        fortunes[4] = "You will receive a great inheritance... of dirty socks";
        fortunes[5] = "Your dreams will come true...but only partially";
        fortunes[6] = "The fortune you seek... was given to the last guy";
        fortunes[7] = "Your lazy work will pay off";
        fortunes[8] = "Keep doing what your doing";
        fortunes[9] = "Huh? What? Sorry, I didn't see you there";
        fortunes[10] = "Your in laws will move in with you";
        fortunes[11] = "Your next paycheck will be in pennies";
        fortunes[12] = "You won't have enough change for your next laundry cycle";
        fortunes[13] = "You will succeed... eventually";
        fortunes[14] = "A great life lesson is coming... watch out";

    }

    public void createTopPanel()
    {
        topPnl = new JPanel();
        fortuneImg = new ImageIcon("src/FortuneTeller.jpg");
        fortuneLbl = new JLabel(fortuneImg);
        fortuneLbl.setText("Ask Me For Your Fortune");
        fortuneLbl.setHorizontalTextPosition(JLabel.CENTER);
        fortuneLbl.setVerticalTextPosition(JLabel.TOP);

        topPnl.add(fortuneLbl);
        mainPnl.add(topPnl, BorderLayout.NORTH);

    }

    public void createMiddlePanel()
    {
        middlePnl = new JPanel();
        fortuneArea = new JTextArea(15, 50);
        fortuneScroller = new JScrollPane(fortuneArea);
        middlePnl.add(fortuneScroller);

        mainPnl.add(middlePnl, BorderLayout.CENTER);
    }

    public void createBottomPanel()
    {
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1,2));
        fortuneBtn = new JButton("Read My Fortune");
        quitBtn = new JButton("Quit");

        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
            int newDex = curFortuneDex;
            do
            {
                newDex = rnd.nextInt(fortunes.length);
            }while(newDex == curFortuneDex);
            curFortuneDex = newDex;
            fortuneArea.append(fortunes[newDex]+ "\n");
        });
        bottomPnl.add(fortuneBtn);
        bottomPnl.add(quitBtn);
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

    }

}
