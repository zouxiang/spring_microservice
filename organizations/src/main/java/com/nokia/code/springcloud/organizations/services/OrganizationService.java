package com.nokia.code.springcloud.organizations.services;

import com.nokia.code.springcloud.organizations.events.source.SimpleSourceBean;
import com.nokia.code.springcloud.organizations.model.Organization;
import com.nokia.code.springcloud.organizations.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository orgRepository;

    @Autowired
    SimpleSourceBean simpleSourceBean;

    public Organization getOrg(String organizationId) {
        Optional<Organization> organizationOpt = orgRepository.findById(organizationId);
        return organizationOpt.isPresent()? organizationOpt.get(): null;
    }

    public void saveOrg(Organization org){
        org.setId( UUID.randomUUID().toString());
        orgRepository.save(org);
        simpleSourceBean.publishOrgChange("SAVE", org.getId());
    }

    public void updateOrg(Organization org){
        orgRepository.save(org);
        simpleSourceBean.publishOrgChange("UPDATE", org.getId());

    }

    public void deleteOrg(Organization org){
        orgRepository.delete(org);
        simpleSourceBean.publishOrgChange("DELETE", org.getId());
    }
}
