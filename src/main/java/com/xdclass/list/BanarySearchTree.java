package com.xdclass.list;

/**
 * @author Obsession.yin
 * @date 2020/3/10
 * 二叉查找树
 */
public class BanarySearchTree {

    int data;

    BanarySearchTree left;

    BanarySearchTree right;

    public BanarySearchTree(int data){
        this.data=data;
    }

    public void insert(BanarySearchTree root,int data){

        if(data > root.data){
            if(root.right == null){
                root.right = new BanarySearchTree(data);
            }else {
                insert(root.right,data);
            }
        }else {
            if (root.left == null){
                root.left = new BanarySearchTree(data);
            }else {
                insert(root.left,data);
            }
        }
    }

    public static void search (BanarySearchTree root){
        if(root != null){
            search(root.left);
            System.out.println(root.left);
            search(root.right);
            System.out.println(root.right);
        }
    }

    public static void main(String[] args) {
        int[] data ={3,2,6,4,7,5,1};
        BanarySearchTree root = new BanarySearchTree(data[0]);
        for (int i=1;i<data.length;i++) {
            root.insert(root, data[i]);
        }
        search(root);
    }
}
