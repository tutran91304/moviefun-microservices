package org.superbiz.moviefun.albumsapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.superbiz.moviefun.blobstore.BlobStore;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/albumsapi")
public class AlbumsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AlbumsRepository albumsRepository;
    private final BlobStore blobStore;

    public AlbumsController(AlbumsRepository albumsRepository, BlobStore blobStore) {
        this.albumsRepository = albumsRepository;
        this.blobStore = blobStore;
    }

    @GetMapping
    public List<Album> getAll(Map<String, Object> model) {
        return albumsRepository.getAlbums();
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album) {
        this.albumsRepository.addAlbum(album);
    }

    @GetMapping("/{albumId}")
    public Album details(@PathVariable long albumId, Map<String, Object> model) {
        return albumsRepository.find(albumId);
    }

}


