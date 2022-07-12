package dmit2015.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "assignment08BillPayment")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BillPayment {

    // TODO: Add a data field for the username

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill billToPay;

    @Column(nullable = false)
    @NotNull(message = "Please enter the payment amount")
    @DecimalMin(value = "0.01", message = "Please enter a payment amount greater or equal to ${value}")
    private BigDecimal paymentAmount;

    @FutureOrPresent(message = "Payment due date must be in the future or present day", groups = {NewBillChecks.class})
    @Column(nullable = false)
    private LocalDate paymentDate = LocalDate.now();

    @Column(nullable = false)
    private LocalDateTime createdDateTime;

    private LocalDateTime updatedDateTime;

    @Version
    private Integer version;

    @PrePersist
    private void beforePersist() {
        createdDateTime = LocalDateTime.now();
    }

    @PreUpdate
    private void beforeUpdate() {
        updatedDateTime = LocalDateTime.now();
    }


}
