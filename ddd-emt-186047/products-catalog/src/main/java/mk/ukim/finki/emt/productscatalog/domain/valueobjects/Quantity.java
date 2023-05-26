package mk.ukim.finki.emt.productscatalog.domain.valueobjects;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Quantity {

    private final Integer quantity;

    protected Quantity(){
        this.quantity = 0;
    }
}
