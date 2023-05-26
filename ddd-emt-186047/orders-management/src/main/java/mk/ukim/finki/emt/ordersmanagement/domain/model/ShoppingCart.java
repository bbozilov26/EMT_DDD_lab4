package mk.ukim.finki.emt.ordersmanagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.emt.ordersmanagement.domain.model.ids.ShoppingCartId;
import mk.ukim.finki.emt.ordersmanagement.domain.valueobjects.BooksAndComicsId;
import mk.ukim.finki.emt.ordersmanagement.domain.valueobjects.VideoGamesId;
import mk.ukim.finki.emt.productscatalog.domain.models.BooksAndComics;
import mk.ukim.finki.emt.productscatalog.domain.models.VideoGames;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart extends AbstractEntity<ShoppingCartId> {

    private Money totalPrice;

//    @OneToOne
//    private User user;

    @OneToMany
    private List<BooksAndComics> booksAndComicsToOrder;
//    @ElementCollection(targetClass = Serializable.class)
//    private List<BooksAndComicsId> booksAndComicsToOrder;

    @OneToMany
    private List<VideoGames> videoGamesToOrder;

    protected ShoppingCart(@NonNull ShoppingCartId id) {
        super(id);
    }

    protected ShoppingCart(@NonNull AbstractEntity<ShoppingCartId> source) {
        super(source);
    }

    //    @ElementCollection(targetClass = Serializable.class)
//    private List<VideoGamesId> videoGamesToOrder;

    public void addBooksAndComics(@NonNull BooksAndComics id, @NonNull Money price){
//        super(DomainObjectId.randomId(ShoppingCartId.class));
        this.booksAndComicsToOrder.add(id);
        this.totalPrice.add(price);
    }

    public void addVideoGames(@NonNull VideoGames id, @NonNull Money price){
//        super(DomainObjectId.randomId(ShoppingCartId.class));
        this.videoGamesToOrder.add(id);
        this.totalPrice.add(price);
    }
}
