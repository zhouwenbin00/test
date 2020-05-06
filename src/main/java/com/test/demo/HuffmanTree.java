package com.test.demo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树
 *
 * @author zwb
 */
public class HuffmanTree {

    /**
     * 节点
     *
     * @param <T>
     */
    public static class Node<T> implements Comparable<Node<T>> {
        T data;
        double weight;
        Node<T> leftChild;
        Node<T> rightChild;

        public Node(T data, double weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + ", weight=" + weight + '}';
        }

        @Override
        public int compareTo(Node<T> o) {
            if (o.weight > this.weight) {
                return 1;
            } else if (o.weight < this.weight) {
                return -1;
            }
            return 0;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }
    }

    public static <T> Node<T> createTree(List<Node<T>> nodes) {
        // 当节点数大于1个时
        while (nodes.size() > 1) {
            // 排序
            Collections.sort(nodes);
            Node<T> left = nodes.get(nodes.size() - 1);
            Node<T> right = nodes.get(nodes.size() - 2);
            // 创建一颗父节点
            Node<T> parent = new Node<>(null, left.weight + right.weight);
            parent.setLeftChild(left);
            parent.setRightChild(right);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        String s = JSON.toJSONString(nodes.get(0));
        System.out.println(s);

        return nodes.get(0);
    }

    public static void main(String[] args) {
        //
        List<Node<Integer>> list = new ArrayList<>();
        Node<Integer> node1 = new Node<>(50, 50);
        Node<Integer> node2 = new Node<>(11, 11);
        Node<Integer> node3 = new Node<>(22, 22);
        Node<Integer> node4 = new Node<>(33, 33);
        Node<Integer> node5 = new Node<>(44, 44);
        Node<Integer> node6 = new Node<>(55, 55);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        list.add(node6);
        Node<Integer> tree = HuffmanTree.createTree(list);
        System.out.println(tree);
    }
}
