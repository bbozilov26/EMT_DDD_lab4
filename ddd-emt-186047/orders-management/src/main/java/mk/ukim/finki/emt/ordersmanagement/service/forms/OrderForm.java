package mk.ukim.finki.emt.ordersmanagement.service.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.ordersmanagement.domain.model.ShoppingCart;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm {

    @NotNull
    private Currency currency;

    @Valid
    @NotEmpty
    private ShoppingCart shoppingCart;
}
