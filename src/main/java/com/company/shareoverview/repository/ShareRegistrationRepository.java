package com.company.shareoverview.repository;

import com.company.shareoverview.dto.ShareRegistrationAcquiredByMonthDTO;
import com.company.shareoverview.dto.ShareRegistrationAmountByMonthDTO;
import com.company.shareoverview.model.ShareRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareRegistrationRepository extends JpaRepository<ShareRegistration, Long> {

    @Query(value = "SELECT new com.company.shareoverview.dto.ShareRegistrationAmountByMonthDTO(SUM(s.pricePerShare * s.amountOfSharesAcquired), MONTH(s.acquisitionDate), YEAR(s.acquisitionDate)) " +
            "FROM ShareRegistrations s " +
            "GROUP BY MONTH(s.acquisitionDate), YEAR(s.acquisitionDate)")
    List<ShareRegistrationAmountByMonthDTO> getTotalSpentByMonth();

    @Query(value = "SELECT new com.company.shareoverview.dto.ShareRegistrationAcquiredByMonthDTO(" +
            "YEAR(s.acquisitionDate), MONTH(s.acquisitionDate), d.companyName, d.shareName, d.isinCode, d.country, d.economicActivity, AVG(s.pricePerShare), SUM(s.amountOfSharesAcquired), SUM(s.pricePerShare * s.amountOfSharesAcquired)) " +
            "FROM ShareRegistrations s " +
            "INNER JOIN ShareData d ON s.acquiredShareData = d.id " +
            "GROUP BY MONTH(s.acquisitionDate), YEAR(s.acquisitionDate), d.id")
    List<ShareRegistrationAcquiredByMonthDTO> getAcquiringRecordsByMonth();
}
