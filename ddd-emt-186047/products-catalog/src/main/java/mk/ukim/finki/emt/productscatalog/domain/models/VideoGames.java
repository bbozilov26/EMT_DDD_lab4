package mk.ukim.finki.emt.productscatalog.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.VideoGamesId;
import mk.ukim.finki.emt.productscatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "video_games")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoGames extends AbstractEntity<VideoGamesId> {

    private String name;
    private String description;

    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "price_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "price_currency"))
    })
    private Money price;

    private int quantity;
    private Date dateCreated;
    private Date datePublished;

    @ManyToOne
    private Creator creator;

    @OneToOne
    private Publisher publisher;

    @ManyToMany
    private List<Genres> genres;

    @OneToMany
    private List<RatingsAndReviews> ratingsAndReviews;
}
