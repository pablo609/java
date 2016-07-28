package designpatterns.adapter;

public interface LegacyShape {
	public void Draw();
	public void setPosition(int leftX, int leftY, int rightX, int rightY);
}
