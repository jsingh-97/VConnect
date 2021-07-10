package VConnect.Respository;
import VConnect.Model.Auth.UserData;
import VConnect.Model.User.Connections;
import VConnect.Model.User.ConnectionsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ConnectionsRepository extends JpaRepository<Connections, ConnectionsPK> {
    @Query(value="Select follower FROM connections where followee=:email",nativeQuery = true)
    List<String> findByEmail(@Param("email") String email);
}
