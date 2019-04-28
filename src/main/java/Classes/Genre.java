package Classes;

import javax.persistence.*;

@Entity
@Table(name = "DIC_GENRE")
public class Genre {

    @Id
    @Column(name = "GENRE_ID")
    long genreID;
    @Column(name = "GENRE")
    String genre;

    public Genre() {
    }
    public long getGenreID() {
        return genreID;
    }

    public void setGenreID(long genreID) {
        this.genreID = genreID;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


}
