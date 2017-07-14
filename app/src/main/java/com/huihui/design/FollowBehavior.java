package com.huihui.design;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gavin
 * Time 2017/7/14  17:00
 * Email:molu_clown@163.com
 */

public class FollowBehavior extends CoordinatorLayout.Behavior{

    public FollowBehavior() {
    }

    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /*****
     *     确定依赖关系
     * @param parent
     * @param child   是指应用behavior的View ，
     * @param dependency  dependency 担任触发behavior的角色，并与child进行互动。
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {


        return dependency.getId()==R.id.btn_start;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {


        //child.setY(dependency.getY()+dependency.getHeight());
        return true;
    }
}
