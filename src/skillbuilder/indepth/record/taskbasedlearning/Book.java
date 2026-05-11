package skillbuilder.indepth.record.taskbasedlearning;

import java.util.List;

public record Book(String title, List<String> authors)  {
    public Book {

        authors = List.copyOf(authors);
    }

}
