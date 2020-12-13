import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

public class ArrayUtilsTest {

    @ParameterizedTest
    @MethodSource("actualAndExpectedResultsProvider")
    void shouldReturnArrayAfterSearch(int[] parameters, int[] expected) {
        Assertions.assertArrayEquals(expected, ArrayUtils.giveMeSliceArrayAfterFour(parameters));
    }

    private static Stream<Arguments> actualAndExpectedResultsProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, new int[] {5}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 4, 5, 8, 5, 1}, new int[] {5, 8, 5, 1}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 4}, new int[] {})
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("wrongParametersProvider")
    void shouldThrowRuntimeExcetionWhenValueNotFound(int[] parameters) {
        Assertions.assertNotNull(
                Assertions.assertThrows(
                        RuntimeException.class,
                        () -> ArrayUtils.giveMeSliceArrayAfterFour(parameters)
                )
        );
    }

    private static Stream<int[]> wrongParametersProvider() {
        return Stream.of(new int[]{1, 2, 3, 5});
    }

    @ParameterizedTest
    @MethodSource("actualDataResultsProvider")
    void shouldReturnFalseIfNotExist(int[] parameters, boolean expected) {
        Assertions.assertEquals(expected, ArrayUtils.findNumsInArray(parameters));
    }

    private static Stream<Arguments> actualDataResultsProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 1, 4, 4, 4}, true),
                Arguments.arguments(new int[]{3, 2, 3, 6, 6, 5, 8, 5, 3}, false),
                Arguments.arguments(new int[]{1, 1, 1, 1, 1}, false),
                Arguments.arguments(new int[]{4, 1, 1, 1, 1}, true)
        );
    }
}
