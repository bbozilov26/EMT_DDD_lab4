package mk.ukim.finki.emt.usersmanagement.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.usersmanagement.domain.models.ids.PrivilegeId;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roles_privileges")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePrivileges extends AbstractEntity<PrivilegeId> {

    @ManyToOne
    private Role role;

    @ManyToOne
    private Privilege privilege;
}
