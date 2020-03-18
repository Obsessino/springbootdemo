package com.xdclass.list;

/**
 * @author Obsession.yin
 * @date 2020/3/9
 */
public class MyLinkedList<E> {

    /**
     * 使用这个字段，来判断当前集合类是否被并发修改，即迭代器并发修改的fail-fast机制
     */
    private transient int modCount = 0;

    /**
     * 链表实际大小  list.size();
     */
    transient int size = 0;

    /**
     * 链表中的第一个节点
     */
    transient MyLinkedList.Node<E> first;

    /**
     * 链表中最后一个节点
     */
    transient MyLinkedList.Node<E> last;

    public int size(){
        return size;
    }


    /**
     * 添加元素
     * @param e
     * @return
     */
    public boolean add(E e){
        linkLast(e);
        return true;
    }

    /**
     * 在链表最后位置添加元素
     * @param e
     */
    private void linkLast(E e) {
        //1.获取最后一个元素
        final MyLinkedList.Node<E> l = last;
        //2.新建一个node 对象
        final Node<E>  newNode= new Node<>(l,e,null);
        //将新插入的节点定义为最后一个节点
        last = newNode;
        if(null == l){
            first = newNode;
        }else {
            l.next = newNode;
            size ++;
           // modCount ++;
        }
    }


    /**
     * 根据index获取元素
     * @param index
     * @return
     */
    public E get(int index){
        checkIndex(index);
        return node(index).item;
    }

    /**
     * 根据下标删除元素
     * @param index
     * @return
     */
    public E remove(int index){
        checkIndex(index);
        return unLink(node(index));

    }



    /**
     * 折半查找
     * index 小于 size/2 从第一个节点开始查找
     *          大于 size/2 从最后一个节点开始查找
     * @param index
     * @return
     */
    private Node<E> node(int index){
        if(index<(size>>1)){
            Node<E> x= first;
            for (int i=0;i<index;i++){
                x = x.next;
            }
            return x;
        }else {
            Node<E> x= last;
            for(int i=size-1;i>index;i--){
                x = x.prev;
            }
            return x;
        }
    }

    /**
     * 删除元素  其实就是把一个节点的三个属性都置空
     * 置空的目的方便垃圾回收
     * @param e
     * @return
     */
    private E unLink(Node<E> e){
        final E element = e.item;
        final Node<E> next = e.next;
        final Node<E> prev = e.prev;
        if(prev == null){
            first=next;
        }else {
            prev.next=next;
            e.prev=null;
        }
       if (next == null){
           last=prev;
       }else {
           next.prev=prev;
           e.next=null;
       }
       e.item=null;
       size --;
       //modCount ++;
       return element;
    }

    /**
     * 判断 index是否越界
     * @param index
     */
    private void checkIndex(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("下标越界异常");
        }
    }


    /**
     * 使用静态内部类 Node 对象来描述一个节点
     * @param <E>
     */
    private static class Node<E> {
        /**
         * 当前节点实际存储的值 value
         */
        E item;
        /**
         * 当前节点下一个节点的引用
         */
        MyLinkedList.Node<E> next;
        /**
         * 当前节点上一个节点的引用
         */
        MyLinkedList.Node<E> prev;

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
