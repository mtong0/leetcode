#include <iostream>
#include <string>
#include <vector>
#include <map>


using namespace std;
class A {
public:
    int x;
    A() {

    }
    A(int val) {
        this->x = val;
    }
    void p() {
        printf("%d", x);
    }
};

class B {
public:
    int x;
    B() {

    }
    B(int val) {
        this->x = val;
    }
    void p() {
        printf("%d", x);
    }
};

class C : A, B {
    public:
        C() {

        }
};

int main() {
    A a(1);
    a.p();
}