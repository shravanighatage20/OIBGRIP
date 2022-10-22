import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*; 
/*<html>
<applet code = GuessNum.class height = 100 width = 500>
</applet>
</html>*/
public class GuessNum extends Applet implements ActionListener
{
	Panel p;
	Label l1,l2;
	TextField t1,t2,t3;
	Button b1;
	GridLayout g1;
	int ans,guess,i=0;
	final int MAX = 100;			//range 1-100
	Random rd = new Random();
	boolean value = false;
	public void init()
	{
		p = new Panel();
		g1 = new GridLayout(3,2);
		p.setLayout(g1);
		l1 = new Label("Guess the number");
		l2 = new Label("Range 1-100");
		t1 = new TextField(10);
		t2 = new TextField(10);
		t3 = new TextField(30);
		b1 = new Button("Check");
		p.add(l1);
		p.add(l2);
		p.add(b1);
		p.add(t1);
		p.add(t2);
		p.add(t3);
		b1.addActionListener(this);
		add(p);
		ans = rd.nextInt(MAX);
	}
	public void actionPerformed(ActionEvent ae)
	{
		guess = Integer.parseInt(t1.getText());
		i++;
		if(guess<ans)
			t3.setText("Entered number is smaller than actual number");
		else if(guess>ans)
			t3.setText("Entered number is larger than actual number");
		else
		{
			t3.setText("Correct guess!");
			value = true;
		}
		if(value == true)
		{
			t1.setText(String.valueOf(guess));
			t2.setText("");
		}
		if(i<10 && value==false)
			t2.setText("Attempt:"+String.valueOf(i));
		if(i>=10)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("You have exceeded number of tries!");
		}
	}
}