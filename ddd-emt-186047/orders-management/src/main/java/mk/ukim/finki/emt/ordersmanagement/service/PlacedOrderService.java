package mk.ukim.finki.emt.ordersmanagement.service;

import mk.ukim.finki.emt.ordersmanagement.domain.exceptions.OrderIdNotFoundException;
import mk.ukim.finki.emt.ordersmanagement.domain.exceptions.OrderItemIdNotFoundException;
import mk.ukim.finki.emt.ordersmanagement.domain.model.PlacedOrders;
import mk.ukim.finki.emt.ordersmanagement.domain.model.ids.PlacedOrdersId;
import mk.ukim.finki.emt.ordersmanagement.service.forms.OrderForm;
import mk.ukim.finki.emt.ordersmanagement.service.forms.OrderItemForm;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.BooksAndComicsId;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.VideoGamesId;

import java.util.List;
import java.util.Optional;

public interface PlacedOrderService {

    PlacedOrdersId placeOrder(OrderForm orderForm);
    List<PlacedOrders> findAll();
    Optional<PlacedOrders> findById(PlacedOrdersId id);
    void addItem(PlacedOrdersId id, OrderItemForm orderItemFrom) throws OrderIdNotFoundException;
    void deleteItem(PlacedOrdersId placedOrdersId, BooksAndComicsId booksAndComicsId) throws OrderIdNotFoundException, OrderItemIdNotFoundException;
    void deleteItem(PlacedOrdersId placedOrdersId, VideoGamesId videoGamesId) throws OrderIdNotFoundException, OrderItemIdNotFoundException;
}
