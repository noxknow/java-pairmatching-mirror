package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class PairsGroup {

    private final List<PairsInfo> pairsGroup;

    private PairsGroup() {
        this.pairsGroup = new ArrayList<>();
    }

    public static PairsGroup create() {
        return new PairsGroup();
    }

    public void addPairs(PairsInfo pairsInfo) {
        pairsGroup.add(pairsInfo);
    }

    public boolean checkDuplicate(PairsInfo pairsInfo) {
        List<List<String>> newPairs = pairsInfo.getPairs();

        for (PairsInfo existingPairsInfo : pairsGroup) {
            List<List<String>> existingPairs = existingPairsInfo.getPairs();

            if (existingPairs.contains(newPairs)) {
                return true;
            }
        }

        return false;
    }
}
