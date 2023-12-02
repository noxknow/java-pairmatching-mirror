package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import static pairmatching.handler.ErrorHandler.INVALID_TO_FIND_RESULT;

public class PairsGroup {

    private static final List<PairsInfo> pairsGroup = new ArrayList<>();

    private PairsGroup() {
    }

    public static PairsGroup create() {
        return new PairsGroup();
    }

    public void addPairs(PairsInfo pairsInfo) {
        pairsGroup.add(pairsInfo);
    }

    public boolean checkDuplicatePairs(PairsInfo pairsInfo) {
        List<List<String>> newPairs = pairsInfo.getPairs();

        for (PairsInfo existingPairsInfo : pairsGroup) {
            List<List<String>> existingPairs = existingPairsInfo.getPairs();

            if (existingPairs.contains(newPairs)) {
                return true;
            }
        }

        return false;
    }

    public boolean havePairs(String course, String level, String mission) {
        return pairsGroup.stream()
                .filter(pairs -> pairs.getCourse().equals(course))
                .filter(pairs -> pairs.getLevel().equals(level))
                .anyMatch(pairs -> pairs.getMission().equals(mission));
    }

    public PairsInfo searchInfo(String course, String level, String mission) {
        return pairsGroup.stream()
                .filter(pairs -> pairs.getCourse().equals(course))
                .filter(pairs -> pairs.getLevel().equals(level))
                .filter(pairs -> pairs.getMission().equals(mission))
                .reduce((first, second) -> second)
                .orElseThrow(INVALID_TO_FIND_RESULT::getException);
    }
}
