import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Driver{
    public static void main(String[] args){
	Grafix g = new Grafix(500,500);
	Pixel c = new Pixel(50,50,150);
	g.bresLine(0,0,100,100,c);
	System.out.println("Should be bres1");
	g.bresLine(0,0,100,50,c);
	System.out.println("Should be bres1");
	g.bresLine(0,0,50,100,c);
	System.out.println("Should be bres2");
	g.bresLine(100,50,200,0,c);
	System.out.println("Should be bres8");
	g.bresLine(50,100,0,200,c);
	System.out.println("Should be bres7");
	g.bresLine(100,100,200,100,c);
	System.out.println("Should be bres1");
	g.bresLine(100,100,100,200,c);
	System.out.println("Should be bres2");
	g.plot(100,300,c);
	g.write("test.ppm");
    }
}
