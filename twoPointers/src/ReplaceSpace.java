public class ReplaceSpace {
    public String replaceSpace(String s) {
//s是空串直接返回
        if (s == null) {
            return null;
        }

        //扫描s，有空字符时拼接两个空字符到末尾（给字符串扩容）
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("  ");
            }
        }
        //没有空字符直接返回
        if (stringBuilder == null) {
            return s;
        }

        //left指针指向原字符串首部
        int left = s.length() - 1;
        s += stringBuilder;
        //right指针指向新字符串末尾
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        //遍历
        while (true) {
            if (left < 0) {
                break;
            }
            if (chars[left] != ' ') {
                chars[right] = chars[left];
            } else {
                chars[right] = '0';
                right--;
                chars[right] = '2';
                right--;
                chars[right] = '%';
            }
            left--;
            right--;
        }

        return new String(chars);

    }
}
