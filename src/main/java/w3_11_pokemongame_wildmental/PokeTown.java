package w3_11_pokemongame_wildmental;

import lombok.Getter;

@Getter
public class PokeTown {
    private String name;
    private String introduction;
    private boolean walkable;

    public PokeTown(String name, String introduction, boolean walkable) {
        this.name = name;
        this.introduction = introduction;
        this.walkable = walkable;
    }
}
