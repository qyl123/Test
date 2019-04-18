package gamerole;

import java.awt.Color;
import java.awt.Font;

import com.GameTool;
import item.ItemBase;

public class BlockMove  {
	
	public Block block;
	public int [][] map;
	
	
	
	public BlockMove(Block block, int[][] map) {
		this.block = block;
		this.map = map;
	}

	//7����״
	//line 
	// L
	// ��L
	// z
	// ��z
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
	
	public int w=40;
	public int h=40;
 
	// ���������ײ��⣬�±����Ч�ԣ����ӵ�ȡֵ
	public String checkh(int [] activeAr, int x, int y,int step){
		int newx,n;
		 for(int i=0;i<8;i+=2){
				newx=x+activeAr[i]+ step;
				n=y+activeAr[i+1];
				if(newx<0 || newx>9 || map[n][newx]==1)
					return "not";					
			 }
			  return "ok";
	}
	
	public String checkv(int [] activeAr, int x, int y,int step){
		int m,n;
		 for(int i=0;i<8;i+=2){
				m=x+activeAr[i];
				n=y+activeAr[i+1];
				if(n==19 || map[n+step][m]==1)
					return "not";					
			 }
		// System.out.println("checkv ok");
			  return "ok";
	}
		
	public void fixShape(int [] activeAr, int x, int y ){
		int m,n;
		for(int i=0;i<8;i+=2){           
			m=x+activeAr[i];
			n=y+activeAr[i+1];
	          map[n][m]=1; //�з���ĸ��ӣ�����Ϊ1
		}
		System.out.println("fixShape ok");
	}
	
	public void  rotate()
	{
		// var newShape=[3-s[1],s[0],3-s[3],s[2],3-s[5],s[4],3-s[7],s[6]];
		int [] newShape=new int []
				{
					3-block.ar[1], block.ar[0],
					3-block.ar[3], block.ar[2],
					3-block.ar[5], block.ar[4],
					3-block.ar[7], block.ar[6]
				};
		 if( checkh(newShape,  block.x, block.y, 0)=="ok")
		 {
			 block.ar=newShape;
	     }   
	}
	
	public void hMove(int step){
		if( checkh(block.ar, block.x, block.y, step ).equals("ok") )
		{
			 block.x+= step;
		}
	}
	public void vMove(){
		// ��ֱ�����Ƿ�����ƶ�����һ������
		if( checkv(block.ar, block.x, block.y, 1 ).equals("ok") )
		{
			 block.y++;
		}
		else{
			//�����ƶ������浽��ͼ��ά����
			fixShape(block.ar, block.x, block.y );
			block.finish();
			if(block.y == 0)
			{
				//��Ϸʤ��
				GameTool.state= GameTool.STATE_OVER;
			}
		}
	}
//	function rotate()
//	{
//		var newShape=[3-s[1],s[0],3-s[3],s[2],3-s[5],s[4],3-s[7],s[6]];
//		 if( checkh(newShape,x,y,0)=="ok"){
//	                s=newShape;
//	     }   
//	}
//	 function vMove(){
//         if( checkv(s,x,y )=="ok"){
//             y++;
//         }
//         else{
//              fixShape(s,x,y);
//				 findFull();
//				 if(y>0)
//					reset();
//				else{
//					over=true;
//					alert('game over');
//				 }
//          }
//	 function fixShape(s,x,y){
//			for(var i=0;i<8;i+=2){           
//				m=x+s[i];
//				n=y+s[i+1];
//		          map[n][m]=1;
//				  console.log( "fixshape "+n+","+m);
//		       }	   
//		 }
}
