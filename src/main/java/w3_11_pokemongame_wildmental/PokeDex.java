package w3_11_pokemongame_wildmental;


import java.util.HashMap;
import java.util.Map;

public class PokeDex {
    // 포켓몬 정보 관리할 데이터 타입 필드 추가
    static Map<String, Pokemon> pokemonByName = new HashMap<>();
    static Map<PokeCategory, Map<String, Pokemon>> pokemonByCategory = new HashMap<>();

    static {
        // 3. 포켓몬 사전 더미데이터 생성
        // 모든 PokeCategory 값을 키로 하여 내부 Map 을 초기화
        for (PokeCategory category : PokeCategory.values()) {
            pokemonByCategory.put(category, new HashMap<>());
        }
        // 아래에 더미데이터 생성 (매 객체 생성 시 해당 객체로 pokemonByName, pokemonByCategory 둘 다 업데이트 해야 함)
        Pokemon[] dexPokemonArray = {
            new Pokemon("삐삐", 10, PokeDex.PokeCategory.MOON),
            new Pokemon("푸린", 10, PokeDex.PokeCategory.MOON),
            new FlyPokemon("팔색조", 10, PokeDex.PokeCategory.LEGENDARY)
        };
        for (Pokemon dexPokemon : dexPokemonArray) {
            pokemonByName
                .put(dexPokemon.getPokemonName(), dexPokemon);
            pokemonByCategory.get(dexPokemon.getPokeCategory())
                .put(dexPokemon.getPokemonName(), dexPokemon);
        }
    }

    public enum PokeCategory {
        NORMAL,
        WATER, FIRE, EARTH, ELECTRIC,
        SKY, MOON,
        LEGENDARY, MYSTIC
    }

    public static Pokemon searchPokemon(String name) {
        return pokemonByName.get(name);
    }
    public static Map<String, Pokemon> searchPokemon(PokeCategory category) {
        return pokemonByCategory.get(category);
    }
    // 아래 기능 필요 없음
//    public static Pokemon searchPokemon(PokeCategory category, String name) {
//        return searchPokemon(category).get(name);
//    };
}
