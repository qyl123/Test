package gamerole;

import java.awt.Color;
import java.awt.Font;

import com.GameTool;
import item.ItemBase;

public class GameMap  {
	public int [][] map=new int [20][10]; //��ά�����ʼ��Ϊ0
	
	public int [][] map1707=new int [][]
			{
			{1,0,1,1,0,0,1,0,1,1},
			{1,0,0,1,0,1,0,1,0,1},
			{1,0,0,1,0,1,0,1,0,1},
			{1,0,0,1,0,1,0,1,0,1},
			{1,0,0,1,0,0,1,0,0,1}
			};
	
	public int score=0;
	
	public BlockNext blockNext=new BlockNext();
	public BlockScore blockScore=new BlockScore();
	public BlockPause  blockPause=new BlockPause();

	public Block activeblock=new Block(blockNext);
	public BlockMove blockMove=new BlockMove(activeblock ,map );
	
	public GameMap() {
		System.out.println("== GameMap");
		init();
		
		for(int i=0; i<5;i++)
			for(int j=0; j<10;j++)
		{
			map[13+i][j]= map1707[i][j];
		}
	}

	public void init()
	{
		/* ��ʼ��*/
		activeblock.init();
		blockNext.init();
	}
	
	public void update()
	{
		if(GameTool.state == GameTool.STATE_OVER)
			return;
		//��ͣ״̬����ˢ������
		if(blockPause.state == BlockPause.STATE_PAUSE)
			return;
		
		//1.�ƶ�
		blockMove.vMove();
		//2.��
		findFull();
		//3.�����¿�
		activeblock.update();
	}
	public void paint()
	{
		paintMap();//���Ѿ��źõķ���
		activeblock.paint();
		blockNext.paint(); //����һ�εĿ�
		
		blockScore.paint();
		blockPause.paint();//����ͣ��ť����ͣ������
	}
	public void keyPressed(int key)
	{
		//��ͣ״̬�������ռ����¼�
		if(blockPause.state == BlockPause.STATE_PAUSE)
					return;
				
		 switch(key){
	        case 38: //up
	        	blockMove.rotate();
	            break;
	        case 40: //down
	        	blockMove.vMove();
	        	blockMove.vMove();
	            break;
	        case 37: //left
	        	blockMove.hMove(-1);
	            break;
	        case 39: //right
	        	blockMove.hMove(1);
	            break;}
		
	}
	public void paintMap()
	{
		int w,h;
		w=h=GameTool.STAGE_GRID;
		
		int drawx,drawy;
		for(int i=0;i<20;i++)
			for(int col=0; col<10; col++)
		{
			if( map [i][col] == 1)
				GameTool.res.paintOne( col*w, i*w, w, h, GameTool.RES_FIXED_BLOCK);
			
		}
	}
	
	public void removeLine(int line)
	{
		for(int l=line;l>0;l--)
			for(int j=0;j<10;j++)
			{
				if(l-1>=0)
					map[l][j] =map[l-1][j] ;
			}
	}
	
	public void findFull()
	{
		int linesNum=0;
		   for(int i=0;i<20;i++)
		   {
             int s=0;
             for(int j=0;j<10;j++){
                 s+= map[i][j]; 
             }
             if(s== 10){
                 removeLine(i);
                 linesNum++;	//ͬʱ��������
             }
		   }
		   
		blockScore.update(linesNum);
        //System.out.println("player score "+score);
	}
	public void mouseClicked(int mousex, int mousey)
	{
		//��ͣ״̬�£�����¼�ҲҪ���գ��û������ť��������Ϸ
		blockPause.mouseClicked(  mousex,   mousey);
	}
}
 