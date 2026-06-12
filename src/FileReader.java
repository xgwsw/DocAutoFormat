import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 文档读取模块 —— 读取文件并返回 Document 对象
 */
public class FileReader {
       // 读取文件，返回 Document 对象；失败返回 null
    public static Document read(String filepath) {
        try {
            String content = Files.readString(Path.of(filepath));

            // 检查扩展名
            String lower = filepath.toLowerCase();
            if (!lower.endsWith(".txt") && !lower.endsWith(".md")) {
                System.out.println("警告: 不支持的格式，仅支持 .txt / .md");
            }

            System.out.println("成功读取: " + filepath);
            System.out.println("文档大小: " + content.length() + " 字符");
            return new Document(filepath, content);

        } catch (IOException e) {
            System.out.println("错误: 文件不存在或无法读取 — " + filepath);
            return null;
        }
    }
}
