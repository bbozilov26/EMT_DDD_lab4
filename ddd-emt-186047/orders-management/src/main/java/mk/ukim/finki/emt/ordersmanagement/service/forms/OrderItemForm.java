package mk.ukim.finki.emt.ordersmanagement.service.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.productscatalog.domain.models.BooksAndComics;
import mk.ukim.finki.emt.productscatalog.domain.models.VideoGames;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemForm {

    @NotNull
    private BooksAndComics booksAndComics;

    @NotNull
    private VideoGames videoGames;

    @Min(1)
    private int quantity = 1;
}
