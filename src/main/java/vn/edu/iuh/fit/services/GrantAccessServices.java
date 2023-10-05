package vn.edu.iuh.fit.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.GrantAccess;
import vn.edu.iuh.fit.repositories.GrantAccessRepository;

public class GrantAccessServices {
    @Inject
    private GrantAccessRepository grantAccessRepository;

    // Thêm sửa GrantAccess
    private void insertGrantAccess(GrantAccess grantAccess) {
        grantAccessRepository.insert(grantAccess);
    }

    private void updateGrantAccess(GrantAccess grantAccess) {
        grantAccessRepository.insert(grantAccess);
    }
}
