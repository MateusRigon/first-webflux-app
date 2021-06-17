package com.restapi.webflux.repository;

import com.restapi.webflux.document.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {
}
