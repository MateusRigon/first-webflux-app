package com.restapi.webflux.service;

import com.restapi.webflux.document.Playlist;
import com.restapi.webflux.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RepositoryHandler {

    @Autowired
    private PlaylistRepository playlistRepository;


    public Mono<Playlist> salvarPlaylist(Playlist playlist){
        return this.playlistRepository.save(playlist);
    }

    public Mono<Playlist> retornaPlaylist(String id) {
        return this.playlistRepository.findById(id);
    }

    public Flux<Playlist> retornaTodasPlaylists() {
        return this.playlistRepository.findAll();
    }
}
