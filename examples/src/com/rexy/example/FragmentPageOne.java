package com.rexy.example;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rexy.example.extend.BaseFragment;
import com.rexy.example.extend.ViewUtils;
import com.rexy.interactionhook.example.R;

/**
 * TODO:功能说明
 *
 * @author: rexy
 * @date: 2017-08-07 17:52
 */
public class FragmentPageOne extends BaseFragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_page_one, container, false);
        TextView message= (TextView) root.findViewById(R.id.message);
        message.setGravity(Gravity.CENTER);
        message.setTextSize(35);
        message.setTextColor(0xFFFF0000);
        message.setText(getClass().getSimpleName().toUpperCase());
        Button button= ViewUtils.view(root,R.id.jump);
        button.setText("jump to fragment container");
        button.setOnClickListener(this);
        root.setBackgroundColor(0x330f000f);
        return root;
    }

    @Override
    public void onClick(View v) {
        getFragmentManager().beginTransaction().replace(android.R.id.content, new FragmentContainer()).addToBackStack("page2").commitAllowingStateLoss();
    }
}
