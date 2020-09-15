package com.devsuperior.dspesquisa.dto;

import java.io.Serializable;

import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.entities.enums.Platform;

public class GameDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    public Long id;
    public String title;
    public Platform platform;

    public GameDTO() {
    }

    public GameDTO(Game game) {
        this.id=game.getId();
        this.title=game.getTitle();
        this.platform=game.getPlatform();
    }

    
}
