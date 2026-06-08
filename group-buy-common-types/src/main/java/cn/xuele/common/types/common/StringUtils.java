package cn.xuele.common.types.common;

/**
 * 字符串工具类
 *
 * @author XueLe
 * @version 1.0.0
 * @since 2026/06/08 14:20
 */
public final class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
}