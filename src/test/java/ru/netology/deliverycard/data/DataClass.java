package ru.netology.deliverycard.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataClass {

    private DataClass() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.uuuu"));
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generateCity() {
        var cities = new String[]{"Благовещенск", "Архангельск", "Астрахань", "Белгород", "Брянск",
                "Владимир", "Волгоград", "Вологда", "Воронеж", "Калининград", "Калуга", "Кемерово", "Киров",
                "Кострома", "Курган", "Курск", "Санкт-Петербург", "Липецк", "Магадан", "Нижний Новгород", "Великий Новгород",
                "Новосибирск", "Омск", "Оренбург", "Орёл", "Пенза", "Псков", "Ростов-на-Дону", "Рязань", "Самара", "Саратов",
                "Южно-Сахалинск", "Екатеринбург", "Смоленск", "Тамбов", "Тверь", "Томск"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }

    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}

