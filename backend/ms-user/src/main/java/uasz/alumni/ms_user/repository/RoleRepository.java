package uasz.alumni.ms_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uasz.alumni.ms_user.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}
