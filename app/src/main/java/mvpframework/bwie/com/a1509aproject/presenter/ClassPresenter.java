package mvpframework.bwie.com.a1509aproject.presenter;

import java.util.List;

import mvpframework.bwie.com.a1509aproject.bean.Catagory;
import mvpframework.bwie.com.a1509aproject.bean.ProductCatagoryBean;
import mvpframework.bwie.com.a1509aproject.model.ClassModel;
import mvpframework.bwie.com.a1509aproject.model.IModel.IClassModel;
import mvpframework.bwie.com.a1509aproject.net.OnNetListener;
import mvpframework.bwie.com.a1509aproject.view.IView.IClassActivity;

/**
 * Created by peng on 2017/11/7.
 */

public class ClassPresenter {

    private final IClassModel iclassModel;
    private IClassActivity iClassActivity;

    public ClassPresenter(IClassActivity iClassActivity) {
        this.iClassActivity = iClassActivity;
        iclassModel = new ClassModel();
    }

    //获取分类
    public void getCatagory() {
        iclassModel.getCatagory(new OnNetListener<Catagory>() {
            @Override
            public void onSuccess(Catagory catagory) {
                iClassActivity.showData(catagory.getData());
                //拿到右侧第一条数据
                List<Catagory.DataBean> dataBean = catagory.getData();
                int cid = dataBean.get(0).getCid();
                iclassModel.getProductCatagory(cid + "", new OnNetListener<ProductCatagoryBean>() {
                    @Override
                    public void onSuccess(ProductCatagoryBean productCatagoryBean) {

                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                });
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
