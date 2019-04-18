package com;

import item.ItemArrayBase;
import item.ItemBase;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class GameTool {
	/*声明背景边界*/
	public static int bgX  = 460;
	public static int bgY  = 600;
	
	public static int STAGE_GRID=30;
	
	public static MyPanel panel;	
	public static Graphics g;
	
	//时间片
	public static int timeclip = 0 ;
	
	public static int  STATE_PLAY=0;	
	public static int  STATE_OVER=1;	
	public static int  state=0;	
	
	public static ItemArrayBase res=new ItemArrayBase();
	
	
	public static int   RES_BACK=0;//资源的第0个图片，背景图片
	public static int   RES_FIXED_BLOCK=1;//资源的第0个图片，背景图片
	public static int   RES_ACTIVE_BLOCK=2;//资源的第0个图片，背景图片
	public static int   RES_PAUSE=3;//资源的第0个图片，背景图片
	public static int   RES_PLAY=4;//资源的第0个图片，背景图片
	
	public static void initRes()
	{
		// res x y r: 0 0 0 
		res.newOneItem(0, 0, 0, "img\\back1.png");
		res.newOneItem(0, 0, 0, "img\\t1.png");
		res.newOneItem(0, 0, 0, "img\\t2.png");
		res.newOneItem(0, 0, 0, "img\\pause.png");
		res.newOneItem(0, 0, 0, "img\\play.png");
	}
}
