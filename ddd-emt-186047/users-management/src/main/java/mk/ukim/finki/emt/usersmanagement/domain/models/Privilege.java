package mk.ukim.finki.emt.usersmanagement.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.usersmanagement.domain.models.ids.PrivilegeId;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "privileges")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Privilege extends AbstractEntity<PrivilegeId> {

    private String label;
    private String description;
}
