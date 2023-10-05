package vn.edu.iuh.fit.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.Role;
import vn.edu.iuh.fit.repositories.RoleRepository;

import java.util.Optional;

public class RoleServices {
    @Inject
    private RoleRepository roleRepository;

    // Thêm xóa sửa Role
    public void insertRole(Role role) {
        roleRepository.insert(role);
    }

    public void updateRole(Role role) {
        roleRepository.update(role);
    }

    public void deleteRole(long role_id) {
        roleRepository.updateStatus(role_id,-1);
    }

    // xem tất cả các quyền
}
