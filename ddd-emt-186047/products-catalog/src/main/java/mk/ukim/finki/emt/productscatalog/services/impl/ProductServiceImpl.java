package mk.ukim.finki.emt.productscatalog.services.impl;

import mk.ukim.finki.emt.productscatalog.domain.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt.productscatalog.domain.models.BooksAndComics;
import mk.ukim.finki.emt.productscatalog.domain.models.VideoGames;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.BooksAndComicsId;
import mk.ukim.finki.emt.productscatalog.domain.models.ids.VideoGamesId;
import mk.ukim.finki.emt.productscatalog.domain.repository.BooksAndComicsRepository;
import mk.ukim.finki.emt.productscatalog.domain.repository.VideoGamesRepository;
import mk.ukim.finki.emt.productscatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.productscatalog.services.ProductService;
import mk.ukim.finki.emt.productscatalog.services.form.BooksAndComicsForm;
import mk.ukim.finki.emt.productscatalog.services.form.VideoGamesForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final BooksAndComicsRepository booksAndComicsRepository;
    private final VideoGamesRepository videoGamesRepository;

    public ProductServiceImpl(BooksAndComicsRepository booksAndComicsRepository, VideoGamesRepository videoGamesRepository) {
        this.booksAndComicsRepository = booksAndComicsRepository;
        this.videoGamesRepository = videoGamesRepository;
    }

    @Override
    public BooksAndComics findById(BooksAndComicsId id) {
        return booksAndComicsRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public VideoGames findById(VideoGamesId id) {
        return videoGamesRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public BooksAndComics create(BooksAndComicsForm form) {
        BooksAndComics bc = new BooksAndComics();
        bc.setName(form.getName());
        bc.setPrice(form.getPrice());
        bc.setQuantity(form.getQuantity());
        return booksAndComicsRepository.save(bc);
    }

    @Override
    public VideoGames create(VideoGamesForm form) {
        VideoGames vg = new VideoGames();
        vg.setName(form.getName());
        vg.setPrice(form.getPrice());
        vg.setQuantity(form.getQuantity());
        return videoGamesRepository.save(vg);
    }

    @Override
    public BooksAndComics orderItemCreated(BooksAndComicsId id, int quantity) {
        BooksAndComics bc = booksAndComicsRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        bc.setQuantity(bc.getQuantity() - quantity);
        return booksAndComicsRepository.saveAndFlush(bc);
    }

    @Override
    public BooksAndComics orderItemRemoved(BooksAndComicsId id, int quantity) {
        BooksAndComics bc = booksAndComicsRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        bc.setQuantity(bc.getQuantity() + quantity);
        return booksAndComicsRepository.saveAndFlush(bc);
    }

    @Override
    public VideoGames orderItemCreated(VideoGamesId id, int quantity) {
        VideoGames vg = videoGamesRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        vg.setQuantity(vg.getQuantity() - quantity);
        return videoGamesRepository.saveAndFlush(vg);
    }

    @Override
    public VideoGames orderItemRemoved(VideoGamesId id, int quantity) {
        VideoGames vg = videoGamesRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        vg.setQuantity(vg.getQuantity() + quantity);
        return videoGamesRepository.saveAndFlush(vg);
    }

    @Override
    public List<BooksAndComics> getAllBooksAndComics() {
        return booksAndComicsRepository.findAll();
    }

    @Override
    public List<VideoGames> getAllVideoGames() {
        return videoGamesRepository.findAll();
    }
}
