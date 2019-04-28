package Classes;

import javax.persistence.*;

@Entity
@Table(name = "REVIEW")
public class Review {


    @Id
    @Column(name = "REVIEW_ID")
    long review_ID;
    @Column(name = "MOVIE_id")
    int movie_ID;
    @Column(name = "create_Date")
    String createDate;
    @Column(name = "name_author")
    String author;
    @Column(name = "TEXT")
    String text;
    @Column(name = "rating")
    float rating;

    public Review(int Movie_ID, int reviewID, String text, String author, float rating, String createDate) {
        this.text = text;
        this.author = author;
        this.rating = rating;
        this.createDate = createDate;
        this.movie_ID = Movie_ID;
        this.review_ID = reviewID;
    }

    public Review() {
    }

    public float getRating() {
        return rating;
    }

    public String getAuthor() {
        return author;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getText() {
        return text;
    }

    public int getMovie_ID() {
        return movie_ID;
    }

    public long getReview_ID() {
        return review_ID;
    }
}
