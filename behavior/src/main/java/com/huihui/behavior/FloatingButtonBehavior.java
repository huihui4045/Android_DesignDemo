package com.huihui.behavior;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by gavin
 * Time 2017/7/17  15:14
 * Email:molu_clown@163.com
 */

public class FloatingButtonBehavior extends FloatingActionButton.Behavior {

    private static String TAG = "FloatingButtonBehavior";
    private AnimatorSet animatorSetIn;
    private AnimatorSet animatorSetOut;

    public FloatingButtonBehavior() {

        this(null, null);
    }

    public FloatingButtonBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);


        animatorSetIn = new AnimatorSet();

        animatorSetOut = new AnimatorSet();

    }

    /***
     *
     * @param coordinatorLayout
     * @param child
     * @param directTargetChild
     * @param target
     * @param nestedScrollAxes
     * @return 这里返回true，才会接受到后续滑动事件
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child,
                                       View directTargetChild, View target, int nestedScrollAxes) {


        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }


    /****
     *
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dxConsumed
     * @param dyConsumed
     * @param dxUnconsumed
     * @param dyUnconsumed
     */

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child,
                               View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {

        //Log.e(TAG,"dxConsumed:"+dxConsumed);
        //Log.e(TAG,"dxUnconsumed:"+dxUnconsumed);

        Log.e(TAG, "dyConsumed:" + dyConsumed);
        //Log.e(TAG, "dyUnconsumed:" + dyUnconsumed);

        if (dyConsumed > 0) {//向下滑动


            animateOut(child);

        } else {  // dyConsumed<0  向上滑动

            animateIn(child);

        }

    }

    private void animateIn(FloatingActionButton child) {

        //child.setVisibility(View.VISIBLE);

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(child, "scaleX", 0f,1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(child, "scaleY", 0f,1f);


        animatorSetIn.playTogether(scaleX, scaleY);
        animatorSetIn.setDuration(500);

        animatorSetIn.setInterpolator(new LinearInterpolator());

        if (!animatorSetIn.isRunning()) {

            animatorSetIn.start();
        }


    }

    private void animateOut(FloatingActionButton child) {

       // child.setVisibility(View.INVISIBLE);


        ObjectAnimator scaleX = ObjectAnimator.ofFloat(child, "scaleX", 1f,0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(child, "scaleY",1f, 0f);

        animatorSetOut.playTogether(scaleX,scaleY);
        animatorSetOut.setInterpolator(new LinearInterpolator());

        animatorSetOut.setDuration(500);

        if (!animatorSetOut.isRunning()){

            animatorSetOut.start();
        }

    }
}
