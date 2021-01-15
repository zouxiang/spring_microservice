package com.nokia.code.springcloud.organizations.repository;

import com.nokia.code.springcloud.organizations.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, String> {
    public Optional<Organization> findById(String organizationId);
}
