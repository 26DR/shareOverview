package com.company.shareoverview.repository;

import com.company.shareoverview.dto.ShareRegistrationAcquiredByMonthDTO;
import com.company.shareoverview.dto.ShareRegistrationAmountByMonthDTO;
import com.company.shareoverview.dto.ShareRegistrationStatisticByMonthDTO;
import com.company.shareoverview.model.ShareRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareRegistrationRepository extends JpaRepository<ShareRegistration, Long> {

    @Query(value = "SELECT new com.company.shareoverview.dto.ShareRegistrationAmountByMonthDTO(SUM(s.pricePerShare * s.amountOfSharesAcquired), MONTH(s.acquisitionDate), YEAR(s.acquisitionDate)) " +
            "FROM ShareRegistrations s " +
            "GROUP BY MONTH(s.acquisitionDate), YEAR(s.acquisitionDate)")
    List<ShareRegistrationAmountByMonthDTO> getTotalSpentByMonth();

    @Query(value = "SELECT new com.company.shareoverview.dto.ShareRegistrationAmountByMonthDTO(SUM(s.pricePerShare * s.amountOfSharesAcquired), MONTH(s.acquisitionDate), YEAR(s.acquisitionDate)) " +
            "FROM ShareRegistrations s " +
            "WHERE s.acquirerEmployeeId = :employeeId " +
            "GROUP BY MONTH(s.acquisitionDate), YEAR(s.acquisitionDate)")
    List<ShareRegistrationAmountByMonthDTO> getTotalSpentByMonth(@Param("employeeId") Long employeeId);

    @Query(value = "SELECT new com.company.shareoverview.dto.ShareRegistrationAcquiredByMonthDTO(" +
            "YEAR(s.acquisitionDate), MONTH(s.acquisitionDate), d.companyName, d.shareName, d.isinCode, d.country, d.economicActivity, AVG(s.pricePerShare), SUM(s.amountOfSharesAcquired), SUM(s.pricePerShare * s.amountOfSharesAcquired)) " +
            "FROM ShareRegistrations s " +
            "INNER JOIN ShareData d ON s.acquiredShareData = d.id " +
            "GROUP BY MONTH(s.acquisitionDate), YEAR(s.acquisitionDate), d.id")
    List<ShareRegistrationAcquiredByMonthDTO> getAcquiringRecordsByMonth();

    @Query(value = "SELECT new com.company.shareoverview.dto.ShareRegistrationAcquiredByMonthDTO(" +
            "YEAR(s.acquisitionDate), MONTH(s.acquisitionDate), d.companyName, d.shareName, d.isinCode, d.country, d.economicActivity, AVG(s.pricePerShare), SUM(s.amountOfSharesAcquired), SUM(s.pricePerShare * s.amountOfSharesAcquired)) " +
            "FROM ShareRegistrations s " +
            "INNER JOIN ShareData d ON s.acquiredShareData = d.id " +
            "WHERE s.acquirerEmployeeId = :employeeId " +
            "GROUP BY MONTH(s.acquisitionDate), YEAR(s.acquisitionDate), d.id")
    List<ShareRegistrationAcquiredByMonthDTO> getAcquiringRecordsByMonth(@Param("employeeId") Long employeeId);

    @Query(value = "SELECT new com.company.shareoverview.dto.ShareRegistrationStatisticByMonthDTO(" +
            "YEAR(s.acquisitionDate), MONTH(s.acquisitionDate), d.companyName, d.shareName, d.isinCode, d.country, d.economicActivity, SUM(s.amountOfSharesAcquired), AVG(s.pricePerShare), SUM(s.pricePerShare * s.amountOfSharesAcquired), s.acquirerEmployeeId) " +
            "FROM ShareRegistrations s " +
            "INNER JOIN ShareData d ON s.acquiredShareData = d.id " +
            "WHERE MONTH(s.acquisitionDate) = :month " +
            "GROUP BY MONTH(s.acquisitionDate), YEAR(s.acquisitionDate), d.id")
    List<ShareRegistrationStatisticByMonthDTO> getStatisticsByMonth(@Param("month") int month);

    @Query(value = "SELECT new com.company.shareoverview.dto.ShareRegistrationStatisticByMonthDTO(" +
            "YEAR(s.acquisitionDate), MONTH(s.acquisitionDate), d.companyName, d.shareName, d.isinCode, d.country, d.economicActivity, SUM(s.amountOfSharesAcquired), AVG(s.pricePerShare), SUM(s.pricePerShare * s.amountOfSharesAcquired), s.acquirerEmployeeId) " +
            "FROM ShareRegistrations s " +
            "INNER JOIN ShareData d ON s.acquiredShareData = d.id " +
            "WHERE MONTH(s.acquisitionDate) = :month AND s.acquirerEmployeeId = :employeeId " +
            "GROUP BY MONTH(s.acquisitionDate), YEAR(s.acquisitionDate), d.id")
    List<ShareRegistrationStatisticByMonthDTO> getStatisticsByMonth(@Param("month") int month, @Param("employeeId") Long employeeId);
}
