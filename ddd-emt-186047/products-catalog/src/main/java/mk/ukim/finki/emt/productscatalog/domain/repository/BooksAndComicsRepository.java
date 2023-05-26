package mk.ukim.finki.emt.productscatalog.domain.repository;

import mk.ukim.finki.emt.productscatalog.domain.models.BooksAndComics;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.BooksAndComicsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksAndComicsRepository extends JpaRepository<BooksAndComics, BooksAndComicsId> {
}
