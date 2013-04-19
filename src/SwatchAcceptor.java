public class SwatchAcceptor {
	public boolean swatch = false;
	static public String colors[]= new String[5];
	int i=0;
	public void SwatchHexColor(String q){
		if(q.equals("kuler:swatchHexColor")){
			swatch = true;
		}
	}
	public void readColor(String color){
		if(swatch){
			colors[i++]=color;
		}
	}
	public void display(){
		for(i=0;i<5;i++) System.out.println(colors[i]);
	}
	public void close(){
		swatch=false;
	}
	public String[] getColors(){
		return colors;
	}
}
