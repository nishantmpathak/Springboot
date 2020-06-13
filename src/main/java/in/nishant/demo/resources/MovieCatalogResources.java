package in.nishant.demo.resources;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import in.nishant.demo.model.CatalogItem;
import in.nishant.demo.model.Movie;
import in.nishant.demo.model.Rating;
import in.nishant.demo.model.RatingList;

@RestController
@RequestMapping("/catalogItem")
public class MovieCatalogResources {
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userID}")
	public List<CatalogItem> getCatalog(@PathVariable("userID") String userID){
		System.out.println(userID);
		
		/*
		 * List<Rating> ratings = Arrays.asList( new Rating("1234",4), new
		 * Rating("5678",3));
		 */
		RatingList ratings = restTemplate.getForObject("http://Movie-Rating/rating/user/"+userID, RatingList.class);
		
		
		return (List<CatalogItem>) ratings.getRatings().stream().map(rating ->{
			Movie movie = 	restTemplate.getForObject("http://Movie-Info/movie/"+rating.getMovieID(),Movie.class);
			/*
			 * Movie movie = webClientBuilder.build() .get()
			 * .uri("http://localhost:8082/movie/"+rating.getMovieID()) .retrieve()
			 * .bodyToMono(Movie.class) .block();
			 */
			
			System.out.println(movie.toString());
			return new CatalogItem(movie.getMovieName(),"Desc",rating.getRate());
		}).collect(Collectors.toList());
		
		/*
		 * return Collections.singletonList( new CatalogItem("Uri","Nation",5) );
		 */
	}

}
