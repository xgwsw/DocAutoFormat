/**
 * 文档类 —— 存储文档内容和元数据
 */

public class Document {
    public String filepath;
    public String filename;
    public String content;

    // 默认格式设置
    public String font = "宋体";
    public String size = "小四";
    public String lineSpacing = "固定值18磅";
    public String alignment = "两端对齐";

    // 构造方法：创建文档对象时自动提取文件名
    public Document(String filepath, String content) {
        this.filepath = filepath;
        this.content = content;
        this.filename = filepath.substring(filepath.lastIndexOf("\\") + 1);
    }

    // 预览文档前200字
    public String preview() {
        int len = Math.min(content.length(), 200);
        return "[" + filename + "]\n" + content.substring(0, len) + "...";
    }

    // 字数统计（去掉空格和换行符）
    public int wordCount() {
        return content.replace(" ", "").replace("\n", "").length();
    }

    // 段落数
    public int paragraphCount() {
        int count = 0;
        for (String line : content.split("\n")) {
            if (!line.trim().isEmpty()) count++;
        }
        return count;
    }

    // 行数
    public int lineCount() {
        return content.split("\n").length;
    }

    // 统计字符类型分布（分支新功能）
    public void charTypeStats() {
        int chinese = 0, english = 0, digit = 0, other = 0;
        for (char c : content.toCharArray()) {
            if (c >= '一' && c <= '鿿') chinese++;
            else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) english++;
            else if (c >= '0' && c <= '9') digit++;
            else if (c != '\n' && c != '\r' && c != ' ') other++;
        }
        System.out.println("中文字符: " + chinese);
        System.out.println("英文字符: " + english);
        System.out.println("数字字符: " + digit);
        System.out.println("其他符号: " + other);
    }
}
