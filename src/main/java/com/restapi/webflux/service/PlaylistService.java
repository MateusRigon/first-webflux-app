package com.restapi.webflux.service;

import com.restapi.webflux.document.Playlist;
import com.restapi.webflux.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public Mono<Playlist> salvarPlaylist(Playlist playlist){
        return this.playlistRepository.save(playlist);
    }
}
