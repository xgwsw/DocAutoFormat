/**
 * 文档自动排版工具 - 主程序
 */

public class Main {
     public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  欢迎使用文档自动排版工具 v1.0.0");
        System.out.println("==================================================");

        Menu menu = new Menu();
        Document doc = null;

        while (true) {
            int choice = menu.showMainMenu();

            switch (choice) {
                case 0:
                    System.out.println("感谢使用，再见！");
                    return;

                case 1:
                    String path = menu.readLine("请输入文档路径: ");
                    doc = FileReader.read(path);
                    break;

                case 2:
                    if (doc == null) {
                        System.out.println("请先读取文档！");
                        break;
                    }
                    formatLoop(doc, menu);
                    break;

                case 3:
                    if (doc == null) {
                        System.out.println("请先读取文档！");
                        break;
                    }
                    Cleaner.clean(doc);
                    break;

                case 4:
                    if (doc == null) {
                        System.out.println("请先读取文档！");
                    } else {
                        System.out.println(doc.preview());
                    }
                    break;

                case 5:
                    if (doc == null) {
                        System.out.println("请先读取文档！");
                    } else {
                        saveDocument(doc, menu);
                    }
                    break;

                case 6:
                    if (doc == null) {
                        System.out.println("请先读取文档！");
                    } else {
                        System.out.println("字数统计: " + doc.wordCount());
                        System.out.println("段落数: " + doc.paragraphCount());
                        System.out.println("行数: " + doc.lineCount());
                    }
                    break;

                default:
                    System.out.println("无效选项，请重新输入！");
            }
        }
    }

    // 格式设置循环
    private static void formatLoop(Document doc, Menu menu) {
        while (true) {
            int choice = menu.showFormatMenu();
            switch (choice) {
                case 0: return;
                case 1: FormatEngine.setFont(doc);       break;
                case 2: FormatEngine.setSize(doc);       break;
                case 3: FormatEngine.setLineSpacing(doc); break;
                case 4: FormatEngine.setAlignment(doc);  break;
                case 5: FormatEngine.applyTemplate(doc); break;
                default: System.out.println("无效选项！");
            }
        }
    }

    // 保存文档
    private static void saveDocument(Document doc, Menu menu) {
        String filename = doc.filename;
        int dot = filename.lastIndexOf(".");
        String output = filename.substring(0, dot) + "_formatted" + filename.substring(dot);

        try {
            java.nio.file.Files.writeString(
                java.nio.file.Path.of(output),
                doc.content
            );
            System.out.println("文档已保存至: " + output);
        } catch (java.io.IOException e) {
            System.out.println("保存失败: " + e.getMessage());
        }
    }
}
