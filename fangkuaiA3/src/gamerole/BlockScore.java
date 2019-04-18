package gamerole;

import java.awt.Color;
import java.awt.Font;

import com.GameTool;
import item.ItemBase;

public class BlockScore  {
	public int x=330;	//Model, View, Control 
	public int y=160;	//M: �������������
	public int score;	//M: ����
	 
	public void init()
	{
		score=0;
	}
	// ����ˢ�£���������������������÷�
	// �޸ĵ÷ֹ���ֻ���������Ҫ��������
	public void update(int linesNum)
	{
		if(linesNum>0)
		{
			// 1��10�֣�2��30�֣�3��50�֣�4��70��
			score+=10*(linesNum*2-1);	//�÷�����
		}
	}
	// View, �����÷ֳɼ��Ļ���
	public void paint ()
	{
		GameTool.g.setColor(Color.WHITE) ;
		GameTool.g.setFont(new Font("Times New Roman", Font.BOLD, 30)) ;
		GameTool.g.drawString("SCORE", x, y);	 
		GameTool.g.drawString(""+score, x, y+30);	 
	 }
}
