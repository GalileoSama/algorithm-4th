package search;

/**
 * @author galileo
 * @date 2019/6/18 15:27
 */
public class SeparateChainingHashST<Key extends Comparable<Key>, Value> {
    /** 数组长度 **/
    private int m;
    /** 链表数量 **/
    private int n;
    /** 链表数组 **/
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++){
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key){
        //注：这里不用Math.abs（）方法的原因是，Math.abs可能返回负值，在传入参数是最大负值，即Integer.MIN_VALUE时
        //      因为Integer.MIN_VALUE没有对应的正数。int范围：[-2147483648,2147483647]
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public Value get(Key key){
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value){
        st[hash(key)].put(key, value);
    }

    public void delete(Key key){
        st[hash(key)].delete(key);
    }
}
