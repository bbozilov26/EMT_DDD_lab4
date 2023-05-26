package mk.ukim.finki.emt.ordersmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class BooksAndComics implements ValueObject {

    private final BooksAndComicsId id;
    private final String name;
    private final Money price;

    private BooksAndComics(){
        this.id = BooksAndComicsId.randomId(BooksAndComicsId.class);
        this.name = "";
        this.price = Money.valueOf(Currency.MKD, (double) 0);
    }

    @JsonCreator
    public BooksAndComics(BooksAndComicsId id, String name, Money price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
