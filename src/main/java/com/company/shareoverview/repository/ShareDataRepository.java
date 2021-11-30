package com.company.shareoverview.repository;

import com.company.shareoverview.model.ShareData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareDataRepository extends JpaRepository<ShareData, Long> {
}
