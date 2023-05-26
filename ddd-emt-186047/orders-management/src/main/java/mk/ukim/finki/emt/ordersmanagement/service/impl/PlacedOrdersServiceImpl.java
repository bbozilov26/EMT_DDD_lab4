package mk.ukim.finki.emt.ordersmanagement.service.impl;

import mk.ukim.finki.emt.ordersmanagement.domain.exceptions.OrderIdNotFoundException;
import mk.ukim.finki.emt.ordersmanagement.domain.exceptions.OrderItemIdNotFoundException;
import mk.ukim.finki.emt.ordersmanagement.domain.model.OrderState;
import mk.ukim.finki.emt.ordersmanagement.domain.model.PlacedOrders;
import mk.ukim.finki.emt.ordersmanagement.domain.model.ids.PlacedOrdersId;
import mk.ukim.finki.emt.ordersmanagement.domain.repository.PlacedOrdersRepository;
import mk.ukim.finki.emt.ordersmanagement.service.PlacedOrderService;
import mk.ukim.finki.emt.ordersmanagement.service.forms.OrderForm;
import mk.ukim.finki.emt.ordersmanagement.service.forms.OrderItemForm;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.BooksAndComicsId;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.VideoGamesId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class PlacedOrdersServiceImpl implements PlacedOrderService {

    private final PlacedOrdersRepository placedOrdersRepository;
    private final Validator validator;

    public PlacedOrdersServiceImpl(PlacedOrdersRepository placedOrdersRepository, Validator validator) {
        this.placedOrdersRepository = placedOrdersRepository;
        this.validator = validator;
    }

    @Override
    public PlacedOrdersId placeOrder(OrderForm orderForm) {
        Objects.requireNonNull(orderForm, "Order must not be null.");
        var constraintViolation = validator.validate(orderForm);
        if(constraintViolation.size() > 0){
            throw new ConstraintViolationException("The order form is not valid", constraintViolation);
        }
        var newOrder = placedOrdersRepository.saveAndFlush(toDomainObject(orderForm));
        return newOrder.getId();
    }

    private PlacedOrders toDomainObject(OrderForm orderForm){
        var order = new PlacedOrders(
                "",
                "",
                orderForm.getCurrency(),
                OffsetDateTime.now(),
                orderForm.getShoppingCart(),
                null,
                null,
                orderForm.getShoppingCart().getBooksAndComicsToOrder(),
                orderForm.getShoppingCart().getVideoGamesToOrder(),
                OrderState.PROCESSING);
        return order;
    }

    @Override
    public List<PlacedOrders> findAll() {
        return placedOrdersRepository.findAll();
    }

    @Override
    public Optional<PlacedOrders> findById(PlacedOrdersId id) {
        return placedOrdersRepository.findById(id);
    }

    @Override
    public void addItem(PlacedOrdersId id, OrderItemForm orderItemForm) throws OrderIdNotFoundException {
        PlacedOrders placedOrders = placedOrdersRepository.findById(id).orElseThrow(OrderIdNotFoundException::new);
        placedOrders.getBooksAndComicsToOrder().add(orderItemForm.getBooksAndComics());
        placedOrders.getVideoGamesToOrder().add(orderItemForm.getVideoGames());
        placedOrdersRepository.saveAndFlush(placedOrders);
    }

    @Override
    public void deleteItem(PlacedOrdersId placedOrdersId, BooksAndComicsId booksAndComicsId) throws OrderIdNotFoundException, OrderItemIdNotFoundException {
        PlacedOrders placedOrders = placedOrdersRepository.findById(placedOrdersId).orElseThrow(OrderIdNotFoundException::new);
        placedOrders.removeBooksAndComics(booksAndComicsId);
        placedOrdersRepository.saveAndFlush(placedOrders);
    }

    @Override
    public void deleteItem(PlacedOrdersId placedOrdersId, VideoGamesId videoGamesId) throws OrderIdNotFoundException, OrderItemIdNotFoundException {
        PlacedOrders placedOrders = placedOrdersRepository.findById(placedOrdersId).orElseThrow(OrderIdNotFoundException::new);
        placedOrders.removeVideoGames(videoGamesId);
        placedOrdersRepository.saveAndFlush(placedOrders);
    }
}
