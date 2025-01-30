package w3_11_pokemongame_wildmental;

import lombok.Getter;

@Getter
public class SurfPokemon extends Pokemon implements ISurfable {
    public SurfPokemon(String pokemonName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, HP, pokeCategory);
    }

    public SurfPokemon(String pokemonName, String customName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, customName, HP, pokeCategory);
    }

    @Override
    public void surf(String tgCity) {
        System.out.println("Surfing to: " + tgCity);
    }

    @Override
    public void crossOcean(String tgCity) {
        surf(tgCity);
    }
}
