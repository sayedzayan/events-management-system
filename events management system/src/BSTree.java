/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
// Class: BSTree
public class BSTree {
    private class Node {
        Attendee attendee;
        Node left, right;

        public Node(Attendee attendee) {
            this.attendee = attendee;
            this.left = this.right = null;
        }
    }

    private Node root;

    public BSTree() {
        root = null;
    }

    public void insert(Attendee a) {
        root = insertRec(root, a);
    }

    private Node insertRec(Node root, Attendee a) {
        if (root == null) {
            root = new Node(a);
            return root;
        }

        if (a.id < root.attendee.id) {
            root.left = insertRec(root.left, a);
        } else if (a.id > root.attendee.id) {
            root.right = insertRec(root.right, a);
        }

        return root;
    }

    public boolean search(int id) {
        return searchRec(root, id);
    }

    private boolean searchRec(Node root, int id) {
        if (root == null) {
            return false;
        }
        if (id == root.attendee.id) {
            return true;
        }
        return id < root.attendee.id ? searchRec(root.left, id) : searchRec(root.right, id);
    }

    public void preOrder(ArrayList<String> list) {
        preOrderRec(root, list);
    }

    private void preOrderRec(Node root, ArrayList<String> list) {
        if (root != null) {
            list.add(root.attendee.name);
            preOrderRec(root.left, list);
            preOrderRec(root.right, list);
        }
    }
}
