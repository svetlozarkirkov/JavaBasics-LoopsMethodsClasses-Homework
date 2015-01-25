import java.util.ArrayList;
import java.util.Scanner;


public class Problem13_Durts {
	
	public static class Point{  // creates object "point" which can be stored easily in arraylist
		private int x;			// has two attributes "x" and "y"
		private int y;
		
		public Point(int x, int y){ 
			this.x=x;
			this.y=y;
		}
		public int getX(){ 
			return x;
		}
		public int getY(){ 
			return y;
		}
	}
	
	public static class Rectangle{		// creates object "rectangle" which is used to store the two crossed rectangles in the figure
		private int Ax, Ay, Bx, By, Cx, Cy, Dx, Dy;		// rectangle's sides
		
		public Rectangle(int Ax, int Ay, int Bx, int By, int Cx, int Cy, int Dx, int Dy){
			this.Ax=Ax;
			this.Ay=Ay;
			this.Bx=Bx;
			this.By=By;
			this.Cx=Cx;
			this.Cy=Cy;
			this.Dx=Dx;
			this.Dy=Dy;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int centerX = input.nextInt();	// reading the first input lines
		int centerY = input.nextInt();
		int radius = input.nextInt();
		int count = input.nextInt();
		ArrayList<Point> darts = new ArrayList<Point>(); // arraylist for the points
		for (int i = 0; i < count; i++){	// getting points until we reach the "count"
			Point temp = new Point(input.nextInt(),input.nextInt()); //creating temp point
			darts.add(temp);	// adding it to the list
			}
		// rectangle creation below
		Rectangle horizontal = new Rectangle(centerX-radius,centerY+(radius/2),centerX+radius,
				centerY+(radius/2),centerX+radius,centerY+(radius/2)-radius,centerX-radius,centerY+(radius/2)-radius);
		Rectangle vertical = new Rectangle(centerX-(radius/2),centerY+radius, centerX+(radius/2),centerY+radius,
				centerX+(radius/2),centerY-radius,centerX-(radius/2),centerY-radius);
		
		
		for (int i = 0; i < darts.size(); i++){		// iterating through every point in the list
			int currentX = darts.get(i).getX();		//and checking if it is inside any of the created rectangles
			int currentY = darts.get(i).getY();
			if ( (currentX >= horizontal.Ax && currentX <= horizontal.Cx && currentY >= horizontal.Dy &&
					currentY <= horizontal.Ay) || currentX >= vertical.Ax && currentX <= vertical.Cx &&
					currentY >= vertical.Dy && currentY <= vertical.Ay){
				System.out.println("yes");	// print yes if true
			}
			else {
				System.out.println("no"); // the point is outside the rectangles
			}
		}
		input.close(); // very important :D
	}
}