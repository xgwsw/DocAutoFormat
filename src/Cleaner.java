/**
 * 冗余格式清理模块 —— 去多余空格、空行
 */

public class Cleaner {
    public static void clean(Document doc) {
        String original = doc.content;
        String cleaned = original;

        // 1. 连续3个以上换行 → 替换为2个
        cleaned = cleaned.replaceAll("\n{3,}", "\n\n");

        // 2. 清除行尾空格
        cleaned = cleaned.replaceAll("[ \t]+\n", "\n");

        // 3. 多个连续空格 → 合并为1个
        cleaned = cleaned.replaceAll(" {2,}", " ");

        int removed = original.length() - cleaned.length();
        if (removed > 0) {
            doc.content = cleaned;
            System.out.println("冗余格式清理完成！");
            System.out.println("  清理字符数: " + removed);
        } else {
            System.out.println("未发现冗余格式，文档已很干净！");
        }
    }
}
