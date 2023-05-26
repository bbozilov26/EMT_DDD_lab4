package mk.ukim.finki.emt.sharedkernel.domain.base;

import lombok.Getter;
import lombok.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Embeddable
@Getter
public class DomainObjectId implements Serializable {

    private String id;

    @JsonCreator
    protected DomainObjectId(@NonNull String id) {
        this.id = Objects.requireNonNull(id, "Id must not be null");
    }

    public DomainObjectId() {
    }

    @NonNull
    public static <T extends DomainObjectId> T randomId(@NonNull Class<T> idClass) {
        try {
            return idClass.getConstructor(String.class).newInstance(UUID.randomUUID().toString());
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to create new instance of " + idClass, e);
        }
    }
}
