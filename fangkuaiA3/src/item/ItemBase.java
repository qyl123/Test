package item;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.GameTool;

public class ItemBase {
	public int x ; // 横坐标
	public int y ; // 纵坐标
	public int r ; // 感应半径
	public int iseffect ; //是否有效，在屏幕绘制
	public int state ; //当前状态
	
	public int allBlood ; //总血量
	public int blood ; //当前血量
	public Image Img;
	public String ImgFile;
	
	public int speed;
	public int score;
	
	public ItemBase()
	{
		ImgFile="img\\default.png"; // 默认图片
	}
	////////////////////////
	public void paint()
	{
		GameTool.g.drawImage(Img, x , y  , null) ;
	}
	public void paint(int drawx,int drawy)
	{
		GameTool.g.drawImage(Img, drawx , drawy  , null) ;
	}
	public void paint(int drawx,int drawy,int w,int h)
	{
		GameTool.g.drawImage(Img, drawx , drawy  , w,h ,null) ;
	}
	public boolean isHit(ItemBase other)
	{
		int ax=this.getX()+this.getR();
		int ay=this.getY()+this.getR();
		int bx=other.getX()+other.getR();
		int by=other.getY()+other.getR();
		
		if( (ax - bx) * (ax - bx) +	(ay-by) * (ay-by) 
			<=(this.getR() + other.getR()) * (this.getR() + other.getR())) { //勾股定理
			return true ;
		}
		else
		{
			return false ;
		}
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	
	public int getAllBlood() {
		return allBlood;
	}

	public void setAllBlood(int allBlood) {
		this.allBlood = allBlood;
	}

	public int getBlood() {
		return blood;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}

	public Image getImg() {
		return Img;
	}

	public void setImg(Image img) {
		Img = img;
	}

	public String getImgFile() {
		return ImgFile;
	}

	public void setImgFile(String imgFile) {
		ImgFile = imgFile;
		this.Img = new ImageIcon(imgFile).getImage() ;
	}
	
	public int getIseffect() {
		return iseffect;
	}

	public void setIseffect(int iseffect) {
		this.iseffect = iseffect;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
