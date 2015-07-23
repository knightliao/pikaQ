package com.baidu.pikaq.client.test.mock;

/**
 * Created by knightliao on 15/7/22.
 */
public class MockObject {

    private String correlation;
    private Object object;

    public MockObject(String correlation, Object object) {
        this.correlation = correlation;
        this.object = object;
    }

    public String getCorrelation() {
        return correlation;
    }

    public void setCorrelation(String correlation) {
        this.correlation = correlation;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "MockObject{" +
                   "correlation='" + correlation + '\'' +
                   ", object=" + object +
                   '}';
    }
}
