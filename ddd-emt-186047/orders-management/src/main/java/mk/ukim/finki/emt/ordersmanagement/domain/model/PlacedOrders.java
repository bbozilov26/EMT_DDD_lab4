package mk.ukim.finki.emt.ordersmanagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.emt.ordersmanagement.domain.model.ids.PlacedOrdersId;
import mk.ukim.finki.emt.productscatalog.domain.models.BooksAndComics;
import mk.ukim.finki.emt.productscatalog.domain.models.VideoGames;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.BooksAndComicsId;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.VideoGamesId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "placed_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlacedOrders extends AbstractEntity<PlacedOrdersId> {

    private String address;
    private String paymentMethod;

    @Column(name = "order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private OffsetDateTime dateCreated;

    @ManyToOne
    private ShoppingCart shoppingCart;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<ShoppingCart> shoppingCartSet;

    @ManyToOne
    private Discount discount;

    @OneToMany
//    @JoinColumn(name = "id")
    private List<mk.ukim.finki.emt.productscatalog.domain.models.BooksAndComics> booksAndComicsToOrder;
//    @ElementCollection(targetClass = Serializable.class)
//    private List<BooksAndComicsId> orderedBooksAndComics;

    @OneToMany
    private List<mk.ukim.finki.emt.productscatalog.domain.models.VideoGames> videoGamesToOrder;
//    @ElementCollection(targetClass = Serializable.class)
//    private List<VideoGamesId> orderedVideoGames;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

//    @Transient
//    private Money totalPrice;
    public Money total(){
        return shoppingCartSet.stream()
                .map(ShoppingCart::getTotalPrice)
                .reduce(new Money(currency, (double) 0), Money::add);
    }

    private PlacedOrders(){
        super(PlacedOrdersId.randomId(PlacedOrdersId.class));
    }

    public BooksAndComics addBooksAndComics(@NonNull mk.ukim.finki.emt.productscatalog.domain.models.BooksAndComics bc, int q){
        Objects.requireNonNull(bc, "Product must not be null");
        shoppingCart.addBooksAndComics(bc, bc.getPrice().multiply((double) q));
        return bc;
    }

    public VideoGames addVideoGames(@NonNull mk.ukim.finki.emt.productscatalog.domain.models.VideoGames vg, int q){
        Objects.requireNonNull(vg, "Product must not be null");
        shoppingCart.addVideoGames(vg, vg.getPrice().multiply((double) q));
        return vg;
    }

    public void removeBooksAndComics(@NonNull BooksAndComicsId id){
        Objects.requireNonNull(id, "Ordered product must not be null");
        shoppingCart.getBooksAndComicsToOrder().removeIf(bc -> bc.getId().equals(id));
    }

    public void removeVideoGames(@NonNull VideoGamesId id){
        Objects.requireNonNull(id, "Ordered product must not be null");
        shoppingCart.getVideoGamesToOrder().removeIf(vg -> vg.getId().equals(id));
    }
}
