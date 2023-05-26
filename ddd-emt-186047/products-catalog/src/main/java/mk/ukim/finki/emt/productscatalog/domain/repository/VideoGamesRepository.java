package mk.ukim.finki.emt.productscatalog.domain.repository;

import mk.ukim.finki.emt.productscatalog.domain.models.VideoGames;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.VideoGamesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoGamesRepository extends JpaRepository<VideoGames, VideoGamesId> {
}
