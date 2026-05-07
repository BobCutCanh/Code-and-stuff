import java.nio.file.Path;
import java.nio.file.Paths;

public class FileProcessor {
    /*public String getFilePath(String folder, String file) {
        // SAI: Hardcoded dấu gạch chéo của Windows
        return folder + "\\" + file;
    }
     */
    public String getFilePath(String folder, String file) {
        Path path = Paths.get(folder, file);
        return path.toString();
    }
}