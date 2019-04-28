package Classes;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    @Query(value = "Select r from Review r where r.author like :author")
    List<Review> findAllById(@Param("author")String  name);
    @Modifying
    @Query("update Review r set r.text=:text where r.review_ID=:id")
    int updateReview(@Param("text") String text, @Param("id") long id);

}
