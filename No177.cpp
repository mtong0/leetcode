#include <iostream>
#include <vector>

// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};


class Solution {
public:
    Node* connect(Node* root) {
        if(root == NULL) {
            return root;
        }
        
        std::vector<Node*> layer;
        layer.push_back(root);
        std::vector<Node*> nextLayer;

        while(layer.size() != 0) {
            for(int i = 0; i < layer.size(); i++) {
                if(i+1 == layer.size()) {
                    layer[i]->next = NULL;
                } else {
                    layer[i]->next = layer[i+1];
                }

                if(layer[i]->left != NULL) {
                    nextLayer.push_back(layer[i]->left);
                }
                if(layer[i]->right != NULL) {
                    nextLayer.push_back(layer[i]->right);
                }
            }

            layer.clear();
            layer.insert(layer.end(), nextLayer.begin(), nextLayer.end());
            nextLayer.clear();
        }
        return root;
    }
};