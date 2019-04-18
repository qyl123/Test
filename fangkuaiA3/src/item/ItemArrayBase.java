package item;

import java.util.ArrayList;


public class ItemArrayBase {
	
	public ArrayList<ItemBase> itemlist = new ArrayList<ItemBase>() ;
	public int state;
	public int maxnum;
		
	public int getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(int maxnum) {
		this.maxnum = maxnum;
	}
	
	public void init()
	{		
	}
	public void move()
	{		
	}
	public void newOneItem(int x,int y ,int r,String img_file_path)
	{
		ItemBase temp = new ItemBase() ;
		temp.setX(x) ; // 横坐标
		temp.setY(y  ) ; //纵坐标
		temp.setR(r) ; //感应半径
		// item 图片
		temp.setImgFile(img_file_path);
		
		itemlist.add(temp) ; // 添加到列表
	}
	
	public void paint()
	{
		/*绘制各个item */
		for(int i = 0; i < itemlist.size(); i++)
		{
			 itemlist.get(i).paint();
		}
	}
	public void paintOne(int x,int y,int w,int h,int index)
	{
		/*绘制某个item */
			 itemlist.get(index).paint(x,y,w,h);
	}
	// 动作类游戏的碰撞检测，格子类不用这个，格子类用二维数组
	//返回碰撞单元的下标
	public int ArrayHitOne(ItemBase  other)
	{
		for(int i = 0; i < itemlist.size(); i++)
		{
			 ItemBase item=itemlist.get(i);
			 if(item.isHit(other))
			 {
				 return i;
			 }
		}
		return -1;
	}
	//返回碰撞单元的下标
	public HitData ArrayHitArray(ItemArrayBase  otherarray)
	{
		for(int i = 0; i < itemlist.size(); i++)
		{
			 ItemBase item=itemlist.get(i);
			 for(int j=0;j< otherarray.itemlist.size();j++)
			 {
				 if(item.isHit(otherarray.itemlist.get(j)))
				 {
					 //System.out.println("== item array hit "+i+","+j);
					 return new HitData(i, j);
				 }
			 }
		}
		return null;
	}
}
