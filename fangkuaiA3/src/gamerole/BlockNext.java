package gamerole;

import java.awt.Color;
import java.awt.Font;

import com.GameTool;
import item.ItemBase;

public class BlockNext  {

	public int id=2;//L
	public int x=10;//屏幕右上角 (10*30,0) 画新块
	public int y=0;
	

	public int [][] shapes=new int [][]{
			{0,1,1,1,2,1,3,1},
			{1,0,1,1,1,2,2,2},
			{2,0,2,1,2,2,1,2},
			{0,1,1,1,1,2,2,2},
			{1,2,2,2,2,1,3,1},
			{1,1,2,1,1,2,2,2},
			{0,2,1,2,1,1,2,2}
		};
		
	 
		public int [] ar=new int[8];
		
	public BlockNext() {
		System.out.println("== Block Next");
	}

	public void setAr(int[] ar) {
		this.ar = ar;
	}
	public void init()
	{
		id=2;
		setAr(shapes[id]);
	}
	public void update()
	{
		id++;
		id=id%7;	//为了测试，下标依次为0到6，依次选择7种形状
		setAr(shapes[id]);
	}
	 
	
	public void paint ()
	{
	 
		int w,h;
		w=GameTool.STAGE_GRID;
		h=w;
		int drawx,drawy;
		for(int i=0;i<4;i++)
		{
			drawx=x+ ar[2*i];//右上角提示块
			drawy=y+ ar[2*i + 1];
			GameTool.res.paintOne(drawx*w+5 , drawy*w, w, h, GameTool.RES_ACTIVE_BLOCK);
			
		}
	 }
			
}
