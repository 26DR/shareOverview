package com.company.shareoverview.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ShareRegistrations")
@EntityListeners(AuditingEntityListener.class)
public class ShareRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;


    @JoinColumn(name = "share_id")
    @ManyToOne
    @JsonBackReference
    private ShareData acquiredShareData;


    @Column(
            name = "price",
            nullable = false
    )
    @Min(0)
    private BigDecimal pricePerShare;

    @Column(
            name = "amount_acquired",
            nullable = false
    )
    @Min(0)
    private int amountOfSharesAcquired;

    @Column(
            name = "acquirer_id",
            nullable = false
    )
    @NotNull(message = "Stock acquirer employee ID is mandatory")
    private Long acquirerEmployeeId;

    @Column(
            name = "date",
            nullable = false
    )
    @CreatedDate
    private Date acquisitionDate = new Date();
}
