package skillbuilder.indepth.record.taskbasedlearning;

public record Email(String local, String domain) {

    // This is Explicit constructor
    public Email(String local, String domain) {
        this.local = local;
        if (domain == null || !domain.contains(".")) {
            throw new IllegalArgumentException("Invalid Domain entered");
        }
        this.domain = domain;
    }
}
