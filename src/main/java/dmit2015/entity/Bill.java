package dmit2015.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "assignment08Bill")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Bill {

    // TODO: Add a data field for the username

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    protected Long id;

    @NotBlank(message = "Please enter a payee name")
    protected String payeeName;

    @NotNull(message = "Please enter/select the due date")
    @FutureOrPresent(message = "Payment due date must be in the future or present day", groups = {NewBillChecks.class})
    protected LocalDate dueDate = LocalDate.now().plusWeeks(2);

    @NotNull(message = "Please enter the amount that is due.")
    protected BigDecimal paymentDue;

    protected BigDecimal paymentBalance;

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
