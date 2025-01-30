package w3_11_pokemongame_wildmental;

import lombok.Getter;

import java.util.Random;

public class MysticPokemon extends Pokemon {
    @Getter
    IMysticActionable mysticAction;
    private final int mysticDiceFactor = new Random().nextInt(1, 7);

    public MysticPokemon(String pokemonName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, HP, pokeCategory);
    }

    public MysticPokemon(String pokemonName, String customName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, customName, HP, pokeCategory);
        this.mysticAction = PokeDex.getMysticAction(pokemonName);
    }

    @FunctionalInterface
    public interface IMysticActionable {
        Pokemon triggerMysticAction(MysticPokemon mysticPokemon);
    }

    @Override
    public Pokemon evolve() {
        System.out.println(
            "[" + this.getPokemonName() + " tries to evolve with mystic chance!]"
        );
        int diceVal = new Random().nextInt(1, 7);
        System.out.println("== Target Value for Mystic Action is: " + mysticDiceFactor + " ==");
        System.out.println("== Dice Value for Mystic Action is: " + diceVal + " ==");
        if (mysticDiceFactor == diceVal) {
            return super.evolve();
        }
        System.out.println("Your Mystic Pokemon " + this.getPokemonName() + " didn't evolve");
        return this;
    }

    public Pokemon transcend() {
        System.out.println(
            "[" + this.getPokemonName() + " tries to break the limit with mystic chance!]"
        );
        int diceVal = new Random().nextInt(1, 7);
        System.out.println("== Target Value for Mystic Action is: " + mysticDiceFactor + " ==");
        System.out.println("== Dice Value for Mystic Action is: " + diceVal + " ==");
        if (mysticDiceFactor == diceVal) {
            // this.setPokeCategory(PokeDex.PokeCategory.LEGENDARY);
            // System.out.println("Your Mystic Pokemon " + this.getPokemonName() + " is now legendary");
            // return this;

            String transcendTo = PokeDex.transcendToPokemon.get("폴리곤");
            LegendPokemon transcended = LegendPokemon.getLegend(transcendTo, this.getCustomName());
            if (transcended != null) {
                System.out.println("Your Mystic Pokemon " + this.getPokemonName() + " is now legendary");
                return transcended;
            }
        }
        System.out.println("Your Mystic Pokemon " + this.getPokemonName() + " didn't change");
        return this;
    }
}
