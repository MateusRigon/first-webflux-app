package com.restapi.webflux.repository;

import com.restapi.webflux.document.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {
    Mono<Playlist> findByNome(String nome);
}
