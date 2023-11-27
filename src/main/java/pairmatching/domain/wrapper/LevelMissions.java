package pairmatching.domain.wrapper;

import java.util.Arrays;
import java.util.List;

import static pairmatching.handler.ErrorHandler.INVALID_LEVEL_MISSIONS;

public enum LevelMissions {

    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", Arrays.asList()),
    LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
    LEVEL5("레벨5", Arrays.asList());

    private String name;
    private List<String> missions;

    LevelMissions(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static LevelMissions getLevelMissions(String name, String mission) {
        for (LevelMissions levelMissions : LevelMissions.values()) {
            if (levelMissions.name.equals(name) && levelMissions.missions.contains(mission)) {
                return levelMissions;
            }
        }

        throw INVALID_LEVEL_MISSIONS.getException();
    }

    public String getName() {
        return name;
    }

    public List<String> getMissions() {
        return missions;
    }
}
