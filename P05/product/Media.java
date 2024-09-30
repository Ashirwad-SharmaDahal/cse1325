package product;
/**
 * Represents media with title, URL and the points required.
 * 
 * @author Ashirwad Sharma Dahal
 * @version 0.2
 * @since 2024-09-15
 */

public class Media{
	private String title;
	private String url;
	private int points;

	/**
	 * Constructs a Media object with the specified title, URL, and points.
	 * @param title the title of the media
	 * @param url the url of the media
	 * @param points the points required to access the media
	 * @since 2024-09-15
	 */

	public Media(String title, String url, int points){
	    this.title = title;
	    this.url = url; 
	    this.points = points;
	}
	/**
	 * @return the number of points required
	 * @since 2024-09-15
	 */
	public int getPoints(){
		return points;
	}
    /**
     * @return a string representation of the media
     * @since 2024-09-15
     */
	@Override
	public String toString(){
	    return title + "(" + url + ")" + ", Points: " + points;
	}
    /** 
     * @return the title of media
     * @since 2024-09-15
     */
	public String getTitle(){
	    return title;
	}
    /** @return the url of media
     * @since 2024-09-15
     */
	public String getUrl(){
	    return url;
	}
}