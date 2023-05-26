package mk.ukim.finki.emt.usersmanagement.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import mk.ukim.finki.emt.productscatalog.domain.models.RatingsAndReviews;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.usersmanagement.domain.models.ids.UserId;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity<UserId> {

    private String name;
    private String surname;
    private String email;
    private String password;
    private OffsetDateTime dateCreated;
    private OffsetDateTime dateModified;

    @ManyToMany
    private List<UserRoles> userRoles;

    @OneToMany
    private List<Tokens> tokens;

//    @OneToMany
//    private List<RatingsAndReviews> ratingsAndReviews;

//    @OneToOne
//    private ShoppingCart shoppingCart;
}
