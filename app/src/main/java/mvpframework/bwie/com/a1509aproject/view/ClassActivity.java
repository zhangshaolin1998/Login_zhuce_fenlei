package mvpframework.bwie.com.a1509aproject.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import mvpframework.bwie.com.a1509aproject.R;
import mvpframework.bwie.com.a1509aproject.adapter.LeftAdapter;
import mvpframework.bwie.com.a1509aproject.bean.Catagory;
import mvpframework.bwie.com.a1509aproject.presenter.ClassPresenter;
import mvpframework.bwie.com.a1509aproject.view.IView.IClassActivity;

/**
 * 分类
 */
public class ClassActivity extends AppCompatActivity implements IClassActivity {

    private ListView mLvLeft;
    private ClassPresenter classPresenter;
    private LeftAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        classPresenter = new ClassPresenter(this);
        initView();
        //去P层，调用getCatagory
        classPresenter.getCatagory();

        //给listview 设置点击事件
        mLvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.press(position);
                //请求对应的右侧数据
            }
        });

    }

    private void initView() {
        mLvLeft = (ListView) findViewById(R.id.lv_left);
    }

    @Override
    public void showData(List<Catagory.DataBean> list) {
        //创建适配器
        adapter = new LeftAdapter(this, list);
        mLvLeft.setAdapter(adapter);
    }
}
