import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Driver{
    public static void main(String[] args){
	Grafix g = new Grafix(500,500);
	System.out.println("No more newline characters!");
	Pixel c = new Pixel(50,50,50);
	g.bresLine1(0,0,100,100,c);
	g.bresLine1(0,0,100,50,c);
	g.bresLine2(0,0,50,100,c);
	g.bresLine8(100,50,200,0,c);
	g.bresLine7(50,100,0,200,c);
	g.bresLine1(100,100,200,100,c);
	g.bresLine2(100,100,100,200,c);
	g.write("test.ppm");
    }
}
