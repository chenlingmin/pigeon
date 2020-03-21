package xyz.yishe.pigeon.common.util;

/**
 * 字符工具类
 *
 * @author owen
 * @date 2020-01-06 17:03
 */
public class CharacterUtils {
    /**
     * 昵称隐藏
     *
     * @param nickname
     * @return
     */
    public static String hide(String nickname) {
        int length = nickname.length();
        if (length == 2) {
            nickname = nickname.substring(0, 1).concat("*");
        } else if (length >= 3) {
            int poor = length - 3;
            if (poor <= 3) {
                StringBuffer buffer = new StringBuffer("*");
                for (int i = 0; i < poor; i++) {
                    buffer.append("*");
                }
                nickname = nickname.substring(0, 1).concat(buffer.toString()).concat(nickname.substring(length - 1));
            } else {
                nickname = nickname.substring(0, 1).concat("***").concat(nickname.substring(length - 1));
            }
        }
        return nickname;
    }
}
