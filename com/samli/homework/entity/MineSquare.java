package com.samli.homework.entity;

public class MineSquare {
    private Integer horizontal;
    private Integer vertical;
    private Boolean hasMine;
    private Integer infoNumber;
    private Boolean isOpen;
    private Boolean isFlag;

    public Integer getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(Integer horizontal) {
        this.horizontal = horizontal;
    }

    public Integer getVertical() {
        return vertical;
    }

    public void setVertical(Integer vertical) {
        this.vertical = vertical;
    }

    public Boolean getHasMine() {
        return hasMine;
    }

    public void setHasMine(Boolean hasMine) {
        this.hasMine = hasMine;
    }

    public Integer getInfoNumber() {
        return infoNumber;
    }

    public void setInfoNumber(Integer infoNumber) {
        this.infoNumber = infoNumber;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Boolean getFlag() {
        return isFlag;
    }

    public void setFlag(Boolean flag) {
        isFlag = flag;
    }
}
