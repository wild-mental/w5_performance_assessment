package w3_11_pokemongame_wildmental;

public class GameLauncher {
    public static void main(String[] args) {
        // 1. 더미데이터 생성
        // 1-1. 마을 데이터 (태초마을, 달맞이 동산)
        PokeTown initTown = new PokeTown(
            "태초마을", "모험이 시작되는 위치입니다.", true);
        PokeTown moonHill = new PokeTown(
            "달맞이동산", "달포켓몬들의 성지입니다.", false);
        // 1-2. 트레이너 (트레이드 주체 및 대상)
        Trainer trainer1 = new Trainer("Player", initTown);
        Trainer trainer2 = new Trainer("Opponent", moonHill);
        // 1-3. 소지 포켓몬 (Normal, Fly-Legendary, Moon, Mystic)
        Pokemon[] trainer1Pokemon = {
            new MysticPokemon("근육몬", "내신비의근육몬0", 10, PokeDex.PokeCategory.MYSTIC),
            new MysticPokemon("근육몬", "내신비의근육몬1", 10, PokeDex.PokeCategory.MYSTIC),
            new MysticPokemon("근육몬", "내신비의근육몬2", 10, PokeDex.PokeCategory.MYSTIC),
            new MysticPokemon("근육몬", "내신비의근육몬3", 10, PokeDex.PokeCategory.MYSTIC),
            new MysticPokemon("근육몬", "내신비의근육몬4", 10, PokeDex.PokeCategory.MYSTIC)
        };
        trainer1.addPokemon(trainer1Pokemon);
        Pokemon[] trainer2Pokemon = {
            new MysticPokemon("폴리곤", "니신비의폴리곤0", 10, PokeDex.PokeCategory.MYSTIC),
            new MysticPokemon("폴리곤", "니신비의폴리곤1", 10, PokeDex.PokeCategory.MYSTIC),
            new MysticPokemon("폴리곤", "니신비의폴리곤2", 10, PokeDex.PokeCategory.MYSTIC),
            new MysticPokemon("폴리곤", "니신비의폴리곤3", 10, PokeDex.PokeCategory.MYSTIC),
            new MysticPokemon("폴리곤", "니신비의폴리곤4", 10, PokeDex.PokeCategory.MYSTIC)
        };
        trainer2.addPokemon(trainer2Pokemon);

        // Scenario 1
        // 대륙 간 횡단을 통해 달맞이 동산으로 이동

        // Scenario 2
        // 트레이드 수행 시 신비의 포켓몬이 신비한 동작 수행
        trainer1.trade(trainer2);

        // 전설의 포켓몬 발생 테스트
        for (int i = 0; i < 5; i++) {
            LegendPokemon newLegend = LegendPokemon.getLegend("전설의 폴리곤", "니신비의폴리곤");
            if (newLegend == null) {
                System.out.println("레전드 찾기 실패");
            } else {
                System.out.println("레전드 : " + newLegend);
            }
        }
    }
}
