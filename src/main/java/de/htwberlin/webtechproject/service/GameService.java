package de.htwberlin.webtechproject.service;

import de.htwberlin.webtechproject.persistence.Console;
import de.htwberlin.webtechproject.persistence.Genre;
import de.htwberlin.webtechproject.persistence.GameEntity;
import de.htwberlin.webtechproject.persistence.GameRepository;
import de.htwberlin.webtechproject.web.api.Game;
import de.htwberlin.webtechproject.web.api.GameManipulationRequest;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll(){
        List<GameEntity> games = gameRepository.findAll();
        return games.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Game findById(Long id){
        var gameEntity = gameRepository.findById(id);
        return gameEntity.map(this::transformEntity).orElse(null);
    }

    public Game create(GameManipulationRequest request){
        var genre = Genre.valueOf(request.getGenre());
        var console = Console.valueOf(request.getConsole());
        var gameEntity = new GameEntity(request.getTitle(), console, request.getReleaseYear(), request.getStartDate(), request.getFinished(), request.getFavorised(), request.getComment(), genre);
        gameEntity = gameRepository.save(gameEntity);
        return transformEntity(gameEntity);
    }


    public Game update(Long id, GameManipulationRequest request){
        var gameEntityOptional = gameRepository.findById(id);
        if (gameEntityOptional.isEmpty()) {
            return null;
        }

        var gameEntity = gameEntityOptional.get();
        gameEntity.setTitle(request.getTitle());
        gameEntity.setConsole(Console.valueOf(request.getConsole()));
        gameEntity.setReleaseYear(request.getReleaseYear());
        gameEntity.setStartDate(request.getStartDate());
        gameEntity.setFinished(request.getFinished());
        gameEntity.setFavorised(request.getFavorised());
        gameEntity.setComment(request.getComment());
        gameEntity.setGenre(Genre.valueOf(request.getGenre()));
        gameEntity = gameRepository.save(gameEntity);

        return transformEntity(gameEntity);
    }

    public boolean deleteById(Long id){
        if (!gameRepository.existsById(id)) {
            return false;
        }
        gameRepository.deleteById(id);
        return true;
    }

    private Game transformEntity(GameEntity gameEntity) {
        return new Game(
                gameEntity.getId(),
                gameEntity.getTitle(),
                gameEntity.getConsole() != null ? gameEntity.getConsole().name() : "PlayStation",
                gameEntity.getReleaseYear(),
                gameEntity.getStartDate(),
                gameEntity.getFinished(),
                gameEntity.getFavorised(),
                gameEntity.getComment(),
                gameEntity.getGenre() != null ? gameEntity.getGenre().name() : "ACTION"
        );
    }
}
