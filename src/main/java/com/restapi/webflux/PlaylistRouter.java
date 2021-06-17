package com.restapi.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

//@Configuration
public class PlaylistRouter {

//    @Bean
    public RouterFunction<ServerResponse> router(PlaylistHandler handler){
        return RouterFunctions
                .route(POST("salvarPlaylist")
                        .and(accept(MediaType.APPLICATION_JSON)), handler::salvarPlaylist);

    }
}
