/*
Given an Iterator class interface with methods: next() and hasNext(), 
design and implement a PeekingIterator that support the peek() operation -- 
it essentially peek() at the element that will be returned by the next call to next().

Example:
Assume that the iterator is initialized to the beginning of the list: [1,2,3].
Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. 
Calling next() after that still return 2. 
You call next() the final time and it returns 3, the last element. 
Calling hasNext() after that should return false.
*/

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

    // 'next' will hold the next val. If this value is null, it means there is no next
    private Integer next = null;

    // iterator will stay 1 step ahead of actual 'next'
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            this.next = iterator.next();
        }
    }

    public Integer peek() {
        assertNextExists();
        return this.next;
    }

    @Override
    public Integer next() {
        assertNextExists();
        int returnVal = this.next;
        this.next = iterator.hasNext() ? iterator.next() : null;
        return returnVal;
    }

    @Override
    public boolean hasNext() {
        return this.next != null;
    }

    private void assertNextExists() {
        if (!hasNext()) {
            throw new RuntimeException("No element");
        }
    }
}
