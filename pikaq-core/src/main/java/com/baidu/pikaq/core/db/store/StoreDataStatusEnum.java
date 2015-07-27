package com.baidu.pikaq.core.db.store;

/**
 * Created by knightliao on 15/7/3.
 * <p/>
 * store q enum
 */
public enum StoreDataStatusEnum {

    /**
     * producer - 初始生成
     * producer - 生成失败
     * consumer - 处理中
     * consumer - 处理失败
     * consumer - 处理成功
     */
    PRODUCE_INIT(0), PRODUCE_INIT_FAILED(1), CONSUMER_PROCESS(100), CONSUMER_FAILED(101), CONSUMER_SUCCESS(102);

    private final int value;

    StoreDataStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
