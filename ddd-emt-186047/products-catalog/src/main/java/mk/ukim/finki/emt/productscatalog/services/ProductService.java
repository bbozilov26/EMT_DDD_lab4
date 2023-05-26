package mk.ukim.finki.emt.productscatalog.services;

import mk.ukim.finki.emt.productscatalog.domain.models.BooksAndComics;
import mk.ukim.finki.emt.productscatalog.domain.models.VideoGames;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.BooksAndComicsId;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.VideoGamesId;
import mk.ukim.finki.emt.productscatalog.services.form.BooksAndComicsForm;
import mk.ukim.finki.emt.productscatalog.services.form.VideoGamesForm;

import java.util.List;

public interface ProductService {

    BooksAndComics findById(BooksAndComicsId id);
    VideoGames findById(VideoGamesId id);
    BooksAndComics create(BooksAndComicsForm form);
    VideoGames create(VideoGamesForm form);
    BooksAndComics orderItemCreated(BooksAndComicsId id, int quantity);
    BooksAndComics orderItemRemoved(BooksAndComicsId id, int quantity);
    VideoGames orderItemCreated(VideoGamesId id, int quantity);
    VideoGames orderItemRemoved(VideoGamesId id, int quantity);
    List<BooksAndComics> getAllBooksAndComics();
    List<VideoGames> getAllVideoGames();
}
