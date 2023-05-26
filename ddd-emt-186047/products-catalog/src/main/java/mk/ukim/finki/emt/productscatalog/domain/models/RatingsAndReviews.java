package mk.ukim.finki.emt.productscatalog.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.RatingsAndReviewsId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
//import mk.ukim.finki.emt.usersmanagement.domain.models.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ratings_and_reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingsAndReviews extends AbstractEntity<RatingsAndReviewsId> {

    private String review;
    private Double rating;

//    @ManyToOne
//    private User user;
}
