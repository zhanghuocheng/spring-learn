package com.example.webflux;

import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

@Component
public class Server {

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    public void createReactorServer() {
        RouterFunction<ServerResponse> route = routingFunction();
        HttpHandler httpHandler = toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();
    }


    public RouterFunction<ServerResponse> routingFunction() {
        UserService userService = new UserServiceImpl();
        UserHandler handler = new UserHandler(userService);
        return RouterFunctions.route(GET("/users/{id}").and(accept(APPLICATION_JSON)), handler::getUserById)
                .andRoute(GET("/users").and(accept(APPLICATION_JSON)), (HandlerFunction<ServerResponse>) handler.getAllUsers());
    }

}
