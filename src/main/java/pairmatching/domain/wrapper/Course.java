package pairmatching.domain.wrapper;

import static pairmatching.handler.ErrorHandler.INVALID_COURSE;

public enum Course {

    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course getCourse(String name) {
        for (Course course : Course.values()) {
            if (course.getName().equals(name)) {
                return course;
            }
        }

        throw INVALID_COURSE.getException();
    }

    public String getName() {
        return name;
    }
}