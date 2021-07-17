package VConnect.Respository;

import VConnect.Model.Auth.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken,Integer> {

    ConfirmationToken findByToken(String token);
    @Modifying
    @Transactional
    @Query(value = "UPDATE confirmationtoken "+"SET confirmed_at =:time "+"WHERE token = :token",nativeQuery = true)
    void setConfirmedAt(@Param("token") String token,@Param("time") LocalDateTime time);
}
