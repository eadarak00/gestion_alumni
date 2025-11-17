package uasz.alumni.ms_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uasz.alumni.ms_user.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}
