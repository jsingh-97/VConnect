package VConnect.Respository;

import VConnect.Model.Auth.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken,Integer> {

    Optional<ConfirmationToken> findByToken(String token);
}
