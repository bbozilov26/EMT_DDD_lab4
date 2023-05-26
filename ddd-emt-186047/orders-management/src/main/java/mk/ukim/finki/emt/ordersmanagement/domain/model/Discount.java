package mk.ukim.finki.emt.ordersmanagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.ordersmanagement.domain.model.ids.DiscountId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "discounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discount extends AbstractEntity<DiscountId> {

    private String labelCode;
    private String description;
    private Double percentage;
}
