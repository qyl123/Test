package com;


import javax.swing.JFrame;


public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("java game") ;
		
		/*�����嵽������*/
		MyPanel panel = new MyPanel( ) ;
		frame.add(panel) ;
		
		/*����������¼�*/
		panel.addMouseMotionListener(panel) ;
		panel.addMouseListener(panel);
		/*��Ӽ��̼����¼�*/
		frame.addKeyListener(panel) ;// ����Ҫ����frame��
 		
		/*����߳�*/
		Thread th = new Thread(panel) ;
		th.start() ;
		
		frame.setSize(GameTool.bgX,  GameTool.bgY+30) ;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;		
		frame.setVisible(true) ;
		frame.setResizable(false) ; 
		
	}

}
