package Classes;

import java.util.List;

public interface MovieAccessService {
    List<Movie> searchMovies(String substr);
    Movie infoMovie(String id);
    boolean addCommentFilm(Review review);
    boolean updateReview(Review review);

    List<Review> getListReviewById(int id);
    List<Review> getMyReview(String name);
    boolean deleteReviewById(int id);
    List<TitleType> getTitleType();
    List<Genre> getGenre();
}
