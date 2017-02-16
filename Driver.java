import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Driver{
    public static void main(String[] args){
	Grafix g = new Grafix(300,500);
	Pixel c = new Pixel(50,150,150);
	g.bresLine(50,150,50,350,c);
	g.bresLine(50,150,75,100,c);
	g.bresLine(50,350,75,400,c);
	g.bresLine(75,100,100,75,c);
	g.bresLine(75,400,100,425,c);
	g.bresLine(100,425,150,450,c);
	g.bresLine(100,75,150,50,c);
	g.bresLine(150,50,250,50,c);
	g.bresLine(150,450,250,450,c);
	g.bresLine(50,250,200,250,c);
	g.write("test.ppm");
    }
}
