#include <math.h>
#include <iostream>

using namespace std;

class RoundPeg {
    private:
        double radius;
    public:
        RoundPeg() {
        }

        RoundPeg(double radius) {
            this->radius = radius;
        }

        double getRadius() {
            return this->radius;
        }
};

class RoundHole {
    private:
        double radius;
    public:
        RoundHole(){}
        RoundHole(double radius) {
            this->radius = radius;
        }

        int getRadius() {
            return this->radius;
        }

        bool fit(RoundPeg peg) {
            return peg.getRadius() <= this->radius;
        }
};

class SquarePeg {
    private:
        double width;
    public:
        SquarePeg(){}
        SquarePeg(double width) {
            this->width = width;
        }

        double getWidth() {
            return this->width;
        }
};

class SquarePegAdapter: public RoundPeg {
    private:
        SquarePeg peg;
    public:
        SquarePegAdapter(SquarePeg peg) {
            this->peg = peg;
        }

        double getRadius() {
            return this->peg.getWidth() * sqrt(2)/2;
        }
};

int main(int argc, char const *argv[]) {
    
    RoundHole hole = RoundHole(3);
    RoundPeg rPeg = RoundPeg(3);
    cout << hole.fit(rPeg) << endl;

    SquarePeg sPeg = SquarePeg(5);
    // cout << hole.fit(sPeg) << endl;
    SquarePegAdapter sPegAdapter = SquarePegAdapter(sPeg);
    cout << hole.fit(sPegAdapter) << endl;
    return 0;
}
