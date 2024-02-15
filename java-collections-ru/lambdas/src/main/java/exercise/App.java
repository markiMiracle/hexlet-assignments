package exercise;
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        String[][] newIm = new String[image.length * 2][image.length * 2];
        for (var i = 0; i < image.length; i++) {
            for (var i2 = 0; i2 < image.length; i2++) {
                if (newIm[i][i2] == null) {
                    newIm[i][i2] = image[i][i2];
                    newIm[i][i2 + 1] = image[i][i2];
                    newIm[i + 1][i2] = image[i][i2];
                    newIm[i + 1][i2 + 1] = image[i][i2];
                } else {
                    newIm[i * 2][i2 * 2] = image[i][i2];
                    newIm[i * 2][i2 * 2 + 1] = image[i][i2];
                    newIm[i * 2 + 1][i2 * 2] = image[i][i2];
                    newIm[i * 2 + 1][i2 * 2 + 1] = image[i][i2];
                }
            }
        }
        return newIm;
    }
}
