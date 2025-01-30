package w3_11_pokemongame_wildmental;

import lombok.Getter;

@Getter
public class PokeTown {
    private String name;
    private String introduction;
    private boolean walkable;
    private ITownEvent townEvent;

    public PokeTown(String name, String introduction, boolean walkable) {
        this.name = name;
        this.introduction = introduction;
        this.walkable = walkable;
    }

    // OverLoading
    public PokeTown(String name, String introduction, boolean walkable, ITownEvent townEvent) {
        this.name = name;
        this.introduction = introduction;
        this.walkable = walkable;
        this.townEvent = townEvent;
    }

    @FunctionalInterface
    public interface ITownEvent{
        void triggerTownEvent(Trainer trainer);
    };
}
