package VConnect.Respository;
import VConnect.Model.User.Connections;
import VConnect.Model.User.ConnectionsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface ConnectionsRepository extends JpaRepository<Connections, ConnectionsPK> {
}
