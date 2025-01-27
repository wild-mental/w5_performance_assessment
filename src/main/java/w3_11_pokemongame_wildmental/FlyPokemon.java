package w3_11_pokemongame_wildmental;

import lombok.Getter;

@Getter
public class FlyPokemon extends Pokemon implements IFlyable {
    @Override
    public void fly(String tgCity) {
        System.out.println("Flying to: " + tgCity);
    }

    @Override
    public void crossOcean(String tgCity) {
        fly(tgCity);
    }
}