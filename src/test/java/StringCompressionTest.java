import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("StringCompression Tests")
class StringCompressionTest {

    private StringCompression compression;

    @BeforeEach
    void setUp() {
        compression = new StringCompression();
    }

    @Nested
    @DisplayName("Compression Tests")
    class CompressionTests {

        @Test
        @DisplayName("Should return empty string when input is null")
        void should_ReturnEmptyString_When_InputIsNull() {
            assertEquals("", compression.compress(null));
        }

        @Test
        @DisplayName("Should return empty string when input is empty")
        void should_ReturnEmptyString_When_InputIsEmpty() {
            assertEquals("", compression.compress(""));
        }

        @Test
        @DisplayName("Should compress single character with count")
        void should_CompressSingleCharacter_When_InputHasRepeatedChar() {
            assertEquals("a3", compression.compress("aaa"));
        }

        @Test
        @DisplayName("Should compress multiple different characters")
        void should_CompressMultipleCharacters_When_InputHasDifferentChars() {
            assertEquals("a3b2c1", compression.compress("aaabb c"));
        }

        @Test
        @DisplayName("Should handle single character input")
        void should_HandleSingleCharacter_When_InputIsOneChar() {
            assertEquals("a1", compression.compress("a"));
        }

        @Test
        @DisplayName("Should compress alternating characters")
        void should_CompressAlternating_When_InputHasAlternatingChars() {
            assertEquals("a1b1a1b1", compression.compress("abab"));
        }
    }

    @Nested
    @DisplayName("Decompression Tests")
    class DecompressionTests {

        @Test
        @DisplayName("Should return empty string when input is null")
        void should_ReturnEmptyString_When_InputIsNull() {
            assertEquals("", compression.decompress(null));
        }

        @Test
        @DisplayName("Should return empty string when input is empty")
        void should_ReturnEmptyString_When_InputIsEmpty() {
            assertEquals("", compression.decompress(""));
        }

        @Test
        @DisplayName("Should decompress single character with count")
        void should_DecompressSingleCharacter_When_InputHasOneChar() {
            assertEquals("aaa", compression.decompress("a3"));
        }

        @Test
        @DisplayName("Should decompress multiple different characters")
        void should_DecompressMultipleCharacters_When_InputHasMultipleChars() {
            assertEquals("aaabb", compression.decompress("a3b2"));
        }

        @Test
        @DisplayName("Should handle single character with count 1")
        void should_HandleSingleCharacter_When_InputHasCountOne() {
            assertEquals("a", compression.decompress("a1"));
        }
    }

}