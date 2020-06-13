package in.nishant.demo.model;

public class Movie {
	
	private String movieName;
	private String movieID;
	
	public Movie() {
		
	}
	
	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", movieID=" + movieID + "]";
	}

	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public Movie(String movieName, String movieID) {
		super();
		this.movieName = movieName;
		this.movieID = movieID;
	}
	

}
