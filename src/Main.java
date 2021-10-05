import java.io.File;

public class Main {
    public static void main(String[] args) {
        String holderPath = "C:/Users/Andrey/Desktop";
        File file = new File(holderPath);
        long start = System.currentTimeMillis();
        System.out.println(getSizeFiles(file));
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration);
    }
    private static long getSizeFiles(File file) {
        File[] listFile = file.listFiles();
        long sizeFiles = 0;
        for(File subFile : listFile) {
            if(subFile.isDirectory()) {
                sizeFiles += getSizeFiles(subFile);
                continue;
            }
            sizeFiles += subFile.length();
        }
        return sizeFiles;
    }
}
