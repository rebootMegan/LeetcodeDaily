package tt;

import java.util.List;

public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
// @return the single integer that this NestedInteger holds, if it holds a single integer
// Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    public List<NestedInteger> getList();
    public void setInteger(int value);
    public void add(NestedInteger ni);
}
