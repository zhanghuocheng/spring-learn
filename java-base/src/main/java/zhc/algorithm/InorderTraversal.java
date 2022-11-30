package zhc.algorithm;

import zhc.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        TreeNode treeNode1=new TreeNode(2);
        TreeNode treeNode2=new TreeNode(3);

        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        TreeNode treeNode3=new TreeNode(4);
        TreeNode treeNode4=new TreeNode(5);
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        TreeNode treeNode5=new TreeNode(6);
        treeNode3.left=treeNode5;

        new InorderTraversal().inorderTraversal(treeNode).stream().forEach(System.out::println);



    }

    public  List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }

        ArrayList arrayList=new ArrayList();
        return  test(arrayList,root);
    }

    public ArrayList test(ArrayList arrayList,TreeNode root){
        if(root.left!=null){
            test(arrayList,root.left);
        }
        arrayList.add(root.val);
        if(root.right!=null){
            test(arrayList,root.right);
        }
        return arrayList;
    }
}
