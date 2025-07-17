package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Trees {
    int data;
    Trees left;
    Trees right;
    public Trees(int data){
        this.data=data;
        left=null;
        right=null;
    }
    public static void recursivePreorderTraversal(Trees root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        recursivePreorderTraversal(root.left);
        recursivePreorderTraversal(root.right);
    }
    public static void recursiveInorderTraversal(Trees root){
        if(root==null){
            return;
        }
        recursiveInorderTraversal(root.left);
        System.out.print(root.data+" ");
        recursiveInorderTraversal(root.right);
    }
    public static void recursivePostorderTraversal(Trees root){
        if(root==null){
            return;
        }
        recursivePostorderTraversal(root.left);
        recursivePostorderTraversal(root.right);
        System.out.print(root.data+" ");
    }
    public static void recusiveTraversals(Trees root){
        System.out.print("recursivePreorderTraversal: ");
        Trees.recursivePreorderTraversal(root);
        System.out.println();
        System.out.print("recursiveInorderTraversal: ");
        Trees.recursiveInorderTraversal(root);
        System.out.println();
        System.out.print("recursivePostorderTraversal: ");
        Trees.recursivePostorderTraversal(root);
        System.out.println();
    }

    public static void iterativeLevelorderTraversals(Trees root){
        Queue<Trees> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Trees node = queue.poll();
            if(node==null){
                continue;
            }
            System.out.print(node.data+" ");
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    public static void iterativePreorderTraversals(Trees root){
        Stack<Trees> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Trees node = stack.pop();
            if(node==null){
                continue;
            }
            System.out.print(node.data+" ");
            stack.add(node.right);
            stack.add(node.left);
        }
    }
    public static void iterativeInorderTraversals(Trees root){
        Stack<Trees> stack = new Stack<>();
        Trees node = root;
        while(true){
            if(node!=null){
                stack.add(node);
                // System.out.print(node.data+" ");
                node = node.left;
            }
            else{
                if(stack.isEmpty()){
                    return;
                }
                node = stack.pop();
                System.out.print(node.data+" ");
                node = node.right;
            }
        }
    }
    public static void iterativePostorderTraversals2Stack(Trees root){
        Stack<Trees> stack1 = new Stack<>();
        Stack<Trees> stack2 = new Stack<>();
        Trees node = root;
        stack1.add(node);
        //s1 = 
        //s2 = 1 3 6 2 6 5
        while(true){
            if(!stack1.isEmpty()){
                node = stack1.pop();
                stack2.add(node);
                if(node.left!=null){
                    stack1.add(node.left);
                }
                if(node.right!=null){
                    stack1.add(node.right);
                }
            }
            else{
                break;
            }
        }
        while (!stack2.isEmpty()) {
            node = stack2.pop();
            System.out.print(node.data+" ");
        }
    }
    public static void iterativePostorderTraversals1Stack(Trees root){
        Trees curr = root;
        Stack<Trees> stack = new Stack<>();
        // 1 2
        while (curr!=null || !stack.isEmpty()) {
            if(curr!=null){
                stack.add(curr);
                curr=curr.left;
            }
            else{
                Trees temp = stack.peek().right;
                if(temp==null){ 
                    // leaf node
                    temp = stack.pop();
                    System.out.print(temp.data+" ");
                    while (!stack.isEmpty() && temp==stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }
                else{
                    curr=temp;
                }
            }
        }
    }
    public static void iterativeTraversals(Trees root){
        System.out.print("iterativePreorderTraversal: ");
        iterativePreorderTraversals(root);
        System.out.println();
        System.out.print("iterativeInorderTraversal: ");
        iterativeInorderTraversals(root);
        System.out.println();
        System.out.print("iterativePostorderTraversal2Stack: ");
        iterativePostorderTraversals2Stack(root);
        System.out.println();
        System.out.print("iterativePostorderTraversal1Stack: ");
        iterativePostorderTraversals1Stack(root);
        System.out.println();
        System.out.print("iterativeLevelorderTraversal: ");
        iterativeLevelorderTraversals(root);
        System.out.println();
    }
    public static void main(String[] args) {
        Trees root = new Trees(1);
        root.left= new Trees(2);
        root.right=new Trees(3);
        root.right.right=new Trees(4);
        root.left.left = new Trees(5);
        root.left.right = new Trees(6);

        // recusive traversals
        Trees.recusiveTraversals(root);
        System.out.println();
        // iterative traversals
        Trees.iterativeTraversals(root);
    }
}
