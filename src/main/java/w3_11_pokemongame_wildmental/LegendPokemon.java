package w3_11_pokemongame_wildmental;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LegendPokemon extends Pokemon {
    private static final Map<String, Boolean> legendExists = new HashMap<>();

    private LegendPokemon(String pokemonName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, HP, pokeCategory);
    }

    private LegendPokemon(String pokemonName, String customName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, customName, HP, pokeCategory);
    }

    public static LegendPokemon getLegendPokemonForDex(String pokemonName, int HP, PokeDex.PokeCategory pokeCategory) {
        return new LegendPokemon(pokemonName, HP, pokeCategory);
    }

    public static LegendPokemon getLegend(String legendName, String customName) {
        if (legendExists.getOrDefault(legendName, false)) return null;
        Pokemon dexLegend = PokeDex.pokemonByCategory.get(PokeDex.PokeCategory.LEGENDARY).get(legendName);
        if (dexLegend == null) return null;
        LegendPokemon newLegend = new LegendPokemon(dexLegend.getPokemonName(), customName, dexLegend.getHP(), dexLegend.getPokeCategory());
        legendExists.put(legendName, true);
        return newLegend;
    }
}
