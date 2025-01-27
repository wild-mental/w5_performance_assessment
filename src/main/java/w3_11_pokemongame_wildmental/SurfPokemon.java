package w3_11_pokemongame_wildmental;

import lombok.Getter;

@Getter
public class SurfPokemon extends Pokemon implements ISurfable {
    @Override
    public void surf(String tgCity) {
        System.out.println("Surfing to: " + tgCity);
    }

    @Override
    public void crossOcean(String tgCity) {
        surf(tgCity);
    }
}
