package Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.*;
import java.util.List;

@Service
@Component
public class MovieAccessServiceImpl implements MovieAccessService {

    //репозитории для БД
    @Autowired
    GenreRepository genresRepository;
    @Autowired
    TitleRepository titlesRepository;
    @Autowired
    ReviewRepository reviewsRepository;


    @PersistenceContext
    private EntityManager em;

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    @Override//поиск всех фильмов с заданными параметрами
    public List<Movie> searchMovies(String substr) {
        return null;
    }

    @Override// информация по 1 фильму
    public Movie infoMovie(String idInput) {
        Movie m = em.find(Movie.class, idInput);
        return m;
    }

    @Override
    public boolean addCommentFilm(Review review) {
        reviewsRepository.save(review);
        return true;
    }

    @Override
    @Transactional
    public boolean updateReview(Review review) {
        reviewsRepository.updateReview(review.text,review.review_ID);
        return true;
    }

    @Override
    public List<Review> getListReviewById(int id) {
        return null;
    }

    @Override
    public List<Review> getMyReview(String name) {
        return reviewsRepository.findAllById(name);
    }

    @Override
    public boolean deleteReviewById(int id) {
        reviewsRepository.delete((long)id);
        return true;
    }

    @Override
    public List<TitleType> getTitleType() {
        List<TitleType> titles = (List<TitleType>)titlesRepository.findAll();
        return titles;

    }

    @Override
    public List<Genre> getGenre() {
        List<Genre> genres = (List<Genre>) genresRepository.findAll();
        return genres;
    }
}
