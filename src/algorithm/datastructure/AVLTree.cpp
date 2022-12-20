//
// Created by M Tong on 8/13/22.
//
#include <algorithm>
using namespace std;
class AVLTree {

};

class AVLTreeNode {
    AVLTreeNode* left;
    AVLTreeNode* right;
    int depth;
    int val;
public:
    explicit AVLTreeNode(int val) {
        this->val = val;
        this->left = nullptr;
        this->right = nullptr;
        this->depth = 0;
    }

    void insert(int val) {
        AVLTreeNode *node = (AVLTreeNode*)malloc(sizeof(AVLTreeNode));
        node->val = val;
        if (val > this->val) {
            if (this->right == nullptr) {
                this->right = node;
            } else {
                this->right->insert(val);
                this->right = this->rotate(this->right);
            }
        } else {
            if (this->left == nullptr) {
                this->left = node;       
            } else {
                this->left->insert(val);
                this->left = this->rotate(this->left);
            }
        }
        int leftDepth = this->left == nullptr ? -1 : this->left->depth;
        int rightDepth = this->right == nullptr ? -1 : this->right->depth;      
        this->depth = max(leftDepth, rightDepth) + 1;
    }

    AVLTreeNode* rotate(AVLTreeNode* node) {
        int leftDepth = node->left == nullptr ? -1 : node->left->depth;
        int rightDepth = node->right == nullptr ? -1 : node->right->depth;
        
        int childLeftDepth;
        int childRightDepth;
        if (leftDepth - rightDepth > 1) {
            childLeftDepth = node->left->left == nullptr ? -1:node->left->left->depth;
            childRightDepth = node->left->right == nullptr ? -1:node->left->right->depth;
            if (childLeftDepth > childRightDepth) {
                //do RR
                node = this->RR(node);
            } else {
                //do LR
                node = this->LRR(node);
            }
        } else if (rightDepth - leftDepth > 1) {
            childLeftDepth = node->right->left == nullptr ? -1:node->right->left->depth;
            childRightDepth = node->right->right == nullptr ? -1:node->right->right->depth;
            if (childRightDepth > childLeftDepth) {
                //do LL
                node = this->LR(node);
            } else {
                //do RLR
                node = this->RLR(node);
            }
        }
        this->updateDepth(node);
        return node;
    }

    int updateDepth (AVLTreeNode* node) {
        if (node == nullptr) return -1;
        int leftDepth = node->updateDepth(node->left);
        int rightDepth = node->updateDepth(node->right);
        node->depth = max(leftDepth, rightDepth) + 1;
        return node->depth;
    }

    AVLTreeNode* LR(AVLTreeNode* node) {
        AVLTreeNode* temp = node->right;
        node->right = temp->left;
        temp->left = node;
        return temp;
    }

    AVLTreeNode* RR(AVLTreeNode* node) {
        AVLTreeNode* temp = node->left;
        node->left = temp->right;
        temp->right = node;
        return temp;
    }

    AVLTreeNode* RLR(AVLTreeNode* node) {
        node->right = this->RR(node->right);
        return this->LR(node);
    }

    AVLTreeNode* LRR(AVLTreeNode* node) {
        node->left = this->LR(node->left);
        return this->RR(node);
    }
};

int main() {
    AVLTreeNode root = AVLTreeNode(5);
   
    root.insert(4);
    root.insert(3);
    root.insert(2);
    root.insert(1);
    root.insert(6);
    root.insert(7);
    root.insert(8);
    root.insert(9);
    root.insert(10);
    return 0;
}