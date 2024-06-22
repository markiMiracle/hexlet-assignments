package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class App {

    public static CompletableFuture<String> unionFiles(String filePath1, String filePath2, String resultPath) throws ExecutionException, InterruptedException {

        CompletableFuture<byte[]> future1 = CompletableFuture.supplyAsync(() -> {
            Path path1 = Path.of(filePath1);
            try {
                return Files.readAllBytes(path1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(e -> {
            System.out.println("Oops! We have an exception - " + e.getMessage());
            return null;
        });



        CompletableFuture<byte[]> future2 = CompletableFuture.supplyAsync(() -> {
            Path path2 = Path.of(filePath2);
            try {
                return Files.readAllBytes(path2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(e -> {
            System.out.println("Oops! We have an exception - " + e.getMessage());
            return null;
        });


        CompletableFuture<String> result = future1.thenCombine(future2, (byte1, byte2) -> {
            Path path3 = Path.of(resultPath);
            try {
                byte[] resultArray = new byte[byte1.length + byte2.length];
                System.arraycopy(byte1, 0, resultArray, 0, byte1.length);
                System.arraycopy(byte2, 0, resultArray, byte1.length, byte2.length);
                File file = new File(resultPath);
                if (!file.exists()) file.createNewFile();
                file = Files.write(path3, resultArray).toFile();
                return Files.readString(Path.of(file.getPath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(e -> {
            System.out.println("Oops! We have an exception - " + e.getMessage());
            return null;
        });

        return result;
    }

    public static CompletableFuture<Long> getDirectorySize(String directoryPath) throws IOException {
        Path p = Paths.get(directoryPath);
        var list = Files.find(p, 1, (path, something) -> true).collect(Collectors.toList());
        CompletableFuture<Long> sizeOfDir = CompletableFuture.supplyAsync(() -> {
            Long size = list.stream()
                    .mapToLong(path -> path.toFile().length())
                    .sum();
            return size;
        });
        return sizeOfDir;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(unionFiles("src/main/resources/file1.txt", "src/main/resources/file2.txt", "src/main/resources/file3.txt").get());
        System.out.println(getDirectorySize("src/main/resources/").get());
    }
}

