package com;

import gamerole.GameMap;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MyPanel extends JPanel implements Runnable,MouseMotionListener,KeyListener,MouseListener
{
	
	private static final long serialVersionUID = 1L;

	public GameMap gameMap=new GameMap();
	
	public MyPanel( ) {
		//初始化
		 GameTool.initRes();
	}
	
	
	/*游戏面板*/
	public void paint(Graphics g) {
		super.paint(g) ;//表示画之前先擦除上一次的痕迹（在paint()方法中第一行添加）
		GameTool.g=g;
		
		/*1  绘制背景*/
		GameTool.res.paintOne(0, 0,GameTool.bgX, GameTool.bgY, GameTool.RES_BACK);
		 
		gameMap.paint();
		
	}

	/*重写线程中的run()*/
	@Override
	public void run() {
		
		
		while(true) {
			GameTool.timeclip++ ;
			
			gameMap.update();

			try {
				/*控制运动速度*/
				Thread.sleep(500) ; // 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace() ;
			}
			
			/*重画*/ 
			repaint() ; //实现运动
		}
	}

	/*重写鼠标监听事件*/
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(" mouseDragged" +e.getX()+"," + e.getY() );
		//e.getX() e.getY()) 
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		//System.out.println( arg0.getKeyCode());
		//按键处理
		gameMap.keyPressed(arg0.getKeyCode());
		
		//按键后，重绘
		repaint() ;
	}
	@Override
	public void keyReleased(KeyEvent arg0) {

		//System.out.println( arg0.getKeyCode());
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println( arg0.getKeyCode());
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("mouseClicked"+ arg0.getX()+"," + arg0.getY());
		gameMap.mouseClicked(arg0.getX(), arg0.getY() );
		//鼠标事件后，重绘
		repaint() ;
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
