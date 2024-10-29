package skillbuilder.java9.programs.CollectionFactoryMethods;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
//        oldApproachForCreatingList();
        latestFeatureApproach();
    }

    private static void oldApproachForCreatingList() {
        //below is the old approach for creating the List object which require more lines of code to create a simple list object
        List<String> l = new ArrayList<>();
        l.add("spring");
        l.add("Java");
        l.add("SQL");
        l.add("Microservices");
        System.out.println(l);
    }

    private static void latestFeatureApproach() {
        List<String> l = List.of("java", "spring", "microservices", "SQL", "kafka", "rest api", "redis", "JPA", "Hibernate", "aws", "azure");
//        l.add("postgresql"); if we un-comment this line then we will get runtime exception (java.lang.UnsupportedOperationException) as we have created
//  an immutable list using List.of() method
        System.out.println(l);

        // we can create an empty list also using this as well as non-empty as above
        List<Integer> l1 = List.of();
//        l1.add("rabbitmq"); // as we have created immutable/un-modifiable list object if we un-comment this line we will get exception as java.lang.UnsupportedOperationException
        System.out.println(l1);
    }
}
