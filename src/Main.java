import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(final String[] args) {
        final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("Николай", 68));
            add(new Boy("Пётр", 53));
            add(new Boy("Василий", 25));
            add(new Boy("Михаил", 19));
            add(new Boy("Алексей", 6));
            add(new Boy("Николай", 86));
            add(new Boy("Пётр", 35));
            add(new Boy("Михаил", 111));
            add(new Boy("Алексей", 22));
            add(new Boy("Михаил", 1));
            add(new Boy("Яков", 30));
        }};
        Map<String, Integer> filtered = boys.stream()
                .filter(age -> age.getAge() >= 18)
                .sorted(Comparator.comparing(Boy::getName))
                .map(Boy::getName)
                .distinct()
                .limit(4)
                .collect(Collectors.toMap(f -> f, (n) -> {
                    int num = 0;
                    for (Boy boy : boys) {
                        if (n.equals(boy.getName())) {
                            num++;
                        }
                    }
                    return num - 1;
                }));
            System.out.println(filtered);
    }
}
