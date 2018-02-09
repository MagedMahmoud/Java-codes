class BinaryNode:
    def __init__(self, value):
        self.data = value
        self.left = None
        self.right = None

def contains(root, value):
    if root is None:
        return False
        
    if value == root.data:
        return True
    if value < root.data:
        return contains(root.left, value)
    else:
        return contains(root.right, value)

def insert(root, value):
    if root is None:
        root = BinaryNode(value)
    else:
        if value > root.data:
            if root.right is None:
                root.right = BinaryNode(value)
            else:
                return insert(root.right, value)
        else:
            if root.left is None:
                root.left = BinaryNode(value)
            else:
                return insert(root.left, value)

def getMin(root):
    if root is None:
        return False
    
    elif root.left is None:
        return root
    
    return getMin(root.left)

def getMax(root):
    if root is None:
        return False
    
    elif root.right is None:
        return root
    
    return getMax(root.right)


def remove(root, value, parent = None):
    if root is None:
        return False
    elif value < root.data:
        return remove(root.left, value, root)
    elif value > root.data:
        return remove(root.right, value, root)
    else:
        if root.right is not None:
            parentRoot = root.right 
            removeRoot = root.right
            
            if root.right.left is None:
                root.data = root.right.data
                root.right = root.right.right
                parentRoot = None
                del parentRoot
            else:
                while(removeRoot.left is not None):
                    parentRoot = removeRoot
                    removeRoot = removeRoot.left
                
                root.data = removeRoot.data
                parentRoot.left = removeRoot.right
                removeRoot = None
                del removeRoot
        
        elif root.left is not None:
            parent.right = root.left
            root = None
            del root
        else:
            if parent.left is root:
                parent.left = None
                root = None
                del root
            else:
                parent.right = None 
                root = None
                del root

def closest(root, target):
    if root is None:
        return ValueError("Binary Search Tree is Empty")
    
    node = root
    best = node
    distance = abs(root.data - target)
    
    while node is not None:
        if abs(node.data - target) < distance:
            best = node
            distance = abs(node.data - target)
        
        if target < node.data:
            node = node.left
        elif target > node.data:
            node = node.right
        else:
            print("The closest value to " + str(target) + " is " + str(target))
            return target
        
    print("The closest value to " + str(target) + " is " + str(best.data))
    return best.data

def preOrder(root):
    if root is not None:
        print(root.data)
        preOrder(root.left)
        preOrder(root.right)

def inOrder(root):
    if root is not None:
        inOrder(root.left)
        print(root.data)
        inOrder(root.right)

def postOrder(root):
    if root is not None:
        postOrder(root.left)
        postOrder(root.right)
        print(root.data)


def levelOrder(root):
    currentLevel = [root]
    while len(currentLevel) > 0:
        nextLevel = []
        for element in currentLevel:
            print(element.data)
            if element.left is not None:
                nextLevel.append(element.left)
            
            if element.right is not None:
                nextLevel.append(element.right)
        currentLevel = nextLevel

def node_depth(root, value):
    if root.data == value or root is None:
        return 0
    elif value < root.data:
        return 1 + node_depth(root.left, value)
    return 1 + node_depth(root.right, value)



BST = BinaryNode(5)
insert(BST,2)
insert(BST, -4)
insert(BST, 3)
insert(BST, 18)
insert(BST, 21)
insert(BST, 19)
insert(BST, 25)

print()


print(node_depth(BST, 3))


# print()

# levelOrder2(BST)

# print("5 ? " + str(contains(BST, 5)))
# print("2 ? " + str(contains(BST, 2)))
# print("-4 ? " + str(contains(BST, -4)))
# print("3 ? " + str(contains(BST, 3)))
# print("18 ? " + str(contains(BST, 18)))
# print("21 ? " + str(contains(BST, 21)))
# print("19 ? " + str(contains(BST, 19)))
# print("25 ? " + str(contains(BST, 25)))


print()