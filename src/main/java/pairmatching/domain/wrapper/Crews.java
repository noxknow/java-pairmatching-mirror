package pairmatching.domain.wrapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static pairmatching.handler.ErrorHandler.INVALID_PATH;

public class Crews {

    private final List<String> crews;

    private Crews(String course) throws IOException {
        this.crews = readFile(course);
    }

    public static Crews from(String course) throws IOException {
        return new Crews(course);
    }

    private List<String> readFile(String course) throws IOException {
        try {
            Path filePath = Paths.get("src/main/resources/" + course + "-crew.md");
            crews.addAll(Files.readAllLines(filePath));
        } catch (IOException e) {
            throw INVALID_PATH.getException();
        }

        return crews;
    }

    public List<String> getCrews() {
        return crews;
    }
}
