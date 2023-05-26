package mk.ukim.finki.emt.ordersmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class VideoGames implements ValueObject {

    private final VideoGamesId id;
    private final String name;
    private final Money price;

    private VideoGames(){
        this.id = VideoGamesId.randomId(VideoGamesId.class);
        this.name = "";
        this.price = Money.valueOf(Currency.MKD, (double) 0);
    }

    @JsonCreator
    public VideoGames(VideoGamesId id, String name, Money price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
