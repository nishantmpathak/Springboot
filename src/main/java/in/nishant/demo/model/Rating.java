package in.nishant.demo.model;

public class Rating {
	private String movieID;
	private int rate;
	
	public Rating() {
	}
	
	public Rating(String movieID, int rate) {
		super();
		this.movieID = movieID;
		this.rate = rate;
	}
	
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
}
