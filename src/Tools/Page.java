package Tools;

public class Page {
    int start;      //开始数据
    int count;      //每一页的数据量
    int total;      //总数据量

    public Page(int start, int count) {
        this.start = start;
        this.count = count;
    }
    //是否有上一页
    public boolean isHasPreviouse() {
        if (start == 0) {
            return false;
        }
        return true;
    }

    public boolean isHasNext() {
        if (start == getLast()) {
            return false;
        }
        return true;
    }
    //该页的起始序号
    public int getLast() {
        int last;       //最后一页的起始数据序号
        if(total % count == 0) {
            last = total - count;
        }else {
            last = total - total % count;
        }
        return last;
    }
    //总共多少页
    public int getTotalPage() {
        int totalPage;
        if(total % count == 0) {
            totalPage = total / count;
        }else {
            totalPage = total / count + 1;
        }
        return totalPage == 0 ? 1 : totalPage;
    }


    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
