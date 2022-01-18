package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

public class ParameterizedWebTest {

    static String str;

    @BeforeAll
    static void beforeAll() {
        str = "!";
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach");
    }

//  @ValueSource(strings = {"Selenide", "JUnit"})
    static Stream<Arguments> commonSearchTestValueSource() {
        return Stream.of(
                Arguments.of("Selenide"),
                Arguments.of("JUnit")
        );
    }

    //    @CsvSource(value = {
//            "Selenide, Вышла Selenide",
//            "JUnit, 5 is the next generation of"
//    })
    static Stream<Arguments> commonSearchTestCsvSource() {
        return Stream.of(
                Arguments.of("Selenide", "Вышла Selenide"),
                Arguments.of("JUnit", "5 is the next generation of")
        );
    }

    @MethodSource("commonSearchTestCsvSource")
//    @ValueSource(strings = {"Selenide", "JUnit"})
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}")
    void commonSearchTest(String testData, String expected) {
        Selenide.open("https://ya.ru");
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item")
                .first()
                .shouldHave(Condition.text(expected));
    }



    // В результатах поиска в яндексе есть искомое слово
    // * потворить для тестовых данных: [Allure, Selenide]

    // Открыть яндекс
    // Вбить в поле поиска {test_data}
    // кликнуть кнопку найти


    // в первом результате есть слово {test_data}

}
