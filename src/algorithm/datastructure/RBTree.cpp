#include <stdio.h>
using namespace std;

class RBTree {

};

class RBTreeNode {
    RBTreeNode* left;
    RBTreeNode* right;
    int val;
    bool color;

    public:
        explicit RBTreeNode(int val) {
            this->val = val;
            this->color = true;
            this->left = &RBTreeNode();
            this->right = &RBTreeNode();
        }

        explicit RBTreeNode() {
            this->color = false;
            this->left = nullptr;
            this->right = nullptr;
        }

        bool is_null() {
            return (this->left == nullptr && this->right == nullptr);
        }

        void insert(int val) {
            if (this->is_null()) {
                this->val = val;
                RBTreeNode left = RBTreeNode();
                RBTreeNode right = RBTreeNode();
                this->left = &left;
                this->right = &right;
                return;
            }

            if (val > this->val) {
            } else {

            }
        }
};

int main() {
    RBTreeNode node1 = RBTreeNode();
    RBTreeNode node2 = RBTreeNode();
    printf("%p/n", &node1);
    printf("%p/n", &node2);
    return 0;
}