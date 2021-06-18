package com.restapi.webflux.service;

import com.restapi.webflux.document.Playlist;
import com.restapi.webflux.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.UUID;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public Mono<Playlist> salvarPlaylist(Playlist playlist){
        playlist.setId(UUID.randomUUID().toString());

        return playlistRepository.findByNome(playlist.getNome())
                .flatMap(exist -> Mono.error(new Exception(String.valueOf(HttpStatus.CONFLICT))))
                .switchIfEmpty(Mono.defer(() -> playlistRepository.save(playlist)))
                .cast(Playlist.class);
    }

    public Mono<Playlist> retornaPlaylist(String id) {
        return this.playlistRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception(String.valueOf(HttpStatus.NOT_FOUND))));
    }

    public Flux<Tuple2<Long, Playlist>> retornaTodasPlaylists() {

        Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
        Flux<Playlist> playlistFlux = this.playlistRepository.findAll()
                .switchIfEmpty(Mono.error(new Exception(String.valueOf(HttpStatus.NOT_FOUND))));

        return Flux.zip(interval, playlistFlux);
    }
}
