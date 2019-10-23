package com.alany.analysejvm.lecture6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 传统的 Try-Catch-Finally 写法
 * 繁琐，并且 finally 类似于关闭资源的操作也会有异常，但是catch 中的异常会"消失"，不利于排查问题
 *
 * @author yinxing
 * @date 2019/10/23
 */

public class TryCatchFinallyDemo {

    FileInputStream in0 = null;
    FileInputStream in1 = null;
    FileInputStream in2 = null;

    public void test() throws IOException {
        try {
            in0 = new FileInputStream(new File("in0.txt"));
            try {
                in1 = new FileInputStream(new File("in0.txt"));
                try {
                    in2 = new FileInputStream(new File("in0.txt"));
                } finally {
                    if (in2 != null) {
                        in2.close();
                    }
                }
            } finally {
                if (in1 != null) {
                    in1.close();
                }
            }
        } finally {
            if (in0 != null) {
                in0.close();
            }
        }
    }
}
