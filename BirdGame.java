import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;
public class BirdGame extends Applet implements MouseListener,ActionListener{
	int by,bx,t1,t2,scr,bflag,kill,over,start;
	Button b;
	AudioClip au,finish;
	public void init(){
		start=0;
		over=0;			//game over flag
		bflag=0; 
		scr=0; 			//score
		kill=0; 		//bird kill(click on bird)
		bx=100; 		//bird x
		by=300; 		//bird y
		
		b=new Button("Start Game");
		add(b);
		b.addActionListener(this);
		addMouseListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b){
			start=1;
			au.loop();
			repaint();
		}
	}
	
	public void mouseClicked(MouseEvent e){
		if(e.getX()<t1 && e.getY()<t2 && e.getX()>bx && e.getY()>by){
				kill=1;
				scr=scr+5;
		}
	}
	public void mousePressed(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	
	
	public void paint(Graphics g){
		au=getAudioClip(getCodeBase(),"project/au22.wav");
		finish=getAudioClip(getCodeBase(),"project/gameover.wav");
		
		Image bird=getImage(getCodeBase(),"project/bird.gif");
		g.drawImage(bird,bx,by,150,150,this);
		Image img=getImage(getCodeBase(),"project/garden.jpg");
		g.drawImage(img,0,300,800,200,this);
		
		g.setFont(new Font("TimesRoman", Font.BOLD, 30)); 
		g.drawString("Score="+scr,10,40);
		g.setColor(Color.BLUE);
		
		if(start==1){
			by=by-1;
			t1=bx+130;
			t2=by+130;
			
			if(kill==1){
				by=300;
				bflag=1;
				kill=0;
			}
			if(by==-120){
				over=1;
			}
			if(over==1){
				start=0;
				finish.play();
				au.stop();
			}
			
			if(bflag==1){
			Random r=new Random();
			bx=(Math.abs(r.nextInt())%700);
			//System.out.println(bx);
			bflag=0;
			}
			
			try{
				Thread.sleep(10);
			}
			catch(InterruptedException e){}
		}
		else if(start==0 && over==1){
			Image ovr=getImage(getCodeBase(),"project/over.gif");
			g.drawImage(ovr,50,40,400,400,this);
			g.drawString("Score="+scr,200,100);
		}
		repaint();
	}

}

//<applet code="BirdGame" width=800 height=500></applet>