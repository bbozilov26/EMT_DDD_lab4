package mk.ukim.finki.emt.sharedkernel.domain.financial;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Getter
public class Money implements ValueObject {

    @Enumerated(value = EnumType.STRING)
    private final Currency currency;
    private final Double amount;

    protected Money(){
        this.amount = 0.0;
        this.currency = null;
    }

    public Money(@NonNull Currency currency, @NonNull Double amount){
        this.currency = currency;
        this.amount = amount;
    }

    public static Money valueOf(Currency currency, Double amount){
        return new Money(currency, amount);
    }

    public Money add(Money money) {
        if (money == null) {
            throw new IllegalArgumentException("Money must not be null");
        }

        if (currency == null || !currency.equals(money.currency)) {
            throw new IllegalArgumentException("Currencies must be the same and not null");
        }

        return new Money(currency, amount + money.amount);
    }

    public Money subtract(Money money) {
        if (money == null) {
            throw new IllegalArgumentException("Money must not be null");
        }

        if (currency == null || !currency.equals(money.currency)) {
            throw new IllegalArgumentException("Currencies must be the same and not null");
        }

        return new Money(currency, amount - money.amount);
    }

    public Money multiply(Double value) {
        return new Money(currency, amount * value);
    }
}
