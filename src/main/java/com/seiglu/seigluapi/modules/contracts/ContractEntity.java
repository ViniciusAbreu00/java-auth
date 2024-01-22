package com.seiglu.seigluapi.modules.contracts;

import com.seiglu.seigluapi.modules.therapist.TherapistEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "contracts_tbl")
public class ContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private BigDecimal amount;
    private String description;

    @ManyToOne()
    @JoinColumn(name = "therapist_id", insertable = false, updatable = false)
    private TherapistEntity therapistEntity;

    @Column(name = "therapist_id")
    private UUID therapistId;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
