package mk.ukim.finki.emt.productscatalog.services.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksAndComicsForm {

    private String name;
    private Money price;
    private int quantity;
}
