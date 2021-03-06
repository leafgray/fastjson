package com.alibaba.json.bvt.writeClassName;

import java.util.Collection;
import java.util.Collections;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class WriteClassNameTest_Collection extends TestCase {

    public void test_list() throws Exception {
        A a = new A();
        a.setList(Collections.singletonList(new B()));
        String text = JSON.toJSONString(a, SerializerFeature.WriteClassName);
        System.out.println(text);
        Assert.assertEquals("{\"@type\":\"com.alibaba.json.bvt.writeClassName.WriteClassNameTest_Collection$A\",\"list\":[{}]}",
                            text);

        A a1 = (A) JSON.parse(text);

        Assert.assertEquals(1, a1.getList().size());
        Assert.assertTrue(a1.getList().iterator().next() instanceof B);
    }

    private static class A {

        private Collection<B> list;

        public Collection<B> getList() {
            return list;
        }

        public void setList(Collection<B> list) {
            this.list = list;
        }

    }

    private static final class B {

    }
}
