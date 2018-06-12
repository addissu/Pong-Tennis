package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle{

	double y, yVel;
	boolean upAccel, downAccel;
	final double GRAVITY=0.94;
	int player, x;
	
	public HumanPaddle(int player) {
		upAccel = false; downAccel = false;
		y=210; yVel =0;
		
		if(player == 1) {
			x=20;
		}else 
			x=660;
	}
	//draws paddle
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, (int)y, 20, 80);
		
	}

	
	public void move() {
		
		if(upAccel) {
			yVel -= 2;
		}else if(downAccel) {
			yVel +=2;
		}else if(!upAccel && !downAccel) {
			//gravity coefficent 
			yVel *= GRAVITY;
		}
		//controls the speed of the paddle
		if(yVel >=5) {
			yVel=5;
		} else if(yVel<=-5) {
			yVel=-5;
		}
		
		
		
		y+= yVel;
		//so paddle wont go above applet 
		if(y<0) {
			y=0;
		}//so paddle wont go below applet 
		if(y>420) {
			y=420;
		}
	}
	
	public void setUpAccel(boolean input) {
		upAccel=input;
	}
	
	public void setDownAccel(boolean input) {
		downAccel = input;
	}

	
	public int getY() {
		
		
		return (int)y;
	}

}
