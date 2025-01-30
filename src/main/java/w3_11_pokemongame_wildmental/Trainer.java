package w3_11_pokemongame_wildmental;

import lombok.Getter;

import java.util.*;

@Getter
public class Trainer implements ITrainer {
    String name;
    List<Pokemon> capturedPokemonList = new ArrayList<>();
    Map<String, Pokemon> capturedPokemonByName = new HashMap<>();
    Scanner inputReader = new Scanner(System.in);
    PokeTown currentLocation;

    public Trainer(String name, PokeTown currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    public void addPokemon(Pokemon pokemon) {
        capturedPokemonList.add(pokemon);
    }

    public void addPokemon(Pokemon[] pokemon) {
        capturedPokemonList.addAll(Arrays.asList(pokemon));
    }

    @Override
    public void hunt(Pokemon wildPokemon) {
        System.out.println("야생의 포켓몬 " + wildPokemon.getPokemonName() + "을(를) 만났습니다!");
        // 야생의 포켓몬을 만나서 싸우거나 잡거나 그냥 지나가거나
        System.out.println("1: battle / 2: capture / else: pass");
        int battleOrCapture = inputReader.nextInt();
        switch (battleOrCapture) {
            case 1:
                battle(wildPokemon);
                break;
            case 2:
                capture(wildPokemon);
                Pokemon capturedPokemon = capture(wildPokemon);
                if (capturedPokemon != null) {
                    capturedPokemonList.add(capturedPokemon);
                    capturedPokemonByName.put(
                        capturedPokemon.getPokemonName(), capturedPokemon
                    );
                }
                break;
            default:
                System.out.println("야생의 포켓몬 " + wildPokemon.getPokemonName() + "을(를) 그냥 지나갑니다.");
                break;
        }
    }

    @Override
    public Pokemon capture(Pokemon wildPokemon) {
        // 확률적 포획 성공 (가중치를 적용)
        // 몬스터볼 소진 등은 TBD
        return wildPokemon; //  100% 포획
    }

    @Override
    public void battle(Pokemon wildPokemon) {
        // Pokemon 에 대한 getter(), setter() 호출
        // this.getCapturedPokemonList() 등 호출
        List<Pokemon> myLineUp = this.getCapturedPokemonList();
        for (Pokemon pokemon: myLineUp) {
            while (((pokemon.getHP()!=0) && (wildPokemon.getHP()!=0))) {
                pokemon.attack(wildPokemon);
                wildPokemon.attack(pokemon);
            }
        }
        // 결과 출력
        if (wildPokemon.getHP()==0) {
            System.out.println("Win!");
        } else {
            System.out.println("Lost!");
        }
    }

    @Override
    public void battle(Trainer enemyTrainer) {
        //
    }

    @Override
    public Pokemon searchDex(String pokemonName) {
        return PokeDex.searchPokemon(pokemonName);
    }

    @Override
    public Map<String, Pokemon> searchDex(PokeDex.PokeCategory category) {
        return PokeDex.searchPokemon(category);
    }

    @Override
    public void trade(Trainer tgTrainer) {
        // 1. 포켓몬 선택
        System.out.println("-- Your Pokemon List --");
        for (int i = 0; i < this.capturedPokemonList.size(); i++) {
            System.out.println(i + ": " + this.capturedPokemonList.get(i));
        }
        System.out.println("-----------------------");
        System.out.println("choose your pokemon to trade: ");
        int choiceMine = inputReader.nextInt();
        Pokemon myPokemon = this.capturedPokemonList.get(choiceMine);
        System.out.println("-- Target Pokemon List --");
        for (int i = 0; i < tgTrainer.capturedPokemonList.size(); i++) {
            System.out.println(i + ": " + tgTrainer.capturedPokemonList.get(i));
        }
        System.out.println("------------------------");
        System.out.println("choose target pokemon to trade: ");
        int choiceTg = inputReader.nextInt();
        Pokemon tgPokemon = tgTrainer.capturedPokemonList.get(choiceTg);

        // 2. 선택 확인
        System.out.println(
            "Are you sure to trade your pokemon \n\t" +
            this.capturedPokemonList.get(choiceMine) +
            "\nwith \n\t" +
            tgTrainer.capturedPokemonList.get(choiceTg) + "\nfor sure? (y/n)"
        );

        // 3. 트레이드 수행
        if (!inputReader.next().equals("y")) {
            System.out.println("== Trade cancelled ==");
            return;
        }
        tgTrainer.capturedPokemonList.set(choiceTg, myPokemon);
        this.capturedPokemonList.set(choiceMine, tgPokemon);
        // 4. 특수 이벤트 트리거
        if (tgPokemon instanceof MysticPokemon myMystic) {
            this.capturedPokemonList.set(choiceMine,
                myMystic.getMysticAction().triggerMysticAction(myMystic)
            );
        }
        if (myPokemon instanceof MysticPokemon tgMystic) {
            tgTrainer.capturedPokemonList.set(choiceTg,
                tgMystic.getMysticAction().triggerMysticAction(tgMystic)
            );
        }
        System.out.println("== Trade complete! ==");
        System.out.println("my pokemon list: " + this.capturedPokemonList);
        System.out.println("tg pokemon list: " + tgTrainer.capturedPokemonList);
    }

    public void crossOcean(String tgCity) {
        for (Pokemon pokemon: this.getCapturedPokemonList()) {
            if (pokemon instanceof IOceanCrossable) {
                ((IOceanCrossable) pokemon).crossOcean(tgCity);
                return;
            }
        }
        System.out.println("소지 포켓몬 중 바다 횡단이 가능한 포켓몬이 없습니다");
    }
}