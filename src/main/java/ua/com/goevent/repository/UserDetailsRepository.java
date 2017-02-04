package ua.com.goevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.goevent.model.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    UserDetails findByUsername(String username);
}