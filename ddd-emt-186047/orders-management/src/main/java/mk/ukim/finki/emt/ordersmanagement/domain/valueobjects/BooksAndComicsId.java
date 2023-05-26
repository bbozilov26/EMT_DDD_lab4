package mk.ukim.finki.emt.ordersmanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class BooksAndComicsId extends DomainObjectId {

    protected BooksAndComicsId(String uuid){
        super(uuid);
    }

    public BooksAndComicsId() {

    }
}
