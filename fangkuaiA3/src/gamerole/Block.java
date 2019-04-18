package gamerole;

import java.awt.Color;
import java.awt.Font;

import com.GameTool;
import item.ItemBase;

public class Block  {
	public int x=0;
	public int y=0;
	
	//7种形状
	//line 
	// L
	// 左L
	// z
	// 右z
	// square
	// T
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
	public static int ACTIVEBLOCK_PLAY=0;
	public static int ACTIVEBLOCK_FINISH=1;

	public int id=0;

	public int state=0;
	
	public BlockNext next;
	
	public Block(BlockNext next) {
		System.out.println("== Block");
		this.next = next;
	}

	public void setAr(int[] ar) {
		this.ar = ar;
	}
	public void init()
	{
		id=1;//L
		x=0;
		y=0;
		setAr(shapes[id]);
		state= Block.ACTIVEBLOCK_PLAY;
 
	}
	public void update()
	{
		//旧块不能移动，产出新块
		if(state == Block.ACTIVEBLOCK_FINISH)
		{
			 
			x=0;
			y=0;
			setAr(shapes[ next.id]);
			next.update();//产生新的块
			state= Block.ACTIVEBLOCK_PLAY;
		}		
	}
	public void finish()
	{
		state= Block.ACTIVEBLOCK_FINISH;
		
	}
	
	public void paint ()
	{
		if(state == Block.ACTIVEBLOCK_FINISH)
			return;
		
		int w,h;
		w=GameTool.STAGE_GRID;
		h=w;
		int drawx,drawy;
		for(int i=0;i<4;i++)
		{
			drawx=x+ ar[2*i];
			drawy=y+ ar[2*i + 1];
			GameTool.res.paintOne(drawx*w , drawy*w, w, h, GameTool.RES_ACTIVE_BLOCK);
			
		}
	 }
			
}
