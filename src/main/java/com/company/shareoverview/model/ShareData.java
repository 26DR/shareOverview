package com.company.shareoverview.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ShareData")
public class ShareData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "registered_shares",
            nullable = false
    )
    @OneToMany(mappedBy = "acquiredShareData")
    @JsonManagedReference
    private List<ShareRegistration> registeredShares;

    @Column(
            name = "company_name",
            nullable = false
    )
    @NotEmpty(message = "Company name is mandatory")
    private String companyName;

    @Column(
            name = "share_name",
            nullable = false
    )
    @NotEmpty(message = "Share name is mandatory")
    private String shareName;

    @Column(
            name = "isin",
            nullable = false
    )
    @NotNull(message = "ISIN code is mandatory")
    private String isinCode;

    @Column(
            name = "country",
            nullable = false
    )
    @NotEmpty(message = "Company country is mandatory")
    private String country;

    @Column(
            name = "economic_activity",
            nullable = false
    )
    @NotEmpty(message = "Company field of economic activity is mandatory")
    private String economicActivity;
}
