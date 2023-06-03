
//    /**
//     * Дан список объектов класса Person,
//     * содержащих поля name и age.
//     * Найдите средний возраст всех людей в списке и выведите его на консоль.
//     * 7-10
//     */
//
//    public static void getAvgAge(List<_2023_05_08.Person> people) {
//        System.out.println("average Age = " +
//                people.stream().mapToInt(o -> o.getAge())
//                        .average()
//                        .orElse(0)
//        );
//    }
//
//
//    public static List<String> getTOPNCities(List<String> list, int n) {
//        return
//                list.stream().collect(Collectors
//                                .toMap(o -> o.substring(0, o.indexOf(",")),
//                                        o -> o.substring(o.indexOf(","))))
//
//                        .entrySet().stream()
//                        .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
//                        .limit(n)
//                        .map(Map.Entry::getKey)
//                        .toList();
//    }


//    public static List<String> getMostProAuthors(List<_2023_05_08.Book> books) {
//
//        Map<String, Integer> mapAuthors = books.stream()
//                .collect(Collectors.toMap(Book::getAuthor, o -> 1,
//                        Integer::sum));
//
//        int n = mapAuthors.entrySet().stream()
//                .map(Map.Entry::getValue)
//                .reduce((o1, o2) -> o1 > o2 ? o1 : o2).orElse(0);
//
//        return mapAuthors.entrySet().stream()
//                .filter(o -> o.getValue() >= n)
//                .map(Map.Entry::getKey)
//                .toList();
//    }

//    /**
//     * Дана коллекция объектов класса Person, содержащая поля name и список
//     * friends, представляющий список друзей данного человека. Напишите метод,
//     * который находит двух людей в коллекции, у которых максимальное число общих друзей.
//     * Если таких людей несколько, то вернуть список их имен.
//     * 10-10
//     */
//    public static List<Person2> findMostCommonFriends2(List<Person2> people) {
//
//        return people.stream()
//                .flatMap(p1 -> people.stream().filter(p2 -> !p1.equals(p2))
//                        .map(p2 -> new AbstractMap.SimpleEntry<List<Person2>, Long>(List.of(p1, p2),
//                                p1.getFriends().stream().filter(el -> p2.getFriends().contains(el)).count()) {
//                        }))
//                .reduce((o1, o2) -> o1.getValue() > o2.getValue() ? o1 : o2).get().getKey();
//    }




