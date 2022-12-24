package segmentation;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入'.' 来形成。你 不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class RestoreIpAddresses {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        restoreIpAddresses(s, 0, 0);
        return res;
    }


    /**
     * 思路：
     *      将原始的数字字符串进行分割
     *      组合问题：选取一个a之后，在bcdef中再去选取第二个，选取b之后在cdef中在选组第三个.....。
     *      切割问题：切割一个a之后，在bcdef中再去切割第二段，切割b之后在cdef中在切割第三段.....。
     *      这里归属于切割问题，切出一个头，然后加 逗点 .，当加了三个逗点后，就只剩下一段了，只需要判断最后一个段是否合法即可
     *      每一次切割完之后，下一次切割的 str就要更新一下（不是直接截了剩余的字串，而是通过指针来控制访问的是剩余的字串，参数中所传递的字串仍然是一个整体，只不过加了逗点，但是只对剩余的部分进行切割处理），
     *      取剩下部分作为新str重新进行切割（递归的处理逻辑，新字串与原字串相同的处理方式）
     */
    // startIndex: 搜索的起始位置， pointNum:添加逗点的数量
    //在递归函数中，这个 s表示的就是待切割的字串，在递归过程中是不断变化的
    private void restoreIpAddresses(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {// 逗点数量为3时，分隔结束
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValid(s,startIndex,s.length()-1)) {
                res.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {//判断是否合法，合法则插入逗点
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);    //在str的后⾯插⼊⼀个逗点
                pointNum++;
                restoreIpAddresses(s, i + 2, pointNum);// 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                pointNum--;// 回溯
                s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉逗点
            } else {
                //剩下的待切割的字串合法，直接退出，没有必要继续切割了
                break;
            }
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');//给数字字符转成数字的方法，定义一个 num=0，然后用这个算式进行循环计算
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}
