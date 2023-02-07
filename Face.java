import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Face extends Applet implements MouseListener,ActionListener{
	int r1x,r1y,r2x,r2y,toung;
	Button b;
	AudioClip au;
	public void init(){
		toung=0;
		r1x=175;
		r1y=180;
		r2x=375;
		r2y=180;
		
		b=new Button("Reset");
		add(b);
		b.addActionListener(this);
		addMouseListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b){
			r1x=175;
			r1y=180;
			r2x=375;
			r2y=180;
			toung=0;
		}
		repaint();
	}
	
	public void mouseClicked(MouseEvent e){
		toung=1;
		
		//up left corner
		if(e.getX()<150 && e.getY()<150){
			r1x-=20;
			r1y-=20;
			r2x-=20;
			r2y-=20;
		}
		//up center
		if(e.getX()>=150 && e.getX()<550 && e.getY()<150){
			r1y-=40;
			r2y-=40;
		}
		//up right corner
		if(e.getX()>=550 && e.getX()<700 && e.getY()<=150){
			r1x+=15;
			r1y-=20;
			r2x+=15;
			r2y-=20;
		}
		//left center
		if(e.getX()<=150 && e.getY()>150 && e.getY()<=550){
			r1x-=15;
			r2x-=15;
		}
		//right center
		if(e.getX()>550 && e.getY()>150 && e.getY()<550){
			r1x+=20;
			r2x+=20;
		}
		
		
		//right down corner
		if(e.getX()>550 && e.getY()>550){
			r1x+=15;
			r1y+=20;
			r2x+=15;
			r2y+=20;
		}
		//down center
		if(e.getX()>=150 && e.getX()<550 && e.getY()>550){
			r2y+=40;
			r1y+=40;
		}
		//down left corner
		if(e.getX()<=150 && e.getY()>550 && e.getY()<700){
			r1x-=15;
			r1y+=20;
			r2x-=15;
			r2y+=20;
		}
		if(e.getX()>=150 && e.getX()<550 && e.getY()>150 && e.getY()<550){
			r1x+=15;
			r1y+=25;
			r2x-=15;
			r2y+=25;
			
		}
		repaint();
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	
	public void paint(Graphics g){
		
		au=getAudioClip(getCodeBase(),"project/balldrop.wav");
		
		g.setColor(Color.YELLOW);
		g.fillOval(50,50,500,550);
		
		g.setColor(Color.WHITE);
		g.fillOval(150,130,100,150);
		g.fillOval(350,130,100,150);
		
		g.setColor(Color.BLACK);
		g.fillOval(r1x,r1y,50,50);
		g.fillOval(r2x,r2y,50,50);
		
		g.setColor(Color.BLACK);
		g.fillOval(275,280,50,50);
		
		g.setColor(Color.BLACK);
		g.fillArc(200,340,200,150,180,180);
		
		if(toung==1){
			au.play();
			g.setColor(Color.RED);
			g.fillRect(230,420,140,200);
			
		}
		
		
	}
}


//<applet code="Face" width=700 height=700></applet>