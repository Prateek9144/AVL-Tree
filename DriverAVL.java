class DriverAVL {
    public static void main(String agr[]) {
        AVL obj = new AVL();
        obj.insert(40);
        obj.insert(30);
        obj.insert(20);
        obj.insert(101);
        obj.insert(75);
        obj.insert(150);
        obj.insert(60);
        obj.insert(99);
        obj.insert(132);
        System.out.println("Inorder Traversal");
        obj.infixTraverse(obj.root);
        System.out.println("\nRoot : " + obj.root.val);
        obj.Delete(132);
        obj.Delete(30);
        obj.Delete(75);
        obj.Delete(60);
        System.out.println("Inorder Traversal");
        obj.infixTraverse(obj.root);
        System.out.println("\nRoot : " + obj.root.val);

    }
}
