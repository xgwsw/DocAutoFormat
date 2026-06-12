import java.util.Scanner;

public class Menu {
    /**
 * 菜单模块 —— 显示界面和读取用户输入
 */
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    // 显示主菜单
    public int showMainMenu() {
        System.out.println("\n----------------------------------------");
        System.out.println("  主菜单");
        System.out.println("----------------------------------------");
        System.out.println("  1. 读取文档");
        System.out.println("  2. 格式设置");
        System.out.println("  3. 冗余格式清理");
        System.out.println("  4. 预览文档");
        System.out.println("  5. 保存文档");
        System.out.println("  6. 文本统计");
        System.out.println("  0. 退出系统");
        System.out.println("----------------------------------------");
        System.out.print("请输入选项 (0-6): ");
        return readInt();
    }

    // 显示格式设置子菜单
    public int showFormatMenu() {
        System.out.println("\n----------------------------------------");
        System.out.println("  格式设置 - 子菜单");
        System.out.println("----------------------------------------");
        System.out.println("  1. 字体设置");
        System.out.println("  2. 字号设置");
        System.out.println("  3. 段落间距设置");
        System.out.println("  4. 对齐方式设置");
        System.out.println("  5. 一键套用模板");
        System.out.println("  0. 返回主菜单");
        System.out.println("----------------------------------------");
        System.out.print("请输入选项 (0-5): ");
        return readInt();
    }

    // 读取整数，非法输入返回 -1
    private int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // 读取字符串输入
    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}

