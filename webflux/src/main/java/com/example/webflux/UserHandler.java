package com.example.webflux;

import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class UserHandler {
    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> getUserById(ServerRequest request) {
        int userId = Integer.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<User> userMono = this.userService.getUserById(userId);
        return userMono.flatMap(person -> ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(person))).switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> getAllUsers() {
        Flux<User> users = this.userService.getAllUser();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(users, User.class);
    }

    public Mono<ServerResponse> saveUser(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build(this.userService.saveUserInfo(userMono));
    }



}