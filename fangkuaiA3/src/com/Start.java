package com;


import javax.swing.JFrame;


public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("java game") ;
		
		/*添加面板到窗体中*/
		MyPanel panel = new MyPanel( ) ;
		frame.add(panel) ;
		
		/*添加鼠标监听事件*/
		panel.addMouseMotionListener(panel) ;
		panel.addMouseListener(panel);
		/*添加键盘监听事件*/
		frame.addKeyListener(panel) ;// 键盘要加在frame上
 		
		/*添加线程*/
		Thread th = new Thread(panel) ;
		th.start() ;
		
		frame.setSize(GameTool.bgX,  GameTool.bgY+30) ;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;		
		frame.setVisible(true) ;
		frame.setResizable(false) ; 
		
	}

}
