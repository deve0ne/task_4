import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MainTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void sort(SortData<String> data, SortData<Integer> correctAnswer) {
        SortData<String> programAnswer = Main.sort(data.strData(), data.intData());

        assertArrayEquals(programAnswer.intData(), correctAnswer.intData());
        assertArrayEquals(programAnswer.strData(), correctAnswer.strData());
    }

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                arguments(new SortData<>(new String[]{"green", "blue", "red"}, new Integer[]{5, 8, 1}),
                        new SortData<>(new String[]{"red", "green", "blue"}, new Integer[]{1, 5, 8}))
        );
    }
}