package Tree;

import java.io.*;
import java.util.*;



public class P01991 {
    static class Node{
        char data;
        Node left;
        Node right;

        Node(char data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node node = new Node('A', null, null);
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char thisData = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(node, thisData, left, right);
        }

        Preorder(node);
        System.out.println(sb);

        sb = new StringBuilder();
        Inorder(node);
        System.out.println(sb);

        sb = new StringBuilder();
        Postorder(node);
        System.out.println(sb);

    }

    public static void insertNode(Node node, char thisData, char left, char right){
        if(node.data == thisData){
            if(left != '.') node.left = new Node(left, null, null);
            else node.left = null;

            if(right != '.') node.right = new Node(right, null, null);
            else node.right = null;
        }
        else{
            if(node.left != null) insertNode(node.left, thisData, left, right);
            if(node.right != null) insertNode(node.right, thisData, left, right);
        }
    }

    public static void Preorder(Node node){
        if(node.left == null && node.right == null){
            sb.append(node.data);
        }
        else{
            sb.append(node.data);
            if(node.left != null) Preorder(node.left);
            if(node.right != null) Preorder(node.right);
        }
    }

    public static void Inorder(Node node){
        if(node.left == null && node.right == null){
            sb.append(node.data);
        }
        else{
            if(node.left != null) Inorder(node.left);
            sb.append(node.data);
            if(node.right != null) Inorder(node.right);
        }
    }

    public static void Postorder(Node node){
        if(node.left == null && node.right == null){
            sb.append(node.data);
        }
        else{
            if(node.left != null) Postorder(node.left);
            if(node.right != null) Postorder(node.right);
            sb.append(node.data);
        }
    }
}
