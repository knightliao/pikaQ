package com.baidu.pikaq.core.db.store;

/**
 * Created by knightliao on 15/7/3.
 */
public enum StoreDataStatusEnum {

    INIT(0), PROCESS(1), FAILED(2), SUCCESS(3);

    private final int value;

    StoreDataStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
