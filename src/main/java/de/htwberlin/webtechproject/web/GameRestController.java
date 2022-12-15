package de.htwberlin.webtechproject.web;

import de.htwberlin.webtechproject.service.GameService;
import de.htwberlin.webtechproject.web.api.Game;
import de.htwberlin.webtechproject.web.api.GameManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class GameRestController {

    private final GameService gameService;

    public GameRestController(GameService gameService) {
        this.gameService = gameService;
    }
    @GetMapping(path = "/api/v1/games")
    public ResponseEntity<List<Game>> fetchGames() {
        return ResponseEntity.ok(gameService.findAll());
    }

    @GetMapping(path = "/api/v1/games/{id}")
    public ResponseEntity<Game> fetchGameById(@PathVariable Long id){
        var game = gameService.findById(id);
        return game != null? ResponseEntity.ok(game) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/games")
        public ResponseEntity<Void> createGame(@RequestBody GameManipulationRequest request) throws URISyntaxException {
        var game = gameService.create(request);
        URI uri = new URI("/api/v1/games/" + game.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/games/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody GameManipulationRequest request){
        var game = gameService.update(id, request);
        return game != null? ResponseEntity.ok(game) : ResponseEntity.notFound().build();

    }

    @DeleteMapping(path = "/api/v1/games/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        boolean successful = gameService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
