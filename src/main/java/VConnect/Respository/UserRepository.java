package VConnect.Respository;

import VConnect.Model.Auth.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepository extends JpaRepository<UserData,String> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE userdata "+"SET enabled = TRUE WHERE email=:email",nativeQuery = true)
    void verifyUser(@Param("email") String email);
}
