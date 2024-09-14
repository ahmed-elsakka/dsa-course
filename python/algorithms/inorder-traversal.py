def inorder_traversal(node):
    if node is not None:
        inorder_traversal(node.left)
        print(node.value, end=" ")
        inorder_traversal(node.right)

        