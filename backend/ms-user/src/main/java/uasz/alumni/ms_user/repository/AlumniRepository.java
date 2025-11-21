package uasz.alumni.ms_user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uasz.alumni.ms_user.model.Alumni;


@Repository
public interface AlumniRepository extends JpaRepository<Alumni, Long> {

}
