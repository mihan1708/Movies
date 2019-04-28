package Classes;

import java.util.List;

public interface MovieService {
    List<Movie> searchMovies(String substr);
    List<Movie> sortMovies(List<Movie> foundFilmList);
    boolean addCommentMovie(Review review);
    Movie infoMovie(String id);
    boolean updateReview(Review review);
    List<Review> getMyReview();
    boolean deleteReviewById(int id);
    List<Genre> getGenre();
    List<TitleType> getTitleType();
}
