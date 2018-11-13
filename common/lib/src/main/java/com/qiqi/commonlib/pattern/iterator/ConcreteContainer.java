package com.qiqi.commonlib.pattern.iterator;

import java.util.List;

public class ConcreteContainer implements Container{
    private List<Object> list;

    public ConcreteContainer(List<Object> list) {
        this.list = list;
    }

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator();
    }

    class ConcreteIterator implements Iterator{
        private int cursor;

        @Override
        public Object first() {
            cursor = 0;
            return list.get(cursor);
        }

        @Override
        public Object next() {
            Object obj = null;
            if(hasNext()){
                obj = list.get(cursor);
            }
            cursor++;
            return obj;
        }

        @Override
        public boolean hasNext() {
            return !(cursor == list.size());
        }

        @Override
        public Object currentItem() {
            return list.get(cursor);
        }
    }
}
