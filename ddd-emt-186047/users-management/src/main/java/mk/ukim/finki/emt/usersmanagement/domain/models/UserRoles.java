package mk.ukim.finki.emt.usersmanagement.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.usersmanagement.domain.models.ids.UserRolesId;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoles extends AbstractEntity<UserRolesId> {

    @ManyToOne
    private User user;

    @ManyToOne
    private Role role;
}
