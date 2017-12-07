package com.imory.cn.utils;

/**
 * <p>获取总页码工具类</p>
 * <p/>
 * <p>URL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @date 15/3/16
 */
public class GetTotalPageNumUtil {

    /***
     * 获取总页码
     * @param num 总条目数
     * @param rowNum 每行显示条目数
     * @return
     */
    public static int getTotalPage(int num, int rowNum)
    {
        int _totalPage;
        if (num % rowNum == 0)
        {
            _totalPage = num / rowNum;
        } else
        {
            Double dtotalPage;
            dtotalPage = Math.ceil(num / rowNum);
            _totalPage = dtotalPage.intValue() + 1;
        }
        return _totalPage;
    }
}
