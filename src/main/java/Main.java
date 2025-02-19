public class Main {
    public static void main(String[] args) {
        StringCompression stringCompression=new StringCompression();
        //Compression showcase
        System.out.println("Compression showcase:");
        System.out.println("'aaabb' -> '" + stringCompression.compress("aaabb") + "'");
        System.out.println("'abc' -> '" + stringCompression.compress("abc") + "'");
        System.out.println("'' -> '" + stringCompression.compress("") + "'");

        // Decompression showcase
        System.out.println("\nDecompression showcase:");
        System.out.println("'a3b2' -> '" + stringCompression.decompress("a3b2") + "'");
        System.out.println("'a1b1c1' -> '" + stringCompression.decompress("a1b1c1") + "'");
        System.out.println("'' -> '" + stringCompression.decompress("") + "'");

        // Additional test with user input
        System.out.println("\nAdditional tests:");
        String originalString = "helloworld";
        System.out.println("Original: '" + originalString + "'");

        String compressedString = stringCompression.compress(originalString);
        System.out.println("Compressed: '" + compressedString + "'");

        String decompressedString = stringCompression.decompress(compressedString);
        System.out.println("Decompressed: '" + decompressedString + "'");
    }
}