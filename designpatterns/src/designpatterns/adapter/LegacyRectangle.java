package designpatterns.adapter;

public class LegacyRectangle implements LegacyShape {
	private int leftX;
	private int leftY;
	private int rightX;
	private int rightY;
	
	public void Draw() {
		for(int i = leftY; i <= rightY; ++i) {
			if(i == leftY || i == rightY)
			{
				drawTopOrBottonLine();
			}
			else
			{
				drawMiddleLine();
			}
		}
	}
	
	private void drawTopOrBottonLine() {
		for(int j = leftX; j <= rightX; ++j) {
			if(j == leftX || j == rightX)
				System.out.print("|");
			else
				System.out.print("-");
		}	
		System.out.println("");
	}
	
	private void drawMiddleLine() {
		for(int j = leftX; j <= rightX; ++j) {
			if(j == leftX || j == rightX)
				System.out.print("|");
			else
				System.out.print(" ");
		}
		System.out.println("");
	}

	public void setPosition(int leftX, int leftY, int rightX, int rightY) {
		if(rightX - leftX < 2)
			rightX = leftX + 2;
		if(rightY - leftY < 2)
			rightY = leftY + 2;
		
		this.leftX = leftX;
		this.leftY = leftY;
		this.rightX = rightX;
		this.rightY = rightY;
	}

}
