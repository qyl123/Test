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
		//��ʼ��
		 GameTool.initRes();
	}
	
	
	/*��Ϸ���*/
	public void paint(Graphics g) {
		super.paint(g) ;//��ʾ��֮ǰ�Ȳ�����һ�εĺۼ�����paint()�����е�һ����ӣ�
		GameTool.g=g;
		
		/*1  ���Ʊ���*/
		GameTool.res.paintOne(0, 0,GameTool.bgX, GameTool.bgY, GameTool.RES_BACK);
		 
		gameMap.paint();
		
	}

	/*��д�߳��е�run()*/
	@Override
	public void run() {
		
		
		while(true) {
			GameTool.timeclip++ ;
			
			gameMap.update();

			try {
				/*�����˶��ٶ�*/
				Thread.sleep(500) ; // 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace() ;
			}
			
			/*�ػ�*/ 
			repaint() ; //ʵ���˶�
		}
	}

	/*��д�������¼�*/
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
		//��������
		gameMap.keyPressed(arg0.getKeyCode());
		
		//�������ػ�
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
		//����¼����ػ�
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
