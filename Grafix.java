import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Grafix{
    //instance variables of Grafix
    private int width;
    private int height;
    private Pixel[][] data;
    public Grafix(int width, int height){
	setWidth(width);
	setHeight(height);
	data = new Pixel[width][height];
	for(int i = 0; i< width; i++){
	    for(int j = 0; j< height; j++){
		data[i][j]=new Pixel(100,100,100);
	    }
	}
    }
    public Grafix(){
	this(500,500);
    }
    //mutators
    public void setWidth(int w){
	width = w;
    }
    public void setHeight(int h){
	height = h;
    }
    public void plot(int x, int y, Pixel p){
	data[x][y]=p;
    }
    //accessors
    public int getWidth(){
        return width;
    }
    public int getHeight(){
	return height;
    }
    public Pixel getPixel(int x, int y){
	return data[x][y];
    }
    //getData converts all of the pixel data to a string
    public String printData(){
	String retStr = "P3 ";
	retStr+=getWidth();
	retStr+=" ";
	retStr+=getHeight();
	retStr+=" 255\n";
	for(int i = 0; i< getWidth(); i++){
	    for(int j = 0; j< getHeight(); j++){
		//System.out.println(data[i][j].toString());
		retStr+=data[i][j].toString();
	    }
	}
	return retStr;
    }
    //fun was the draw function for the first assignment
    public void fun(){
	for(int i = 0; i < getWidth(); i++){
	    for(int j = 0; j< getHeight();j++){
		data[i][j].setR((i+j)%256);
		data[i][j].setG((i-j)%256);
		data[i][j].setB((i*j)%256);
		//It looks pretty cool
	    }
	}
    }
    public void bresLine(int xi, int yi, int xf, int yf, Pixel color){
	int x = xi;
	int y = yi;
	int a = 2*(yf-yi);
	int b = 2*(xi-xf);
	int d=a+xi-xf;
	while(x<=xf){
	    plot(x,y,color);
	    if(d>0){
		y++;
		d+=b;
	    }
	    x++;
	    d+=a;
	}
    }
    //Write function copies the pixels to image file
    public void write(String name){
	try{
	    File f = new File(name);
	    f.delete();
	    f.createNewFile();
	    FileWriter w = new FileWriter(f, true);
	    w.write("P3 "+getWidth()+" "+getHeight()+" 255\n");
	    for(int i = 0; i< getWidth(); i++){
		for(int j = 0; j< getHeight(); j++){
		    w.write(data[i][j].toString());
		}
	    }
	    w.close();
	}catch(IOException e){
	    System.out.println("IO Error PANIC");
	}
    }
}
