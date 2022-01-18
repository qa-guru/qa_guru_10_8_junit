package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Класс с тестами проверяющими 3 и 2")
public class SimpleTest {

    @Test
    @DisplayName("Тест проверяет, что 3 < 2")
    void test() {
        Assertions.assertTrue(3 < 2);
    }

    @Test
    @DisplayName("Тест проверяет, что 3 > 2")
    void test1() {
        Assertions.assertTrue(3 > 2);
    }
}
