package VConnect.Respository;

import VConnect.Model.Feed.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedRepository extends JpaRepository<Feed,Integer> {
    @Query(value = "Select * from userfeed where email IN :emailList ",nativeQuery = true)
    List<Feed> findByEmail(@Param("emailList") List<String> followee);
}
