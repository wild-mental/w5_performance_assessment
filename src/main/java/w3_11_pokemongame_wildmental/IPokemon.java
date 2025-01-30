package w3_11_pokemongame_wildmental;

public interface IPokemon {
    // attack
    void attack(Pokemon tgPokemon);
    // flee
    void flee(int enemyLv);
    // evolve : 향후 오버로딩 가능
    Pokemon evolve();
}
