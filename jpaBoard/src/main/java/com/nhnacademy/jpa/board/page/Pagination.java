package com.nhnacademy.jpa.board.page;

import lombok.Data;

@Data
public class Pagination {
    private int pageNo;

    private int size;

    public Pagination(){
        this(1, 1);
    }

    public Pagination(int pageNo, int size) {
        this.pageNo = pageNo;
        this.size = size;
    }

    public int getSkip(){
        return this.pageNo = (pageNo - 1) * this.size;
    }
}
