package Classes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust")
    @SequenceGenerator(name = "cust", sequenceName = "seq_cust")
    String movie_id;//идентификатор

    @OneToOne
    @JoinColumn(name = "title_type_id")
    TitleType title_type;
    @Column(name = "PRIMARYTITLE")
    String primaryTitle;//название
    @Column(name = "ORIGINALTITLE")
    String originalTitle;
    @Column(name = "ISADULT")
    int isAdult;
    @Column(name = "STARTYEAR")
    int fromYear;
    @Column(name = "ENDYEAR")
    int toYear;
    @Column(name = "RATING")
    float rating;//рейтинг
    @Column(name = "VOTES")
    long votes;
    @Column(name = "IMBD_ID")
    String imbdID;
    @Column(name = "OVERVIEW")
    String description;
    @Column(name = "POSTER_PATH")
    String posterPath;

    //List<Genre> genre;//жанр
    @Transient
    List<Review> commentList;//список отзывов

    public Movie() {
    }

    public String getImbdID() {
        return imbdID;
    }

    public void setImbdID(String imbdID) {
        this.imbdID = imbdID;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public TitleType getTitle_type() {
        return title_type;
    }

    public void setTitle_type(TitleType title_type) {
        this.title_type = title_type;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<Review> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Review> commentList) {
        this.commentList = commentList;
    }

    public int getIsAdult() {
        return isAdult;
    }

    public void setIsAdult(int isAdult) {
        this.isAdult = isAdult;
    }

    public int getFromYear() {
        return fromYear;
    }

    public void setFromYear(int fromYear) {
        this.fromYear = fromYear;
    }

    public int getToYear() {
        return toYear;
    }

    public void setToYear(int toYear) {
        this.toYear = toYear;
    }

}
