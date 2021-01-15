package com.nokia.code.springcloud.licenses.repository;

import com.nokia.code.springcloud.licenses.model.License;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class LicenseRepository {

    public List<License> findByOrganizationId(String organizationId) {
        return Collections.emptyList();
    }
}
