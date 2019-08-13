package com.mul.viewpager.click;

import android.view.View;

/**
 * @ProjectName: MulViewPager
 * @Package: com.mul.test.click
 * @ClassName: IVpAllClick
 * @Author: zdd
 * @CreateDate: 2019/8/13 14:00
 * @Description: 轮播图的点击事件
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/13 14:00
 * @UpdateRemark: 更新说明
 * @Version: v1.0.1
 */
public interface IVpAllClick extends IVpClick {
    void itemClick(View v, int position);
    void startClick(View v);
}
