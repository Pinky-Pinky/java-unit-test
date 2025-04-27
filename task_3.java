import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class) // Напиши аннотацию для параметризованных 
тестов
public class CheckIsAdultTest {

    private final int age;
    private final boolean result;

    // Инициализируем поля класса в конструкторе
    public CheckIsAdultTest(int age, boolean result) {
        this.age = age;
        this.result = result;
    }

    @Parameterized.Parameters // Помечаем метод аннотацией для параметров
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
            {17, false}, // Меньше 18, должно вернуться false
            {18, true},  // Ровно 18, должно вернуться true
            {19, true},  // Больше 18, должно вернуться true
            {21, true},  // Больше 18, должно вернуться true
        });
    }

    @Test
    public void checkIsAdultWhenAgeThenResult() {
        Program program = new Program();
        boolean isAdult = program.checkIsAdult(age); // Передаём возраст
        assertEquals("Ошибка для возраста: " + age, result, isAdult); // 
Сравниваем результат с ожидаемым
    }
}

