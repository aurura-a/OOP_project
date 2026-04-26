public class PrerequisiteException extends Exception {
    public PrerequisiteException() {
        super("Prerequisite not satisfied");
    }
}