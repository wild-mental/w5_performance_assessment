package w3_11_pokemongame_wildmental;

import java.util.HashMap;
import java.util.Map;

public class PokeDex {
    // 포켓몬 정보 관리할 데이터 타입 필드 추가
    static Map<String, Pokemon> pokemonByName = new HashMap<>();
    static Map<String, EvolvedPokemon> evolvedPokemonByName = new HashMap<>();
    static Map<PokeCategory, Map<String, Pokemon>> pokemonByCategory = new HashMap<>();
    static Map<String, String> evolveToPokemon = new HashMap<>();
    static Map<String, String> transcendToPokemon = new HashMap<>();
    static Map<String, MysticPokemon.IMysticActionable> mysticAction = new HashMap<>();

    static {
        // 3. 포켓몬 사전 더미데이터 생성
        // 모든 PokeCategory 값을 키로 하여 내부 Map 을 초기화
        for (PokeCategory category : PokeCategory.values()) {
            pokemonByCategory.put(category, new HashMap<>());
        }
        // 아래에 더미데이터 생성 (매 객체 생성 시 해당 객체로 pokemonByName, pokemonByCategory 둘 다 업데이트 해야 함)
        Pokemon[] dexPokemonArray = {
            new Pokemon("삐삐", 10, PokeCategory.MOON),
            new Pokemon("푸린", 10, PokeCategory.MOON),
            new EvolvedPokemon("픽시", 100, PokeCategory.MOON),
            new EvolvedPokemon("푸크린", 100, PokeCategory.MOON),
            new FlyPokemon("리자몽", 10, PokeCategory.FIRE),
            new SurfPokemon("거북왕", 10, PokeCategory.WATER),
            new MysticPokemon("근육몬", 10, PokeCategory.MYSTIC),
            new EvolvedPokemon("괴력몬", 100, PokeCategory.NORMAL),
            new MysticPokemon("폴리곤", 10, PokeDex.PokeCategory.MYSTIC),
            LegendPokemon.getLegendPokemonForDex("전설의 폴리곤", 10, PokeCategory.LEGENDARY)
        };
        for (Pokemon dexPokemon : dexPokemonArray) {
            pokemonByName
                .put(dexPokemon.getPokemonName(), dexPokemon);
            pokemonByCategory.get(dexPokemon.getPokeCategory())
                .put(dexPokemon.getPokemonName(), dexPokemon);
            if (dexPokemon instanceof EvolvedPokemon) {
                evolvedPokemonByName.put(dexPokemon.getPokemonName(), (EvolvedPokemon) dexPokemon);
            }
        }
        evolveToPokemon.put("삐삐", "픽시");
        evolveToPokemon.put("푸린", "푸크린");
        evolveToPokemon.put("근육몬", "괴력몬");

        transcendToPokemon.put("폴리곤", "전설의 폴리곤");

        // mysticAction 초기화
        mysticAction.put("근육몬", MysticPokemon::evolve);
        mysticAction.put("폴리곤", MysticPokemon::transcend);
    }

    public static MysticPokemon.IMysticActionable getMysticAction(String pokemonName) {
        return mysticAction.get(pokemonName);
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
