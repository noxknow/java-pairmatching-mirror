package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static pairmatching.handler.ConstantsHandler.*;

public class PairsInfo {

    private final List<List<String>> pairs;
    private final String course;
    private final String level;
    private final String mission;

    private PairsInfo(List<String> crewNames, String course, String level, String mission) {
        this.pairs = generateRandomPair(crewNames);
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static PairsInfo of(List<String> crewNames, String course, String level, String mission) {
        return new PairsInfo(crewNames, course, level, mission);
    }

    private List<List<String>> generateRandomPair(List<String> crewNames) {
        List<List<String>> pairs = new ArrayList<>();
        List<String> shuffledCrew = Randoms.shuffle(crewNames);

        while (shuffledCrew.size() > MIN_SIZE.getValue()) {
            pairs.add(getRandomPair(shuffledCrew));
        }

        return pairs;
    }

    private List<String> getRandomPair(List<String> shuffledCrew) {
        List<String> pair = new ArrayList<>();
        int pairCount = DEFAULT_PAIR_COUNT.getValue();

        if (shuffledCrew.size() == ODD_PAIR_COUNT.getValue()) {
            pairCount = ODD_PAIR_COUNT.getValue();
        }

        for (int i = 0; i < pairCount; i++) {
            pair.add(shuffledCrew.get(ZERO_INDEX.getValue()));
            shuffledCrew.remove(ZERO_INDEX.getValue());
        }

        return pair;
    }

    public List<List<String>> getPairs() {
        return Collections.unmodifiableList(pairs);
    }

    public String getCourse() {
        return course;
    }

    public String getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }
}
