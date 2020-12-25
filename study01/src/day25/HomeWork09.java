package day25;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class HomeWork09 {
    public static void main(String[] args) {
        ArrayList<String> global = new ArrayList<>();
        global.add("《教父》");
        global.add("《肖申克的救赎》");
        global.add("《辛德勒的名单》");
        global.add("《公民凯恩》");
        global.add("《卡萨布兰卡》");
        global.add("《教父续集》");
        global.add("《七武士》");
        global.add("《星球大战》");
        global.add("《美国美人》");
        global.add("《飞跃疯人院》");

        ArrayList<String> china = new ArrayList<>();
        china.add("《霸王别姬》");
        china.add("《大闹天宫》");
        china.add("《鬼子来了》");
        china.add("《大话西游》");
        china.add("《活着》");
        china.add("《饮食男女》");
        china.add("《无间道》");
        china.add("《天书奇谭》");
        china.add("《哪吒脑海》");
        china.add("《春光乍泄》");


        global.stream().limit(3).forEach(System.out::println);
        System.out.println("------------");
        china.stream().skip(china.size()-5).forEach(System.out::println);
        System.out.println("------------");
        List<String> collect = Stream.concat(global.stream().limit(5), china.stream().limit(5)).collect(Collectors.toList());
        System.out.println(collect);
        List<Film> collect1 = Stream.concat(global.stream(), china.stream()).map(Film::new).collect(Collectors.toList());
        System.out.println("------------");
        System.out.println(collect1);


    }
}

class Film {
    private String name;

    public Film() {
    }

    public Film(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Film [name=" + name + "]";
    }

}