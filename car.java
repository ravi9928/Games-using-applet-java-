import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;
public class car extends Applet implements MouseListener{
	int x,y,sa,p,q,p1,q1,p2,q2,q11,q22,f,t,flag,start,out;
	AudioClip au,finish;
	
	public void init(){
		x=300; 			//black strip x
		y=0;			//black strip y
		f=0; 			//apposite car flag
		flag=0;			//flag for click
		t=0;
		p1=310;			// up left car x
		q1=-140;		// up left car y
		p2=480;			// up right car x
		q2=-140;  		//up right car y
		sa=0;
		p=310;    		//down car's x
		q=450;			//down car's y
		q11=0;
		q22=0;
		start=1;
		out=0;
		
		addMouseListener(this);
	}
	public void mouseClicked(MouseEvent e){
		if(flag==0){
			p=p+170;
			flag=1;
		}
		else if(flag==1){
			p=p-170;
			flag=0;
		}
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	
	
	public void paint(Graphics m){
		m.fillRect(x,y,300,600);
		m.setColor(Color.white);
		Image forest=getImage(getCodeBase(),"project/forest.jpg");
		m.drawImage(forest,0,0,300,600,this);
		m.drawImage(forest,600,0,300,600,this);
		
		m.fillRect(435,sa-600,30,50);
		m.fillRect(435,sa-500,30,50);
		m.fillRect(435,sa-400,30,50);
		m.fillRect(435,sa-300,30,50);
		m.fillRect(435,sa-200,30,50);
		m.fillRect(435,sa-100,30,50);
		m.fillRect(435,sa,30,50);
		m.fillRect(435,sa+100,30,50);
		m.fillRect(435,sa+200,30,50);
		m.fillRect(435,sa+300,30,50);
		m.fillRect(435,sa+400,30,50);
		m.fillRect(435,sa+500,30,50);
		
		Image car=getImage(getCodeBase(),"project/car3.png");
		m.drawImage(car,p,q,100,150,this);
		Image car1=getImage(getCodeBase(),"project/car2.png");
		m.drawImage(car1,p1,q1,100,150,this);
		Image car2=getImage(getCodeBase(),"project/car4.jpg");
		m.drawImage(car2,p2,q2,100,150,this);
	
		au=getAudioClip(getCodeBase(),"project/au1.wav");
		finish=getAudioClip(getCodeBase(),"project/over.wav");
		
		if(start==1){
			sa=sa+2;
			q1++;
			if(sa==600){
				sa=sa-600;
			}
			
			q1++;                             
			if(q1==600){
				f=1;
				q2=-140;
			}
			if(q2==600){
				q1=-140;
			}
			if(f==1){
				t=1;
			}	
			if(t==1){
				q2++;
			}	
			q11=q1+150;
			q22=q2+150;
			if((q11==q && p==310) || (q22==q && p==480)){
				System.out.println("over");
				start=0;
				out=1;
				flag=2;     //click will not work from this
			}
			
			try{
				Thread.sleep(10);
			}
			catch(InterruptedException e){}
			repaint();
		}
		else if(out==1 && start==0){
				Image over=getImage(getCodeBase(),"project/over.jpg");
				m.drawImage(over,300,0,300,300,this);
				Image blast=getImage(getCodeBase(),"project/blast.gif");
				m.drawImage(blast,p,q-70,100,100,this);
				au.play();
		}
	}
}
		
		
		
		
		
//<applet code="car" width="900" height="600"></applet>		