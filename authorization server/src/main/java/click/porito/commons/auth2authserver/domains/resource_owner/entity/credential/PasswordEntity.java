package click.porito.commons.auth2authserver.domains.resource_owner.entity.credential;

import click.porito.commons.auth2authserver.domains.resource_owner.entity.ResourceOwnerEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity @Table(name = "password")
@DiscriminatorValue("password")
@PrimaryKeyJoinColumn(name = "credential_id")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PasswordEntity extends CredentialEntity {

    @Column(name = "password_value", nullable = false)
    private String value;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant issuedAt;

    @Column(name = "expires_at")
    private Instant expiresAt;

    public PasswordEntity(ResourceOwnerEntity resourceOwner, String value, Instant issuedAt, Instant expiresAt) {
        super(resourceOwner);
        this.value = value;
        this.issuedAt = issuedAt;
        this.expiresAt = expiresAt;
    }
}
