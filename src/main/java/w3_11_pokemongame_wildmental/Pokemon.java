package w3_11_pokemongame_wildmental;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Pokemon implements IPokemon {
    private String pokemonName;
    private String customName;
    private int HP;
    @Setter
    private PokeDex.PokeCategory pokeCategory;

    public Pokemon(String pokemonName, int HP, PokeDex.PokeCategory pokeCategory) {
        this.pokemonName = pokemonName;
        this.HP = HP;
        this.pokeCategory = pokeCategory;
    }

    public Pokemon(String pokemonName, String customName, int HP, PokeDex.PokeCategory pokeCategory) {
        this.pokemonName = pokemonName;
        this.customName = customName;
        this.HP = HP;
        this.pokeCategory = pokeCategory;
    }

    @Override
    public void attack(Pokemon tgPokemon) {
        // 데이터 및 동작 : tgPokemon.getHP(), tgPokemon.setHP()
        // 그 외 추가 동작 및 결과 출력
    }

    @Override
    public void flee(int enemyLv) {
        // 결과 출력
    }

    @Override
    public Pokemon evolve() {
        // 데이터 및 동작
        // : this.getLevel()
        // : this.setters()
        // 기존 객체 참조 삭제
        // 진화된 객체 생성 및 리턴
        return new EvolvedPokemon( // TODO : 진화형 정보로 수정 필요 (Dex 에서 검색)
            this.pokemonName, this.customName, this.HP, this.pokeCategory
        );
        // 리턴 타입은 부모 타입으로 선언되어 있는데
        // 실제 리턴 객체는 자식 타입으로 반환
        // => 다형성에 따른 부모 타입으로의 변환
    }
}