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
		temp.setX(x) ; // ������
		temp.setY(y  ) ; //������
		temp.setR(r) ; //��Ӧ�뾶
		// item ͼƬ
		temp.setImgFile(img_file_path);
		
		itemlist.add(temp) ; // ��ӵ��б�
	}
	
	public void paint()
	{
		/*���Ƹ���item */
		for(int i = 0; i < itemlist.size(); i++)
		{
			 itemlist.get(i).paint();
		}
	}
	public void paintOne(int x,int y,int w,int h,int index)
	{
		/*����ĳ��item */
			 itemlist.get(index).paint(x,y,w,h);
	}
	// ��������Ϸ����ײ��⣬�����಻��������������ö�ά����
	//������ײ��Ԫ���±�
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
	//������ײ��Ԫ���±�
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
