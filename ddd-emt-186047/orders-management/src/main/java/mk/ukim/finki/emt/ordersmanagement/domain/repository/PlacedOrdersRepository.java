package mk.ukim.finki.emt.ordersmanagement.domain.repository;

import mk.ukim.finki.emt.ordersmanagement.domain.model.PlacedOrders;
import mk.ukim.finki.emt.ordersmanagement.domain.model.ids.PlacedOrdersId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacedOrdersRepository extends JpaRepository<PlacedOrders, PlacedOrdersId> {
}
