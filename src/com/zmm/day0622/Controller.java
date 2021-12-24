package com.zmm.day0622;

import org.junit.Test;

/**
 * @Name Controller
 * @Author 900045
 * @Created by 2020/6/22 0022
 */
public class Controller {

    @Test
    public void testLabel() {
        ShareModel shareModel = new ShareModel();

        shareModel.getLabelList().add(new Label("哈哈", 0));
    }
}
