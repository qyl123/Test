package gamerole;

import java.awt.Color;
import java.awt.Font;

import com.GameTool;
import item.ItemBase;

public class BlockScore  {
	public int x=330;	//Model, View, Control 
	public int y=160;	//M: 分数输出的坐标
	public int score;	//M: 分数
	 
	public void init()
	{
		score=0;
	}
	// 数据刷新：传入消除的行数，计算得分
	// 修改得分规则，只改这里，不需要改主程序
	public void update(int linesNum)
	{
		if(linesNum>0)
		{
			// 1行10分，2行30分，3行50分，4行70分
			score+=10*(linesNum*2-1);	//得分增加
		}
	}
	// View, 画出得分成绩的画面
	public void paint ()
	{
		GameTool.g.setColor(Color.WHITE) ;
		GameTool.g.setFont(new Font("Times New Roman", Font.BOLD, 30)) ;
		GameTool.g.drawString("SCORE", x, y);	 
		GameTool.g.drawString(""+score, x, y+30);	 
	 }
}
