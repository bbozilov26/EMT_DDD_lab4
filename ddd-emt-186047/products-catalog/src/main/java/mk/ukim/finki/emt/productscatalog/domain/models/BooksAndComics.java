package mk.ukim.finki.emt.productscatalog.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.BooksAndComicsId;
import mk.ukim.finki.emt.productscatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
//import org.dom4j.tree.AbstractEntity;

@Entity
@Table(name = "books_and_comics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksAndComics extends AbstractEntity<BooksAndComicsId> {

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
    private Author author;

    @OneToOne
    private Publisher publisher;

    @ManyToMany
    private List<Genres> genres;

    @OneToMany
    private List<RatingsAndReviews> ratingsAndReviews;
}
