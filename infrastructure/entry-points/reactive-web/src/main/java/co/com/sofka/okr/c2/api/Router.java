package co.com.sofka.okr.c2.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class Router {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(GET("/api/getokrbyid/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(handler.listenGETUseCase(request.pathVariable("id")), OKRSDTO.class));

    }


   @Bean
    public RouterFunction<ServerResponse> getOkrByIdUser(Handler handler) {
        return route(GET("/api/getuser/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(handler.findUserAllOkr(request.pathVariable("id")),ResponseUserDTO.class));
   }

   @Bean
    public RouterFunction<ServerResponse> getAllUserOkr(Handler handler){
        return route(GET("/api/get").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(handler.getAllOkrByIdUser(), ResponseUserDTO.class)));
   }

   @Bean
    public RouterFunction<ServerResponse> findCompletedOkr(Handler handler){
        return route(GET("/api/completed/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(handler.findByCompleted(request.pathVariable("id")), OKRSDTO.class));
   }

   @Bean
   public RouterFunction<ServerResponse> findProgressOkr(Handler handler){
       return route(GET("/api/progress/{id}").and(accept(MediaType.APPLICATION_JSON)),
               request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                       .body(handler.findByProgress(request.pathVariable("id")), OKRSDTO.class));
   }
}
