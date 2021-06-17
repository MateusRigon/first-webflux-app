package com.restapi.webflux.controller;

import com.restapi.webflux.document.Playlist;
import com.restapi.webflux.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;


@RestController
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @PostMapping(value = "salvarPlaylist")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Playlist> salvarPlaylist(@RequestBody Playlist playlist){
        return this.playlistService.salvarPlaylist(playlist);
    }

}
