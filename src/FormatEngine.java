/**
 * 格式设置模块 —— 设置字体、字号、间距、对齐，支持模板
 */

public class FormatEngine {
      // 设置字体
    public static void setFont(Document doc) {
        System.out.println("\n可选字体: 1.宋体  2.仿宋  3.黑体  4.楷体  5.微软雅黑");
        System.out.print("请选择字体 (1-5): ");

        String input = new java.util.Scanner(System.in).nextLine().trim();
        String[] fonts = {"宋体", "仿宋", "黑体", "楷体", "微软雅黑"};
        try {
            int i = Integer.parseInt(input);
            if (i >= 1 && i <= 5) {
                doc.font = fonts[i - 1];
                System.out.println("字体已设置为: " + doc.font);
            }
        } catch (NumberFormatException e) {
            System.out.println("无效选择！");
        }
    }

    // 设置字号
    public static void setSize(Document doc) {
        System.out.println("\n可选字号: 1.小二  2.三号  3.四号  4.小四");
        System.out.print("请选择字号 (1-4): ");

        String input = new java.util.Scanner(System.in).nextLine().trim();
        String[] sizes = {"小二", "三号", "四号", "小四"};
        try {
            int i = Integer.parseInt(input);
            if (i >= 1 && i <= 4) {
                doc.size = sizes[i - 1];
                System.out.println("字号已设置为: " + doc.size);
            }
        } catch (NumberFormatException e) {
            System.out.println("无效选择！");
        }
    }

    // 设置行距
    public static void setLineSpacing(Document doc) {
        System.out.println("\n可选间距: 1.单倍行距  2.1.5倍行距  3.固定值18磅  4.固定值22磅");
        System.out.print("请选择间距 (1-4): ");

        String input = new java.util.Scanner(System.in).nextLine().trim();
        String[] spacings = {"单倍行距", "1.5倍行距", "固定值18磅", "固定值22磅"};
        try {
            int i = Integer.parseInt(input);
            if (i >= 1 && i <= 4) {
                doc.lineSpacing = spacings[i - 1];
                System.out.println("间距已设置为: " + doc.lineSpacing);
            }
        } catch (NumberFormatException e) {
            System.out.println("无效选择！");
        }
    }

    // 设置对齐
    public static void setAlignment(Document doc) {
        System.out.println("\n可选对齐: 1.左对齐  2.居中  3.右对齐  4.两端对齐");
        System.out.print("请选择对齐方式 (1-4): ");

        String input = new java.util.Scanner(System.in).nextLine().trim();
        String[] aligns = {"左对齐", "居中", "右对齐", "两端对齐"};
        try {
            int i = Integer.parseInt(input);
            if (i >= 1 && i <= 4) {
                doc.alignment = aligns[i - 1];
                System.out.println("对齐方式已设置为: " + doc.alignment);
            }
        } catch (NumberFormatException e) {
            System.out.println("无效选择！");
        }
    }

    // 一键套用预设模板
    public static void applyTemplate(Document doc) {
        System.out.println("\n预设模板:");
        System.out.println("  模板1: 宋体 小四 18磅 两端对齐 (标准论文)");
        System.out.println("  模板2: 仿宋 四号 1.5倍 左对齐 (公文格式)");
        System.out.println("  模板3: 黑体 三号 单倍 居中 (标题格式)");
        System.out.print("请选择模板 (1-3): ");

        String input = new java.util.Scanner(System.in).nextLine().trim();
        switch (input) {
            case "1":
                doc.font = "宋体"; doc.size = "小四";
                doc.lineSpacing = "固定值18磅"; doc.alignment = "两端对齐";
                System.out.println("已套用模板1 (标准论文)");
                break;
            case "2":
                doc.font = "仿宋"; doc.size = "四号";
                doc.lineSpacing = "1.5倍行距"; doc.alignment = "左对齐";
                System.out.println("已套用模板2 (公文格式)");
                break;
            case "3":
                doc.font = "黑体"; doc.size = "三号";
                doc.lineSpacing = "单倍行距"; doc.alignment = "居中";
                System.out.println("已套用模板3 (标题格式)");
                break;
            default:
                System.out.println("无效选择！");
        }
    }
}
