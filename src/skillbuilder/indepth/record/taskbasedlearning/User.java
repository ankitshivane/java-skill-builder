package skillbuilder.indepth.record.taskbasedlearning;

public record User(String username, String passwordHash) {
    public User {
        username = username.trim().toLowerCase();

    }
}
