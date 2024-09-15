package product;

public class Media{
	private String title;
	private String url;
	private int points;

	public Media(String title, String url, int points){
	    this.title = title;
	    this.url = url; 
	    this.points = points;
	}
	public int getPoints(){
		return points;
	}

	@Override
	public String toString(){
	    return title + "(" + url + ")" + ", Points: " + points;
	}

	public String getTitle(){
	    return title;
	}

	public String getUrl(){
	    return url;
	}
}