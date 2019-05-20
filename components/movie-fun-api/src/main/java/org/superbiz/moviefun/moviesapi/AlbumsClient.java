package org.superbiz.moviefun.moviesapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestOperations;
import org.superbiz.moviefun.albumsapi.AlbumInfo;

import java.util.List;

public class AlbumsClient {
    String albumsUrl;
    RestOperations restOperations;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public AlbumsClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }

    public List<AlbumInfo> getAlbums() {
        return this.restOperations.getForObject(this.albumsUrl, List.class);
    }


    public void addAlbum(AlbumInfo album) {
        this.restOperations.postForEntity(this.albumsUrl, album, AlbumInfo.class);
    }

    public Object find(long albumId) {
        return this.restOperations.getForObject(this.albumsUrl + "/" + albumId, AlbumInfo.class);
    }
}
