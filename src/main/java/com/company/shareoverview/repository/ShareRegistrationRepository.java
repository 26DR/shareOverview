package com.company.shareoverview.repository;

import com.company.shareoverview.model.ShareRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareRegistrationRepository extends JpaRepository<ShareRegistration, Long> {
}
