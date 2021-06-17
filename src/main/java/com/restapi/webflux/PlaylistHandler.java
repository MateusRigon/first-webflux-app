package com.restapi.webflux;

import com.restapi.webflux.document.Playlist;
import com.restapi.webflux.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

//@Component
public class PlaylistHandler {

    @Autowired
    private PlaylistService playlistService;

    public Mono<ServerResponse> salvarPlaylist(ServerRequest request){
        final Mono<Playlist> playlistMono = request.bodyToMono(Playlist.class);

        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playlistMono.flatMap(playlistService::salvarPlaylist), Playlist.class));
    }
}
