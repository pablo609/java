package designpatterns.adapter;

public class Rectangle implements Shape {
	private int lenght;
	private int hight;
	private final int MIN_SIZE = 3;
	
	public void display() {
		for(int i = 1; i <= hight; ++i) {
			if(i == 1 || i == hight)
			{
				displayTopOrBottonLine();
			}
			else
			{
				displayMiddleLine();
			}
		}
	}
	
	private void displayTopOrBottonLine() {
		for(int j = 1; j <= lenght; ++j) {
			if(j == 1 || j == lenght)
				System.out.print("|");
			else
				System.out.print("-");
		}	
		System.out.println("");
	}
	
	private void displayMiddleLine() {
		for(int j = 1; j <= lenght; ++j) {
			if(j == 1 || j == lenght)
				System.out.print("|");
			else
				System.out.print(" ");
		}
		System.out.println("");
	}
	
	public void setSize(int lenght, int hight) {
		if(lenght < MIN_SIZE)
			lenght = MIN_SIZE;
		if(hight < MIN_SIZE)
			hight = MIN_SIZE;
		
		this.lenght = lenght;
		this.hight = hight;
	}
}
