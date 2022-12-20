#include <math.h>
#include <iostream>

using namespace std;
class RoundHole {
    private:
        double radius;
    public:
        RoundHole();
        RoundHole(double radius);
        int getRadius();
        bool fit(RoundPeg peg);
};

class RoundPeg {
    private:
        double radius;
    public:
        RoundPeg();
        RoundPeg(double radius);
        double getRadius();
};

class SquarePeg {
    private:
        double width;
    public:
        SquarePeg();
        SquarePeg(double width);
        double getWidth();
};

class SquarePegAdapter: public RoundPeg {
    private:
        SquarePeg peg;
    public:
        SquarePegAdapter(SquarePeg peg);
        double getRadius();
};
