package gamerole;

import java.awt.Color;
import java.awt.Font;

import com.GameTool;
import item.ItemBase;
import item.Rect;

public class BlockPause  {
	public int x=330;// Model, View, Control
	public int y=460; // M: 按钮图片的位置，两张图，暂停，继续
	public int w=100;
	public int h=50;
	
	public int state;	// M: 状态，状态集合
	public static int STATE_PAUSE=1;
	public static int STATE_PLAY=0;
	
	public void init()
	{
		state=0;	//初始化
	}
	public void update(int s)
	{
		state=1;	//设置为暂停状态
	}
	public void paint ()
	{
		if(state ==0)	//不同状态下，显示不同的按钮图片  
			GameTool.res.paintOne(x, y, w, h, GameTool.RES_PAUSE);
		else
			GameTool.res.paintOne(x, y, w, h, GameTool.RES_PLAY);
	 }
	//鼠标事件，改变状态
	public void mouseClicked(int mousex, int mousey)
	{
		Rect button=new Rect(x, y, w, h);
		if( button.pointInRect(mousex, mousey)==1 )
		{
			state=1-state;	//用户点了暂停按钮，状态改变 0,1
		}
	}
}
