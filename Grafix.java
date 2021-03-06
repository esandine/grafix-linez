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
    //bresLine1 draws the line in quadrant I using bresenham's line algorithm
    public void bresLine1(int xi, int yi, int xf, int yf, Pixel color){
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
    //bresLine2 draws the line in quadrant I using bresenham's line algorithm
    //it uses x=my+b as starting equation, reflecting the line about y=x
    public void bresLine2(int xi, int yi, int xf, int yf, Pixel color){
        int x = xi;
        int y = yi;
        int a = 2*(xf-xi);
        int b = 2*(yi-yf);
        int d=a+yi-yf;
        while(y<=yf){
            plot(x,y,color);
            if(d>0){
                x++;
                d+=b;
            }
            y++;
            d+=a;
        }
    }

    //bresLine8 draws the line in quadrant I using bresenham's line algorithm
    //it uses y=-(mx+b) as starting equation, reflecting the line
    public void bresLine8(int xi, int yi, int xf, int yf, Pixel color){
        int x = xi;
        int y = yi;
        int a = 2*(yi-yf);
        int b = 2*(xi-xf);
        int d=a+xi-xf;
        while(x<=xf){
            plot(x,y,color);
            if(d>0){
                y--;
                d+=b;
            }
            x++;
            d+=a;
        }
    }

    //bresLine7 draws the line in quadrant I using bresenham's line algorithm
    //it uses x=-(my+b) as starting equation, reflecting the line
    //this is kinda unintuitive but reflecting the equation is funner
    public void bresLine7(int xi, int yi, int xf, int yf, Pixel color){
        int x = xi;
        int y = yi;
	int a = 2*(xf-xi);
        int b = 2*(yf-yi);
        int d=a+yf-yi;
        while(y>=yf){
            plot(x,y,color);
            if(d>0){
                x++;
                d+=b;
            }
            y--;
            d+=a;
        }
    }
    //bresLine is a wrapper for all of the other functions
    public void bresLine(int xi, int yi, int xf, int yf, Pixel color){
	int temp;
	//swaps to take care of octants 3-6
	if(xi>xf){
	    temp=xi;
	    xi=xf;
	    xf=temp;
	    temp=yi;
	    yi=yf;
	    yf=temp;
	}
	//checks if quad I or quad IV
	if(yf>yi){
	    //checks oct II or oct I
	    if(yf-yi>xf-xi){
		bresLine2(xi,yi,xf,yf,color);
	    }else{
		bresLine1(xi,yi,xf,yf,color);
	    }
	}else{
	    //checks if oct VII or oct VIII
	    if(yi-yf>xf-xi){
		bresLine7(xi,yi,xf,yf,color);
	    }else{
		bresLine8(xi,yi,xf,yf,color);
	    }
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
	    for(int i = 0; i< getHeight(); i++){
		for(int j = 0; j<getWidth(); j++){
		    //the [j][bleh] stuff serves to rotate the coordinates
		    w.write(data[j][getHeight()-1-i].toString());
		}
	    }
	    w.close();
	}catch(IOException e){
	    System.out.println("IO Error PANIC");
	}
    }
}
