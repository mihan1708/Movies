package Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Component
public class MovieServiceImpl implements MovieService {

    @Autowired
    private UserServiceImpl us;
    @Autowired
    private MovieAccessServiceImpl mas;
    @Override
    public List<Movie> searchMovies(String substr) {
        return sortMovies(mas.searchMovies(substr));

    }

    @Override
    public List<Movie> sortMovies(List<Movie> foundFilmList) {
        Collections.sort(foundFilmList, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                //по убыванию рейтинга
                return (int) ((o2.rating - o1.rating) * 10);
            }
        });
        return foundFilmList;
    }

    @Override
    public boolean addCommentMovie(Review review) {
        return mas.addCommentFilm(review);
    }

    //доделать(добавить отзывы)
    @Override
    public Movie infoMovie(String id) {

        return mas.infoMovie(id);
    }
    @Override
    public boolean updateReview(Review review) {
        if(us.getCurrentUser().getAdmin())
        {
            return mas.updateReview(review);

        }
        return false;
    }

    @Override
    public List<Review> getMyReview() {
        if(!us.getCurrentUser().getAdmin())
        {
            return mas.getMyReview(us.getCurrentUser().getLogin());
        }
        return null;
    }
    @Override
    public boolean deleteReviewById(int id)
    {
        if(us.getCurrentUser().getAdmin())
        {
            return mas.deleteReviewById(id);

        }
        else return false;
    }

    @Override
    public List<Genre> getGenre() {
        return mas.getGenre();
    }

    @Override
    public List<TitleType> getTitleType() {
        return mas.getTitleType();
    }
}
