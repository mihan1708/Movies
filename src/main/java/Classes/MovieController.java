package Classes;

import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.*;
import java.util.List;


@Path("/movie")
@Consumes("application/json")
@Produces("application/json")
public class MovieController {
    @Autowired
    MovieServiceImpl ms;
    //MovieAccessServiceImpl mas;

    // поиск фильмов
    @POST// HTTP POST запрос
    @Path("/view") // полный URL сервиса будет http://localhost:8080/webapp/movie/view
    public List<Movie> getMovies(@QueryParam("substr") String substr) {
        List<Movie>films = ms.searchMovies(substr);

        return films;
    }

    //детали по 1 фильму (включая отзывы)
    @GET// HTTP GET запрос
    @Path("/{movie_id}") // полный URL сервиса будет http://localhost:8080/webapp/movie/{movie_id}
    public Movie getMovie(@PathParam("movie_id") String id) {
        Movie film = ms.infoMovie(id);
        return film;
    }

    //добавить отзыв к фильму
    @POST// HTTP GET запрос
    @Path("/{movie_id}/review") // полный URL сервиса будет http://localhost:8080/webapp/movie/{movie_id}/review
    public String getReview(@PathParam("movie_id") int id, Review review) {
        //if(ms.addCommentMovie(movie_id,text,rating,author))
        review.movie_ID =id;
        if(ms.addCommentMovie(review))
        return "отзыв добавлен";
        else  return "отзыв не был добавлен";
    }

    //изменить отзыв к фильму
    @PUT
    @Path("/review")
    public void updateReview(Review review)
    {
        ms.updateReview(review);
    }

    //получить все свои отзывы
    @POST
    @Path("/review/view")
    public List<Review> getMyReview()
    {
        return ms.getMyReview();
    }

    //удалить отзыв по movie_id
    @DELETE
    @Path("/review/{review_id}")
    public void deleteReviewById(@PathParam("review_id") int id)
    {
        ms.deleteReviewById(id);
    }

    //получить все жанры
    @GET
    @Path("/genre") // полный URL сервиса будет http://localhost:8080/webapp/movie/genre
    public List<Genre> getGenre() {
        List<Genre> genres = ms.getGenre();
        return  genres;
    }

    //получить все типы фильмов
    @GET
    @Path("/titletype") // полный URL сервиса будет http://localhost:8080/webapp/movie/titletype
    public List<TitleType> getTitleType() {
        return null;

    }

}
