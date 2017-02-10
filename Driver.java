import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Driver{
    public static void main(String[] args){
	Grafix g = new Grafix(500,500);
	System.out.println("No more newline characters!");
	Pixel c = new Pixel(50,50,50);
	g.bresLine(0,0,100,100,c);
	g.write("test.ppm");
    }
}
