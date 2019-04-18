package gamerole;

import java.awt.Color;
import java.awt.Font;

import com.GameTool;
import item.ItemBase;
import item.Rect;

public class BlockPause  {
	public int x=330;// Model, View, Control
	public int y=460; // M: ��ťͼƬ��λ�ã�����ͼ����ͣ������
	public int w=100;
	public int h=50;
	
	public int state;	// M: ״̬��״̬����
	public static int STATE_PAUSE=1;
	public static int STATE_PLAY=0;
	
	public void init()
	{
		state=0;	//��ʼ��
	}
	public void update(int s)
	{
		state=1;	//����Ϊ��ͣ״̬
	}
	public void paint ()
	{
		if(state ==0)	//��ͬ״̬�£���ʾ��ͬ�İ�ťͼƬ  
			GameTool.res.paintOne(x, y, w, h, GameTool.RES_PAUSE);
		else
			GameTool.res.paintOne(x, y, w, h, GameTool.RES_PLAY);
	 }
	//����¼����ı�״̬
	public void mouseClicked(int mousex, int mousey)
	{
		Rect button=new Rect(x, y, w, h);
		if( button.pointInRect(mousex, mousey)==1 )
		{
			state=1-state;	//�û�������ͣ��ť��״̬�ı� 0,1
		}
	}
}
