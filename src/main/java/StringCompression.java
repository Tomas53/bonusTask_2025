/**
 * The StringCompression class provides methods to compress and decompress strings
 * based on character repetition.
 */
public class StringCompression {

    /**
     * This method compresses a given string by replacing consecutive repeated characters with the character followed by the number of times it appears.
     *
     */
    public String compress(String inputString) {
        // If the input string is null or empty, return an empty string
        if (inputString == null || inputString.isEmpty()) {
            return "";
        }

        StringBuilder compressedResult = new StringBuilder();

        // Variable to track the starting index, to skip initial spaces
        int startIndex = 0;

        // Skip any leading spaces (ignore spaces at the beginning)
        while (startIndex < inputString.length() && Character.isWhitespace(inputString.charAt(startIndex))) {
            startIndex++;
        }

        // If the entire string was spaces, return an empty string
        if (startIndex >= inputString.length()) {
            return "";
        }

        // Initialize the first character and count
        char currentCharacter = inputString.charAt(startIndex);
        int characterCount = 1;

        // Loop through the string starting from the character after startIndex
        for (int i = startIndex + 1; i < inputString.length(); i++) {
            // Ignore spaces between characters
            if (Character.isWhitespace(inputString.charAt(i))) {
                continue;
            }

            // If the current character is the same as the previous one, increase the count
            if (inputString.charAt(i) == currentCharacter) {
                characterCount++;
            } else {
                // Append the previous character and its count to the compressed result
                compressedResult.append(currentCharacter);
                compressedResult.append(characterCount);

                // Update to the new character and reset its count
                currentCharacter = inputString.charAt(i);
                characterCount = 1;
            }
        }

        // After the loop, we add the last character and its count
        compressedResult.append(currentCharacter);
        compressedResult.append(characterCount);

        return compressedResult.toString();
    }

    /**
     * The method decompresses a compressed string by expanding repeated characters.
     */
    public String decompress(String compressedString) {
        // If the input string is null or empty, return an empty string
        if (compressedString == null || compressedString.isEmpty()) {
            return "";
        }

        StringBuilder decompressedResult = new StringBuilder();

        char currentCharacter;
        int repeatNumber; // The number of times a character should repeat

        // Loop through the string, processing two characters at a time (character + number)
        for (int i = 0; i < compressedString.length(); i += 2) {
            // Get the character (every even index should contain a character)
            currentCharacter = compressedString.charAt(i);

            // Ensure that loop is not of bounds before accessing the number
            if (i + 1 < compressedString.length()) {
                // Convert the numeric character to an integer
                repeatNumber = Character.getNumericValue(compressedString.charAt(i + 1));

                // Append the character as many times as specified by repeatNumber
                for (int j = 0; j < repeatNumber; j++) {
                    decompressedResult.append(currentCharacter);
                }
            }
        }

        // Convert the StringBuilder content to a string and return it
        return decompressedResult.toString();
    }
}
